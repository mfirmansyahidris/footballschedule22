package com.dev.fi.footballschedule2

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.*
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.dev.fi.footballschedule2.ui.detailMatch.DetailMatchActivity
import com.dev.fi.footballschedule2.ui.listLeague.ListLeagueActivity
import com.dev.fi.footballschedule2.ui.listMatch.ListMatchActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


/**
 ****************************************
created by -manca-
.::manca.fi@gmail.com ::.
 ****************************************
 */

@RunWith(AndroidJUnit4::class)
class EspressoTest1 {
    @Rule
    @JvmField
    var listLeagueActivity = ActivityTestRule(ListLeagueActivity::class.java)

    @Test
    @Throws(Exception::class)
    fun action() {
        onView(withId(R.id.rv_league))
                .check(matches(isDisplayed()))

        onView(withId(R.id.rv_league)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(20))

        onView(withId(R.id.rv_league)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(1))

        registerIdlingResources(listLeagueActivity.activity.countingIdlingResouce)

        onView(withText("Italian Serie A"))
                .check(matches(isDisplayed()))
        onView(withText("Italian Serie A")).perform(click())

        registerIdlingResources(ListMatchActivity.prevMatchCountingIdlingResource)
        onView(withText("Next Match")).perform(click())
        registerIdlingResources(ListMatchActivity.nextMatchCountingIdlingResource)
        onView(withText("Favorites")).perform(click())
        registerIdlingResources(ListMatchActivity.prevMatchCountingIdlingResource)
        onView(withText("Last Match")).perform(click())

        onView(withId(R.id.rv_match_prev)).perform(
                RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(2, click()))

        registerIdlingResources(DetailMatchActivity.detailCountingIdlingResouce)
        onView(withId(R.id.add_to_favorite)).perform(click())
        pressBack()

        onView(withText("Next Match")).perform(click())
        registerIdlingResources(ListMatchActivity.nextMatchCountingIdlingResource)
        onView(withId(R.id.rv_match_next)).perform(
                RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(3, click()))
        registerIdlingResources(DetailMatchActivity.detailCountingIdlingResouce)
        onView(withId(R.id.add_to_favorite)).perform(click())
        pressBack()

        onView(withText("Favorites")).perform(click())
        onView(withId(R.id.rv_match_favorite)).perform(
                RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        registerIdlingResources(DetailMatchActivity.detailCountingIdlingResouce)
        onView(withId(R.id.add_to_favorite)).perform(click())
        pressBack()

        onView(withId(R.id.rv_match_favorite)).perform(
                RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        registerIdlingResources(DetailMatchActivity.detailCountingIdlingResouce)
        onView(withId(R.id.add_to_favorite)).perform(click())
        pressBack()
        pressBack()
    }
}