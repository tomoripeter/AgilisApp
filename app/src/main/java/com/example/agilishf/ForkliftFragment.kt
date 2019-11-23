package com.example.agilishf

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.agilishf.adapter.ForkliftListAdapter
import kotlinx.android.synthetic.main.fragment_forklift.*
import kotlin.random.Random

class ForkliftFragment : Fragment() {

    companion object {
        val loadPercentages = ArrayList<Int>()
    }

    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle? ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.fragment_forklift, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (loadPercentages.isEmpty()) {
            for (i in 0..19)
                loadPercentages.add(Random.nextInt(100))
        }

        forklift_list.layoutManager = LinearLayoutManager(this.context, RecyclerView.VERTICAL, false)
        val adapter = ForkliftListAdapter(loadPercentages)
        forklift_list.adapter = adapter
    }
}