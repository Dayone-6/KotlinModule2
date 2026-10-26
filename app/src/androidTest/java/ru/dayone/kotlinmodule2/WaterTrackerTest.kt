package ru.dayone.kotlinmodule2

import androidx.compose.ui.test.assertHasClickAction
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.StateRestorationTester
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import ru.dayone.kotlinmodule2.ui.theme.KotlinModule2Theme

@RunWith(AndroidJUnit4::class)
class WaterTrackerTest {
    @get:Rule
    val composeRule = createComposeRule()

    private fun showTracker() {
        composeRule.setContent {
            KotlinModule2Theme { WaterTracker() }
        }
    }

    private fun addWater(times: Int) {
        repeat(times) { composeRule.onNodeWithText("+250 мл").performClick() }
    }

    private fun finishDay() {
        composeRule.onNodeWithText("Завершить день").performClick()
    }

    @Test
    fun addButtonAdds250MlOnEveryClick() {
        showTracker()
        composeRule.onNodeWithText("100 мл").assertIsDisplayed()
        composeRule.onNodeWithText("+250 мл").assertIsDisplayed().assertHasClickAction()
        addWater(1)
        composeRule.onNodeWithText("350 мл").assertIsDisplayed()
        addWater(1)
        composeRule.onNodeWithText("600 мл").assertIsDisplayed()
    }

    @Test
    fun finishDayButtonResetsWater() {
        showTracker()
        addWater(2)
        composeRule.onNodeWithText("Завершить день").assertIsDisplayed().assertHasClickAction()
        finishDay()
        composeRule.onNodeWithText("0 мл").assertIsDisplayed()
        composeRule.onNodeWithText("Дней подряд с 1500 мл и больше: 0").assertIsDisplayed()
    }

    @Test
    fun consecutiveDaysTextIsInitiallyZero() {
        showTracker()
        composeRule.onNodeWithText("Дней подряд с 1500 мл и больше: 0").assertIsDisplayed()
    }

    @Test
    fun meetingGoalIncrementsStreakIncludingExactly1500Ml() {
        showTracker()
        addWater(6) // 100 + 6 * 250 = 1600 мл.
        finishDay()
        composeRule.onNodeWithText("Дней подряд с 1500 мл и больше: 1").assertIsDisplayed()
        addWater(6) // После сброса — ровно 1500 мл.
        finishDay()
        composeRule.onNodeWithText("0 мл").assertIsDisplayed()
        composeRule.onNodeWithText("Дней подряд с 1500 мл и больше: 2").assertIsDisplayed()
    }

    @Test
    fun dayBelowGoalResetsExistingStreak() {
        showTracker()
        addWater(6)
        finishDay()
        addWater(5) // 1250 мл — цель не достигнута.
        finishDay()
        composeRule.onNodeWithText("0 мл").assertIsDisplayed()
        composeRule.onNodeWithText("Дней подряд с 1500 мл и больше: 0").assertIsDisplayed()
    }

    @Test
    fun emptyDayResetsExistingStreak() {
        showTracker()
        addWater(6)
        finishDay()
        finishDay()
        composeRule.onNodeWithText("Дней подряд с 1500 мл и больше: 0").assertIsDisplayed()
    }

    @Test
    fun waterAndStreakSurviveStateRestoration() {
        val restorationTester = StateRestorationTester(composeRule)
        restorationTester.setContent {
            KotlinModule2Theme { WaterTracker() }
        }
        addWater(6)
        finishDay()
        addWater(2)
        restorationTester.emulateSavedInstanceStateRestore()
        composeRule.onNodeWithText("500 мл").assertIsDisplayed()
        composeRule.onNodeWithText("Дней подряд с 1500 мл и больше: 1").assertIsDisplayed()
    }
}
