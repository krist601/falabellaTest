package com.example.falabellatest.ui.economicIndicators

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.falabellatest.R
import com.example.falabellatest.databinding.CellEconomicIndicatorBinding
import com.example.falabellatest.domain.entities.EconomicIndicatorMemory

class EconomicIndicatorsAdapter (
    private var itemList: List<EconomicIndicatorMemory?>,
    private var listener: OnClickItemListener
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    fun setData(result: List<EconomicIndicatorMemory?>) {
        itemList = result
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return itemList.size
    }
    override fun getItemViewType(position: Int): Int {
        return if (itemList[position] == null) 1 else 0
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return EconomicIndicatorViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.cell_economic_indicator, parent, false), listener)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as EconomicIndicatorViewHolder).bind(itemList[position]!!)
    }

    //******************* CLICK LISTENER *******************//

    interface OnClickItemListener {
        fun click(item: EconomicIndicatorMemory)
    }
    fun setOnClickItemListener(listener: OnClickItemListener) {
        this.listener = listener
    }

    //******************* HOLDER *******************//

    internal class EconomicIndicatorViewHolder(val binding: CellEconomicIndicatorBinding, val listener: OnClickItemListener): View.OnClickListener, RecyclerView.ViewHolder(binding.root){
        private lateinit var itemHolder: EconomicIndicatorMemory

        fun bind(item: EconomicIndicatorMemory) = with(itemView) {
            itemHolder = item
            itemView.setOnClickListener(this@EconomicIndicatorViewHolder)
            binding.keyTextView.text = item.nombre
            binding.valueTextView.text = item.valor.toString()
        }
        override fun onClick(view: View) { listener.click(itemHolder) }
    }
}