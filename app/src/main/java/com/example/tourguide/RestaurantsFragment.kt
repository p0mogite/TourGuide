package com.example.tourguide

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RestaurantsFragment : Fragment() {
    private var linearLayoutManager: LinearLayoutManager? = null
    var adapter: LocationAdapter? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView: View = inflater.inflate(R.layout.location_list, container, false)

        val location = ArrayList<Location>()
        location.add(
            Location(
                "Sierra",
                "Pervomay District",
                R.drawable.sierra,
                getString(R.string.sierra),
                getString(R.string.addresssierra),
                getString(R.string.phonesierra),
                "42.874564,74.588627"
            )
        )
        location.add(
            Location(
                "Friends",
                "Pervomay District",
                R.drawable.friends,
                getString(R.string.friends),
                getString(R.string.addressfriends),
                getString(R.string.phonefriends),
                "42.872755,74.598389"
            )
        )
        location.add(
            Location(
                "Navat",
                "Oktyabr District",
                R.drawable.navat,
                getString(R.string.navat),
                getString(R.string.addressnavat),
                getString(R.string.phonenavat),
                "42.880518,74.605090"
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