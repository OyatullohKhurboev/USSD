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
import com.example.ussd.model.SmsPaketInfoModel


class SmsToplamAdapter(
    private val context: Context,
    private var SmsPaketList: ArrayList<SmsPaketInfoModel>,
    val pageType: PageType,
) :
    RecyclerView.Adapter<SmsToplamAdapter.SmsPaketVh>() {
    fun reloadData(smsPaket: ArrayList<SmsPaketInfoModel>) {
        SmsPaketList = smsPaket
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SmsPaketVh {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.sms_paket, parent, false)
        return SmsPaketVh(view)
    }

    override fun onBindViewHolder(holder: SmsPaketVh, position: Int) {
        val SmsPaketList = SmsPaketList[position]
        holder.tvSms.text = SmsPaketList.paket_nomi
        holder.tvToplam.text = SmsPaketList.paket_nomi
        holder.tvInfo.text = SmsPaketList.info

        when (pageType) {
            PageType.Ucell -> {
                holder.tvToplam.setTextColor(ContextCompat.getColor(context, R.color.ucell))
                holder.cardViewSms.setCardBackgroundColor(
                    ContextCompat.getColor(
                        context,
                        R.color.ucell
                    )
                )
            }
            PageType.Beeline -> {
                holder.tvToplam.setTextColor(ContextCompat.getColor(context, R.color.beeline))
                holder.cardViewSms.setCardBackgroundColor(
                    ContextCompat.getColor(
                        context,
                        R.color.beeline
                    )
                )
            }
            PageType.Mobiuz -> {
                holder.tvToplam.setTextColor(ContextCompat.getColor(context, R.color.mobiuz))
                holder.cardViewSms.setCardBackgroundColor(
                    ContextCompat.getColor(
                        context,
                        R.color.mobiuz
                    ))
            }
            PageType.Uzmobile -> {
                holder.tvToplam.setTextColor(ContextCompat.getColor(context, R.color.uzmobile))
                holder.cardViewSms.setCardBackgroundColor(
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
        return SmsPaketList.size
    }

    class SmsPaketVh(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvSms = itemView.findViewById<TextView>(R.id.tv_sms)
        val cardViewSms = itemView.findViewById<CardView>(R.id.cv_sms)
        val tvToplam = itemView.findViewById<TextView>(R.id.tv_sms_toplam)
        val tvInfo = itemView.findViewById<TextView>(R.id.tv_info_sms)
    }


}