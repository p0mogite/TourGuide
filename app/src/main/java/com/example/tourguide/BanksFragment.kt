package com.example.tourguide

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class BanksFragment : Fragment() {
    var linearLayoutManager: LinearLayoutManager? = null
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
                "KICB",
                "Pervomay District",
                R.drawable.kicb,
                getString(R.string.kicb),
                getString(R.string.addresskicb),
                getString(R.string.phonekicb),
                "42.868958,74.607590"
            )
        )
        location.add(
            Location(
                "Demir Bank",
                "Leninsky District",
                R.drawable.demirbank,
                getString(R.string.demir),
                getString(R.string.addressdemir),
                getString(R.string.phonedemir),
                "42.843796,74.581552"
            )
        )
        location.add(
            Location(
                "Optima bank",
                "Pervomay District",
                R.drawable.optima,
                getString(R.string.optima),
                getString(R.string.addressoptima),
                getString(R.string.phoneoptima),
                "42.844135, 74.608332"
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