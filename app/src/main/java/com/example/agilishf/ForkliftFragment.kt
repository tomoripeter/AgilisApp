package com.example.agilishf

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.agilishf.adapter.ForkliftList_Adapter
import kotlinx.android.synthetic.main.fragment_forklift.*
import kotlin.random.Random

class ForkliftFragment : Fragment() {

    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle? ): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        return inflater.inflate(R.layout.fragment_forklift, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val loadPercentes = ArrayList<Int>()
        for (i in 0..19)
            loadPercentes.add(Random.nextInt(100))

        forklift_list.layoutManager = LinearLayoutManager(this.context, RecyclerView.VERTICAL, false)
        val adapter = ForkliftList_Adapter(loadPercentes)
        forklift_list.adapter = adapter
    }
}