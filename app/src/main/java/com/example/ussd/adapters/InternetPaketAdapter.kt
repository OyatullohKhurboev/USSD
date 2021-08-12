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
import com.example.ussd.model.MbPaketInfoModel

class InternetPaketAdapter(
    private val context: Context,
    private var MbPaketList: ArrayList<MbPaketInfoModel>,
    val pageType: PageType,
) :
    RecyclerView.Adapter<InternetPaketAdapter.MbPaketViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MbPaketViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.mb_paket, parent, false)
        return MbPaketViewHolder(view)
    }


    fun reloadData(mbPaket: ArrayList<MbPaketInfoModel>) {
        MbPaketList = mbPaket
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: MbPaketViewHolder, position: Int) {
        val MbPaketList = MbPaketList[position]
        holder.tvInternet.setText(MbPaketList.paket_nomi)
        holder.tvPaket.setText(MbPaketList.paket_nomi)
        holder.tvInfo.setText(MbPaketList.info)

        when (pageType) {
            PageType.Ucell -> {
                holder.tvPaket.setTextColor(ContextCompat.getColor(context, R.color.ucell))
                holder.cardViewInternet.setCardBackgroundColor(
                    ContextCompat.getColor(
                        context,
                        R.color.ucell
                    )
                )
            }
            PageType.Beeline -> {
                holder.tvPaket.setTextColor(ContextCompat.getColor(context, R.color.beeline))
                holder.cardViewInternet.setCardBackgroundColor(
                    ContextCompat.getColor(
                        context,
                        R.color.beeline
                    )
                )
            }
            PageType.Mobiuz -> {
                holder.tvPaket.setTextColor(ContextCompat.getColor(context, R.color.mobiuz))
                holder.cardViewInternet.setCardBackgroundColor(
                    ContextCompat.getColor(
                        context,
                        R.color.mobiuz
                    ))
            }
            PageType.Uzmobile -> {
                holder.tvPaket.setTextColor(ContextCompat.getColor(context, R.color.uzmobile))
                holder.cardViewInternet.setCardBackgroundColor(
                    ContextCompat.getColor(
                        context,
                        R.color.uzmobile
                    )
                )
            }
        }

        holder.itemView.setOnClickListener {

        }


    }


    override fun getItemCount(): Int {
        return MbPaketList.size
    }

    class MbPaketViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvInternet = itemView.findViewById<TextView>(R.id.tv_internet)
        val cardViewInternet = itemView.findViewById<CardView>(R.id.cv_internet)

        val tvPaket = itemView.findViewById<TextView>(R.id.tv_internet_paket)
        val tvInfo = itemView.findViewById<TextView>(R.id.tv_internet_info)
    }

}