package br.com.estudos.orgs.recyclerview

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.estudos.orgs.databinding.ProductItemBinding
import br.com.estudos.orgs.model.Product

class ProductListAdapter(
    private val context: Context
) : RecyclerView.Adapter<ProductListAdapter.ViewHolder>() {

    private val products: MutableList<Product> = mutableListOf()

    fun updateList(products: List<Product>) {
        Log.i("?", products.size.toString())
        this.products.clear()
        this.products.addAll(products)
        notifyDataSetChanged()
    }

    class ViewHolder(private val binding: ProductItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(product: Product) {
            binding.txtName.text = product.name
            binding.txtDescription.text = product.description
            binding.txtValue.text = product.value
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ProductItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(products[position])
    }

    override fun getItemCount(): Int = products.size
}
