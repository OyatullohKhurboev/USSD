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
import com.example.ussd.model.DaqiqaInfoModel
import com.example.ussd.model.MbPaketInfoModel

class DaqiqaAdapter(
    private val context: Context,
    private var DaqiqaList: ArrayList<DaqiqaInfoModel>,
    val pageType: PageType,
) :
    RecyclerView.Adapter<DaqiqaAdapter.VH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.daqiqa_minut, parent, false)
        return VH(view)
    }


    fun reloadData(DaqiqaToplam: ArrayList<DaqiqaInfoModel>) {
        DaqiqaList = DaqiqaToplam
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        val DaqiqaList = DaqiqaList[position]
        holder.tvToplam.text = DaqiqaList.name
        holder.tvDaqNarx.text = DaqiqaList.tv_narxi
        holder.tvSom.text = DaqiqaList.narxi
        holder.tvMuddat.text = DaqiqaList.tv_muddat
        holder.tvKun.text = DaqiqaList.mudat
        holder.tvActive.text = DaqiqaList.Faollashtirish
//        holder.tvToplam.text = DaqiqaList.name
//
//        holder.tvActive.text = DaqiqaList.Faollashtirish
//
//        holder.tvCode.text = DaqiqaList.mudat
//
//        holder.tvDaqNarx.text = DaqiqaList.tv_narxi
//        holder.tvKun.text = DaqiqaList.tv_muddat


        when (pageType) {
            PageType.Ucell -> {
                holder.cardView.setCardBackgroundColor(ContextCompat.getColor(context,
                    R.color.ucell))

            }
            PageType.Beeline -> {
                holder.cardView.setCardBackgroundColor(ContextCompat.getColor(context,
                    R.color.beeline))

            }
            PageType.Mobiuz -> {
                holder.cardView.setCardBackgroundColor(ContextCompat.getColor(context,
                    R.color.mobiuz))


            }
            PageType.Uzmobile -> {
                holder.cardView.setCardBackgroundColor(ContextCompat.getColor(context,
                    R.color.uzmobile))


            }
        }

        holder.itemView.setOnClickListener {

        }


    }


    override fun getItemCount(): Int {
        return DaqiqaList.size
    }

    class VH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvToplam = itemView.findViewById<TextView>(R.id.tv_daq)
        val cardView = itemView.findViewById<CardView>(R.id.cv_daq)
        val tvDaqNarx = itemView.findViewById<TextView>(R.id.tv_narx_daq)

        val tvSom = itemView.findViewById<TextView>(R.id.tv_daq_som)
        val tvMuddat = itemView.findViewById<TextView>(R.id.tv_muddat)
        val tvActive = itemView.findViewById<TextView>(R.id.tv_faollashtirish)
        val tvKun = itemView.findViewById<TextView>(R.id.tv_kun)
        val tvCode = itemView.findViewById<TextView>(R.id.tv_kod)
    }

}


