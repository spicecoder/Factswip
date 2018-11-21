package io.pronab.factswip.ui.factsdisplay


import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

import com.bumptech.glide.Glide
import io.pronab.factswip.R
import io.pronab.factswip.model.Facts

class FactsAdapter(private var mCtx: FactsDisplayFragment, internal var facts: Facts) :
    RecyclerView.Adapter<FactsAdapter.FactsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FactsViewHolder {
        val view = LayoutInflater.from(mCtx.activity).inflate(R.layout.factview_layout, parent, false)
        return FactsViewHolder(view)
    }

    override fun onBindViewHolder(holder: FactsViewHolder, position: Int) {
        val fact = facts.rows[position]

        Glide.with(mCtx)
            .load(fact.imageHref)
            .into(holder.imageView)

        holder.textView.text = fact.description
        holder.itemTitle.text = fact.title
    }

    override fun getItemCount(): Int {
        return facts.rows.size
    }

    inner class FactsViewHolder(itemView: View,
                                internal var textView: TextView = itemView.findViewById(R.id.textfactView)
    ) : RecyclerView.ViewHolder(itemView) {

        internal var imageView: ImageView = itemView.findViewById(R.id.imagefactView)
        var itemTitle: TextView = itemView.findViewById(R.id.itemTitle)

    }
}
