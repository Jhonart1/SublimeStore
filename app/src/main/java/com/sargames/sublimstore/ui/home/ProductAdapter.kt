package com.sargames.sublimstore.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.sargames.sublimstore.R
import com.sargames.sublimstore.data.model.Product
import com.sargames.sublimstore.databinding.ItemProductCardBinding
import java.text.NumberFormat
import java.util.Locale

class ProductAdapter(private val products: List<Product>) : 
    RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    class ProductViewHolder(private val binding: ItemProductCardBinding) : 
        RecyclerView.ViewHolder(binding.root) {
        
        fun bind(product: Product) {
            binding.productName.text = product.name
            binding.productPrice.text = formatPrice(product.price)
            
            if (product.isOffer && product.originalPrice != null) {
                binding.originalPrice.text = formatPrice(product.originalPrice)
                binding.originalPrice.visibility = android.view.View.VISIBLE
            } else {
                binding.originalPrice.visibility = android.view.View.GONE
            }
            
            if (product.specialDay != null) {
                binding.specialDay.text = product.specialDay
                binding.specialDay.visibility = android.view.View.VISIBLE
            } else {
                binding.specialDay.visibility = android.view.View.GONE
            }
            
            Glide.with(binding.root.context)
                .load(product.imageUrl)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(R.drawable.ic_launcher_foreground)
                .error(R.drawable.ic_launcher_foreground)
                .into(binding.productImage)
        }
        
        private fun formatPrice(price: Double): String {
            val format = NumberFormat.getCurrencyInstance(Locale("es", "CO"))
            return format.format(price)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val binding = ItemProductCardBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ProductViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bind(products[position])
    }

    override fun getItemCount() = products.size
} 