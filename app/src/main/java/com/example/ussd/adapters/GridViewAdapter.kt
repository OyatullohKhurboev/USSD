package com.example.ussd.adapters

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.example.ussd.R
import com.example.ussd.model.GridViewModel

class GridViewAdapter(var context: Context, var arrayList: ArrayList<GridViewModel>, var color: Int) : BaseAdapter() {
    override fun getCount(): Int {
        return arrayList.size
    }

    fun updateColor(color: Int) {
        this.color = color
        notifyDataSetChanged()
    }


    override fun getItem(position: Int): Any {
        return arrayList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View = View.inflate(context, R.layout.grid_view_list_item, null)
        val icons: ImageView = view.findViewById(R.id.icons_image)
        val names: TextView = view.findViewById(R.id.title_text)
        icons.setColorFilter(ContextCompat.getColor(context, color))
        val listItem: GridViewModel = arrayList.get(position)

        icons.setImageResource(listItem.icons!!)
        names.text = listItem.name
        return view
    }

}