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
import com.example.ussd.model.TarifRejaModel
class TarifRejaAdapter(
    private val context: Context,
    private var tarifList: List<TarifRejaModel>,
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


    override fun onBindViewHolder(holder: TarifRejaVH, position: Int) {
        val tarifList = tarifList[position]


        holder.tarifNomi.text = tarifList.tarifNomi
        holder.abonentTolovi.text = tarifList.abonentTolovi
        holder.abonentTolovNarxi.text = tarifList.abonentTolovNArxi
        holder.chiquvchiOzbkiston.text = tarifList.chiquvchiOzbekiston
        holder.uzbBoyicha.text = tarifList.ozbekistonBoyicha
        holder.daqiqa.text = tarifList.daqiqa
        when (pageType) {
            PageType.Uzmobile -> {
                holder.tarifNomi.setTextColor(ContextCompat.getColor(context, R.color.uzmobile))
//                holder.cardView.setCardBackgroundColor(ContextCompat.getColor(context,R.color.mobiuz))
            }
            PageType.Beeline -> {
                holder.tarifNomi.setTextColor(ContextCompat.getColor(context, R.color.beeline))
            }
            PageType.Ucell -> {
                holder.tarifNomi.setTextColor(ContextCompat.getColor(context, R.color.ucell))
            }
            PageType.Mobiuz -> {
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
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TarifRejaAdapter.Tar {
//        val view =
//            LayoutInflater.from(parent.context).inflate(R.layout.tarif_rejalar, parent, false)
//        return TarifRejaAdapter.Tari(view)
//    }
//
//    var tarifNomi: TextView = itemView.findViewById(R.id.tv_tarif_nomi)
//    var abonentTolovi: TextView = itemView.findViewById(R.id.tv_AbonentTolovi)
//    var abonentTolovNarxi: TextView = itemView.findViewById(R.id.tv_Som)
//    var chiquvchiOzbkiston: TextView = itemView.findViewById(R.id.tv_OzbekitonBoyicha)
//    var ozbekistonBoyicha: TextView = itemView.findViewById(R.id.tv_Boyicha)
//    var daqiqa: TextView = itemView.findViewById(R.id.tv_daqiqa)
//    override fun onBindViewHolder(holder: TarifRejaAdapter.TarifRejaVH, position: Int) {
//        val tarifReja: TarifRejaModel = tarifList[position]
//
//
//
//        holder.tarifNomi.text = tarifReja.tarifNomi
//        holder.abonentTolovi.text = tarifReja.abonentTolovi
//        holder.abonentTolovNarxi.text = tarifReja.abonentTolovNArxi
//        holder.chiquvchiOzbkiston.text = tarifReja.chiquvchiOzbekiston
//        holder.ozbekistonBoyicha.text = tarifReja.ozbekistonBoyicha
//        holder.daqiqa.text = tarifReja.daqiqa
//
////        textView
//        when (pageType) {
//            PageType.Ucell ->
//                holder.tarifNomi.setTextColor(ContextCompat.getColor(context, R.color.ucell))
//        }
//        when (pageType) {
//            PageType.Beeline ->
//                holder.tarifNomi.setTextColor(ContextCompat.getColor(context, R.color.beeline))
//        }
//        when (pageType) {
//            PageType.Mobiuz ->
//                holder.tarifNomi.setTextColor(ContextCompat.getColor(context, R.color.mobiuz))
//        }
//        when (pageType) {
//            PageType.Uzmobile ->
//                holder.tarifNomi.setTextColor(ContextCompat.getColor(context, R.color.uzmobile))
//        }
////        cardview
//        when (pageType) {
//            PageType.Mobiuz ->
//                holder.ca.setCardBackgroundColor(
//                    ContextCompat.getColor(
//                        context,
//                        R.color.mobiuz
//                    )
//                )
//        }
//        when (pageType) {
//            PageType.Ucell ->
//                holder.cardViewInternet.setCardBackgroundColor(
//                    ContextCompat.getColor(
//                        context,
//                        R.color.ucell
//                    )
//                )
//        }
//        when (pageType) {
//            PageType.Beeline ->
//                holder.cardViewInternet.setCardBackgroundColor(
//                    ContextCompat.getColor(
//                        context,
//                        R.color.beeline
//                    )
//                )
//        }
//        when (pageType) {
//            PageType.Uzmobile ->
//                holder.car.setCardBackgroundColor(
//                    ContextCompat.getColor(
//                        context,
//                        R.color.uzmobile
//                    )
//                )
//        }
//
//        holder.itemView.setOnClickListener {
//
//        }
//
//    }
//
//    override fun getItemCount(): Int {
//        return tarifList.size
//    }
//
//
//}
//
//
//



