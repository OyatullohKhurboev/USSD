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
import com.example.ussd.model.UssdInfoModel
import com.example.ussd.model.UssdKodlarModel

class UssdKodlarAdapter(
    private val context: Context,
    private var UssdKodList: ArrayList<UssdInfoModel>,
    val pageType: PageType,
) :
    RecyclerView.Adapter<UssdKodlarAdapter.UssdKodlarVH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UssdKodlarVH
    {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.ussd_kodlar, parent, false)
        return UssdKodlarVH(view)
    }
    fun reloadData(ussd: ArrayList<UssdInfoModel>) {
        UssdKodList = ussd
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: UssdKodlarVH, position: Int) {
        val UssdKodList = UssdKodList[position]
        holder.tvUssd.setText(UssdKodList.name)
        holder.tvInfo.setText(UssdKodList.info)

        when (pageType) {
            PageType.Ucell -> {

                holder.cardViewUssd.setCardBackgroundColor(
                    ContextCompat.getColor(
                        context,
                        R.color.ucell
                    )
                )
            }
            PageType.Beeline -> {
                holder.cardViewUssd.setCardBackgroundColor(
                    ContextCompat.getColor(
                        context,
                        R.color.beeline
                    )
                )
            }
            PageType.Mobiuz -> {
                holder.cardViewUssd.setCardBackgroundColor(
                    ContextCompat.getColor(
                        context,
                        R.color.mobiuz
                    ))
            }
            PageType.Uzmobile -> {
                holder.cardViewUssd.setCardBackgroundColor(
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
        return UssdKodList.size
    }

    class UssdKodlarVH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvUssd = itemView.findViewById<TextView>(R.id.tv_ussd)
        val cardViewUssd = itemView.findViewById<CardView>(R.id.cv_ussd)

        val tvInfo = itemView.findViewById<TextView>(R.id.tv_info_ussd)
    }


}

