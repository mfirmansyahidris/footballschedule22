package com.dev.fi.footballschedule2.ui.listMatch

import android.view.LayoutInflater
import android.view.MenuItem
import android.widget.TextView
import androidx.test.espresso.idling.CountingIdlingResource
import com.dev.fi.footballschedule2.R
import com.dev.fi.footballschedule2.base.BaseActivity
import com.dev.fi.footballschedule2.ui.listMatch.fragments.FavoriteMatchFragment
import com.dev.fi.footballschedule2.ui.listMatch.fragments.NextMatchFragment
import com.dev.fi.footballschedule2.ui.listMatch.fragments.PrevMatchFragment
import com.dev.fi.footballschedule2.utils.ViewPagerAdapter
import kotlinx.android.synthetic.main.activity_list_match.*

/**
 ****************************************
created by -manca-
.::manca.fi@gmail.com ::.
 ****************************************
 */

class ListMatchActivity : BaseActivity() {
    override fun getLayoutResource(): Int = R.layout.activity_list_match

    override fun getToolbarResource(): Int = R.id.main_toolbar

    override fun getToolbarTitle(): String = getString(R.string.title_footBallMatchSchedule)

    override fun mainCode() {
        //setup view pager
        val viewPagerAdapter = ViewPagerAdapter(supportFragmentManager) // TODO Call child fragment manager in nested fragment
        viewPagerAdapter.addFragment(PrevMatchFragment())
        viewPagerAdapter.addFragment(NextMatchFragment())
        viewPagerAdapter.addFragment(FavoriteMatchFragment())
        vp_home.adapter = viewPagerAdapter


        //setup tablayout
        tl_home.setupWithViewPager(vp_home)
        setupTab(getString(R.string.nav_lastMatch), 0, R.drawable.ic_beach_access_black_24dp) //custom layout
        setupTab(getString(R.string.nav_nextMatch), 1, R.drawable.ic_date_range_black_24dp) //custom layout
        setupTab(getString(R.string.nav_favorites), 2, R.drawable.ic_stars_black_24dp) //custom layout

    }

    private fun setupTab(title: String, position: Int, icon: Int) {
        val tabHome = LayoutInflater.from(this).inflate(R.layout.layer_custom_tab, null) as TextView
        tabHome.text = title
        tabHome.setCompoundDrawablesWithIntrinsicBounds(0, icon, 0, 0)
        tl_home.getTabAt(position)?.customView = tabHome
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        finish()
        return super.onOptionsItemSelected(item)
    }

    companion object {
        var prevMatchCountingIdlingResource = CountingIdlingResource("PREVMATCH")
        var nextMatchCountingIdlingResource = CountingIdlingResource("NEXTMATCH")
    }
}