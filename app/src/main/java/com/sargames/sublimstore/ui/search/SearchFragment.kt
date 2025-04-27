package com.sargames.sublimstore.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.sargames.sublimstore.R
import com.sargames.sublimstore.databinding.FragmentSearchBinding
import com.sargames.sublimstore.databinding.ItemProductGridBinding

class SearchFragment : Fragment() {

    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!

    // Datos de ejemplo para las tarjetas
    private val sampleProducts = listOf(
        Product("Taza Personalizada", 25000, 30000, R.drawable.placeholder),
        Product("Camiseta Estampada", 45000, 50000, R.drawable.placeholder),
        Product("Gorra Bordada", 35000, 40000, R.drawable.placeholder),
        Product("Llavero Grabado", 15000, 20000, R.drawable.placeholder),
        Product("Taza Personalizada", 25000, 30000, R.drawable.placeholder),
        Product("Camiseta Estampada", 45000, 50000, R.drawable.placeholder),
        Product("Gorra Bordada", 35000, 40000, R.drawable.placeholder),
        Product("Llavero Grabado", 15000, 20000, R.drawable.placeholder)
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        setupRecyclerView()
        setupSearchBar()
    }

    private fun setupRecyclerView() {
        binding.searchResultsRecyclerView.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = ProductAdapter(sampleProducts)
        }
    }

    private fun setupSearchBar() {
        binding.searchLayout.setEndIconOnClickListener {
            binding.searchLayout.editText?.text?.clear()
        }
        
        binding.searchLayout.editText?.setOnEditorActionListener { _, _, _ ->
            performSearch()
            true
        }
    }

    private fun performSearch() {
        val query = binding.searchLayout.editText?.text?.toString() ?: ""
        // TODO: Implementar la lógica de búsqueda
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    // Clase de datos para los productos
    data class Product(
        val name: String,
        val price: Int,
        val originalPrice: Int,
        val imageResId: Int
    )

    // Adaptador para el RecyclerView
    inner class ProductAdapter(private val products: List<Product>) : 
        androidx.recyclerview.widget.RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

        inner class ProductViewHolder(private val binding: ItemProductGridBinding) : 
            androidx.recyclerview.widget.RecyclerView.ViewHolder(binding.root) {
            
            fun bind(product: Product) {
                binding.productName.text = product.name
                binding.productPrice.text = "$${product.price}"
                binding.originalPrice.text = "$${product.originalPrice}"
                binding.productImage.setImageResource(product.imageResId)
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
            val binding = ItemProductGridBinding.inflate(
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
} 