package com.example.ussd.adapters

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.ussd.Fragment.PageType
import com.example.ussd.R
import com.example.ussd.model.TarifRejaInfoModel
import com.example.ussd.model.TarifRejaModel

class TarifRejaAdapter(
    private val context: Context,
    private var tarifList: List<TarifRejaInfoModel>,
    val pageType: PageType,
) :
    RecyclerView.Adapter<TarifRejaAdapter.TarifRejaVH>() {


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): TarifRejaVH {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.tarif_rejalar, parent, false)
        return TarifRejaVH(view)
    }

    fun reloadData(tarifs: List<TarifRejaInfoModel>) {
        tarifList = tarifs
        notifyDataSetChanged()
    }


    override fun onBindViewHolder(holder: TarifRejaVH, position: Int) {
        val tarifList = tarifList[position]


        holder.tarifNomi.text = tarifList.tarif_nomi
        holder.abonentTolovi.text = tarifList.abonet_tolovi
        holder.abonentTolovNarxi.text = tarifList.abonet_tolovi
        holder.chiquvchiOzbkiston.text = tarifList.daqiqa
        holder.uzbBoyicha.text = tarifList.sms
        holder.daqiqa.text = tarifList.internet_paket
        when (pageType) {
            PageType.Uzmobile -> {
                holder.tarifNomi.setTextColor(ContextCompat.getColor(context, R.color.uzmobile))
                holder.cardView.setCardBackgroundColor(
                    ContextCompat.getColor(
                        context,
                        R.color.uzmobile
                    ))

            }
            PageType.Beeline -> {
                holder.tarifNomi.setTextColor(ContextCompat.getColor(context, R.color.beeline))
                holder.cardView.setCardBackgroundColor(
                    ContextCompat.getColor(
                        context,
                        R.color.beeline
                    ))

            }
            PageType.Ucell -> {
                holder.cardView.setCardBackgroundColor(
                    ContextCompat.getColor(
                        context,
                        R.color.ucell
                    ))
                holder.tarifNomi.setTextColor(ContextCompat.getColor(context, R.color.ucell))
            }
            PageType.Mobiuz -> {
                holder.cardView.setCardBackgroundColor(
                    ContextCompat.getColor(
                        context,
                        R.color.mobiuz
                    ))
                holder.tarifNomi.setTextColor(ContextCompat.getColor(context, R.color.mobiuz))
            }
        }

    }

    override fun getItemCount(): Int {
        return tarifList.size
    }

    class TarifRejaVH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tarifNomi = itemView.findViewById<TextView>(R.id.tv_tarif_nomi)
        val cardView = itemView.findViewById<CardView>(R.id.cv_tarif_reja_linear)
        val abonentTolovi = itemView.findViewById<TextView>(R.id.tv_AbonentTolovi)
        val abonentTolovNarxi = itemView.findViewById<TextView>(R.id.tv_AbonentTolovi)
        val chiquvchiOzbkiston = itemView.findViewById<TextView>(R.id.tv_OzbekitonBoyicha)
        val uzbBoyicha = itemView.findViewById<TextView>(R.id.tv_Boyicha)
        val daqiqa = itemView.findViewById<TextView>(R.id.tv_daqiqa)
    }

}




