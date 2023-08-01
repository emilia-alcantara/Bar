package cl.individual.viernes280723.vista.listing

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cl.individual.viernes280723.data.local.BarItem
import cl.individual.viernes280723.databinding.ItemBinding


class BarAdapter: RecyclerView.Adapter<BarAdapter.BarViewHolder>() {
    private var barItems : List<BarItem> = emptyList()
    private lateinit var binding: ItemBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BarViewHolder {
       binding= ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BarViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return barItems.size
    }

    override fun onBindViewHolder(holder: BarViewHolder, position: Int) {
        val barItem = barItems[position]
        holder.bind(barItem)
    }

    fun setData(barItems: List<BarItem>) {
        this.barItems = barItems
        notifyDataSetChanged()

    }

    class BarViewHolder(val binding: ItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(barItem: BarItem) {
            binding.txtProdName.text = barItem.producto
            binding.txtProdPrice.text = "${barItem.precio} (unidad/es)"
            binding.txtItemCant.text = "$ ${barItem.cantidad}"
            binding.txtItemTotal.text = "$ ${(barItem.precio * barItem.cantidad)}"
        }

    }

}


