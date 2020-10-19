package com.example.tourguide

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.widget.AdapterView
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.list_item.view.*
import java.security.AccessController.getContext

class LocationAdapter :
    RecyclerView.Adapter<LocationViewHolder>() {
    var mLocation: ArrayList<Location> = ArrayList()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocationViewHolder {
        return LocationViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: LocationViewHolder, position: Int) {
        val currentLocation = mLocation[position]
        holder.district.text = currentLocation.District
        holder.locationName.text = currentLocation.Name
        Glide.with(holder.image).load(currentLocation.imageResourceId).into(holder.image)
        holder.description.text = currentLocation.Description
        holder.address.text = currentLocation.Address
        fun seeOnMap(view: TextView?) {
            holder.address.setOnClickListener {
                var coordinate = currentLocation.Coordinate
                val intent = Intent(Intent.ACTION_VIEW)
                intent.data = Uri.parse("geo:$coordinate?18")
                view!!.context.startActivity(intent)
            }
        }
        seeOnMap(holder.address)
        if (currentLocation.hasNumber()) {
            holder.number.text = currentLocation.Number
            holder.number.visibility = View.VISIBLE
            fun makeCall(view: TextView?) {
                holder.number.setOnClickListener {
                    var number = currentLocation.Number
                    val intent = Intent(Intent.ACTION_DIAL)
                    intent.data = Uri.parse("tel:$number")
                    view!!.context.startActivity(intent)
                }
            }
            makeCall(holder.number)
        } else {
            holder.view.visibility = View.GONE
        }
        holder.info.visibility = View.GONE
        holder.textContainer.setOnClickListener() {
            if (holder.info.visibility == View.VISIBLE) {
                holder.info.visibility = View.GONE
            }
            else {
                holder.info.visibility = View.VISIBLE
            }
        }
    }

    override fun getItemCount(): Int {
        return mLocation.size
    }
    fun setData(location: ArrayList<Location>) {
        mLocation.addAll(location)
        notifyDataSetChanged()
    }
}

class LocationViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val district: TextView = itemView.district
    val locationName: TextView = itemView.location_name
    val image: ImageView = itemView.image
    val description: TextView = itemView.info
    val address: TextView = itemView.address
    val number: TextView = itemView.phone
    val view: LinearLayout = itemView.number
    val textContainer: View = itemView.text_container
    val info: View = itemView.more
}

