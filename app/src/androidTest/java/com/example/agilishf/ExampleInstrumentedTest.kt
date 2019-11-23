package com.example.agilishf

import android.widget.TextView
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.internal.runner.junit4.statement.UiThreadStatement.runOnUiThread
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import com.github.mikephil.charting.data.Entry
import com.google.android.material.bottomnavigation.BottomNavigationView
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    @Rule
    @JvmField
    val rule : ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java)

    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.example.agilishf", appContext.packageName)
    }

    @Test
    fun testBottomNavigationViewWorking() {
        val botNavView = rule.activity.findViewById<BottomNavigationView>(R.id.bottom_navigation_view)
        runOnUiThread {
            botNavView.selectedItemId = R.id.home_button
        }
        runOnUiThread{
            botNavView.selectedItemId = R.id.statistics_button
        }
        runOnUiThread{
            botNavView.selectedItemId = R.id.forklift_button
        }
    }

    @Test
    fun testHomeFragmentWorking() {
        val botNavView = rule.activity.findViewById<BottomNavigationView>(R.id.bottom_navigation_view)
        val homeText = rule.activity.findViewById<TextView>(R.id.home_title)
        botNavView.selectedItemId = R.id.home_button
        assertEquals(homeText.text, "RegisTruck")
    }

    @Test
    fun testStatisticsFragmentWorking() {
        val botNavView = rule.activity.findViewById<BottomNavigationView>(R.id.bottom_navigation_view)
        for (i in 0..11)
        {
            StatisticsFragment.stat.add(Entry(i.toFloat(), (i*5).toFloat()))
        }
        runOnUiThread {
            botNavView.selectedItemId = R.id.statistics_button
        }
    }

    @Test
    fun testForkliftFragmentWorking() {
        val botNavView = rule.activity.findViewById<BottomNavigationView>(R.id.bottom_navigation_view)
        for (i in 0..15)
        {
            ForkliftFragment.loadPercentages.add(i*5)
        }
        runOnUiThread{
            botNavView.selectedItemId = R.id.forklift_button
        }
    }
}
