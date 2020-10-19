package com.example.tourguide

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MuseumsFragment : Fragment() {
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
                "Museum of Fine Arts",
                "Pervomay District",
                R.drawable.finearts,
                getString(R.string.finearts),
                getString(R.string.addressfinearts),
                getString(R.string.phonefinearts),
                "42.878598,74.611021"
            )
        )
        location.add(
            Location(
                "Mikhail Frunze Museum",
                "Pervomay District",
                R.drawable.frunzemuseum,
                getString(R.string.frunze),
                getString(R.string.addressfrunze),
                getString(R.string.phonefrunze),
                "42.880518,74.605090"
            )
        )
        location.add(
            Location(
                "Museum of Great Emptiness",
                "Ortosay District",
                R.drawable.greatemptiness,
                getString(R.string.greatemptiness),
                getString(R.string.addressemptiness),
                getString(R.string.phoneemptiness),
                "42.802908, 74.594137"
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