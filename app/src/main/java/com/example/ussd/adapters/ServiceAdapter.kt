package com.example.ussd.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.ussd.Fragment.PageType
import com.example.ussd.R
import com.example.ussd.model.XizmatInfoModel

class ServiceAdapter(
    private val context: Context,
    private var ServiceList: ArrayList<XizmatInfoModel>,
    val pageType: PageType,
) :
    RecyclerView.Adapter<ServiceAdapter.VH>() {
    fun reloadData(Servise: ArrayList<XizmatInfoModel>) {
        ServiceList = Servise
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.xizmatlar, parent, false)
        return VH(view)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        val ServiceList = ServiceList[position]
        holder.tvService.text = ServiceList.xizmat_nomi
        holder.tvInfo.text = ServiceList.info

        when (pageType) {
            PageType.Ucell -> {
                holder.tvService.setTextColor(ContextCompat.getColor(context, R.color.ucell))

            }
            PageType.Beeline -> {
                holder.tvService.setTextColor(ContextCompat.getColor(context, R.color.beeline))

            }
            PageType.Mobiuz -> {
                holder.tvService.setTextColor(ContextCompat.getColor(context, R.color.mobiuz))

            }
            PageType.Uzmobile -> {
                holder.tvService.setTextColor(ContextCompat.getColor(context, R.color.uzmobile))

            }
        }

        holder.itemView.setOnClickListener {

        }


    }


    override fun getItemCount(): Int {
        return ServiceList.size
    }

    class VH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvService = itemView.findViewById<TextView>(R.id.tv_service)
        val tvInfo = itemView.findViewById<TextView>(R.id.info_service)
    }


}