package io.pronab.factswip.ui.factsdisplay


import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v4.app.FragmentActivity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import io.pronab.factswip.R
import io.pronab.factswip.model.Facts
import io.pronab.factswip.model.FactsDisplayViewModel

class FactsAdapter(private var mCtx: FactsDisplayFragment, internal var facts: Facts?) :
    RecyclerView.Adapter<FactsAdapter.FactsViewHolder>() {

    private var viewModel: FactsDisplayViewModel? = null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FactsViewHolder {
        val view = LayoutInflater.from(mCtx.context).inflate(R.layout.factview_layout, parent, false)

        this.viewModel = ViewModelProviders.of(mCtx).get(FactsDisplayViewModel::class.java)

        return FactsViewHolder(view)
    }

    fun setAdapterForChange(context: FragmentActivity?) {

        viewModel?.facts?.observe(context as LifecycleOwner,
            Observer<Facts> { notifyDataSetChanged() })

    }

    override fun onBindViewHolder(holder: FactsViewHolder, position: Int) {
        val fact = facts?.rows?.get(position)

        Glide.with(mCtx)
            .load(fact?.imageHref)
            .into(holder.imageView)

        holder.textView.text = fact?.description ?: ""
        holder.itemTitle.text = fact?.title ?: ""
    }

    override fun getItemCount(): Int {

        when (facts) {
            null -> return 0
            else -> return facts!!.rows.size
        }

    }

    class FactsViewHolder(
        itemView: View,
        internal var textView: TextView = itemView.findViewById(R.id.textfactView)
    ) : RecyclerView.ViewHolder(itemView) {

        internal var imageView: ImageView = itemView.findViewById(R.id.imagefactView)
        var itemTitle: TextView = itemView.findViewById(R.id.itemTitle)

    }
}

