package com.example.agilishf

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.components.YAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.formatter.ValueFormatter
import kotlinx.android.synthetic.main.fragment_statistics.*
import kotlin.collections.ArrayList
import kotlin.random.Random

class StatisticsFragment : Fragment() {

    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle? ): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        return inflater.inflate(R.layout.fragment_statistics, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val stat = ArrayList<Entry>()

        for(i in 0..11) {
            stat.add(Entry(i.toFloat(), Random.nextInt(50,100).toFloat()))
        }


        val lineDataSet = LineDataSet(stat,"Honapok statisztikaja")
        lineDataSet.color = R.color.appBlue
        lineDataSet.lineWidth = 5f
        lineDataSet.circleRadius = 8f
        lineDataSet.circleHoleColor = R.color.appBlue

        val xAxis = monthlyLineStat.xAxis
        xAxis.position = XAxis.XAxisPosition.BOTTOM
        xAxis.setDrawGridLines(false)
        xAxis.textColor = R.color.appBlue

        val months = arrayListOf<String>("Jan", "Feb", "March", "Apr", "May", "June", "July", "Aug",
            "Sept","Oct", "Nov", "Dec")

        val xAxisValueFormatter = object: ValueFormatter(){
            override fun getFormattedValue(value: Float): String {
                return months[value.toInt()]
            }
        }
        xAxis.valueFormatter = xAxisValueFormatter

        val yAxisRight = monthlyLineStat.getAxis(YAxis.AxisDependency.RIGHT)
        yAxisRight.isEnabled = false

        val yAxisLeft = monthlyLineStat.getAxis(YAxis.AxisDependency.LEFT)
        yAxisLeft.axisMinimum = 0f
        yAxisLeft.axisMaximum = 100f
        yAxisLeft.setDrawAxisLine(false)
        yAxisLeft.textColor = R.color.appBlue

        val lineData = LineData(lineDataSet)
        lineData.setValueTextColor(R.color.appBlue)

        monthlyLineStat.data = lineData
        monthlyLineStat.legend.isEnabled = false
        monthlyLineStat.description.isEnabled = false
        monthlyLineStat.setGridBackgroundColor(R.color.appBlue)
        monthlyLineStat.setBorderColor(R.color.appBlue)
        monthlyLineStat.invalidate()
    }
}