package com.example.tourguide

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SquaresFragment : Fragment() {
    private var linearLayoutManager: LinearLayoutManager? = null
    private var adapter: LocationAdapter? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView: View = inflater.inflate(R.layout.location_list, container, false)

        val location = ArrayList<Location>()
        location.add(
            Location(
                "Victory Square",
                "Pervomay District",
                R.drawable.victorysquare,
                getString(R.string.victory),
                getString(R.string.addressvictory),
                NO_NUMBER_PROVIDED,
                "42.879124,74.6616228"
            )
        )
        location.add(
            Location(
                "Ala-too Square",
                "Pervomay District",
                R.drawable.alatoosquare,
                getString(R.string.central),
                getString(R.string.addresscentral),
                NO_NUMBER_PROVIDED,
                "42.876610,74.603714"
            )
        )
        location.add(
            Location(
                "Toktogul Square",
                "Pervomay District",
                R.drawable.toktogulsquare,
                getString(R.string.toktogul),
                getString(R.string.addresstoktogul),
                NO_NUMBER_PROVIDED,
                "42.877993,74.612747"
            )
        )

        val recyclerView = rootView.findViewById<RecyclerView>(R.id.rvLocation)
        linearLayoutManager = LinearLayoutManager(activity)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = linearLayoutManager
        adapter = LocationAdapter()
        recyclerView.adapter = adapter
        adapter!!.setData(location)
        return rootView
    }

}