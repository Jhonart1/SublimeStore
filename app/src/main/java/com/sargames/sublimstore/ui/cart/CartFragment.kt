package com.sargames.sublimstore.ui.cart

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.sargames.sublimstore.R
import com.sargames.sublimstore.databinding.FragmentCartBinding
import com.sargames.sublimstore.databinding.ItemCartProductBinding

class CartFragment : Fragment() {

    private var _binding: FragmentCartBinding? = null
    private val binding get() = _binding!!

    // Datos de ejemplo para el carrito
    private val sampleCartItems = listOf(
        CartItem("Taza Personalizada", 25000, R.drawable.placeholder),
        CartItem("Camiseta Estampada", 45000, R.drawable.placeholder)
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCartBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        setupRecyclerView()
        updateCartSummary()
    }

    private fun setupRecyclerView() {
        binding.cartRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = CartAdapter(sampleCartItems)
        }
    }

    private fun updateCartSummary() {
        val subtotal = sampleCartItems.sumOf { it.price }
        binding.subtotalText.text = "$$subtotal"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    // Clase de datos para los items del carrito
    data class CartItem(
        val name: String,
        val price: Int,
        val imageResId: Int
    )

    // Adaptador para el RecyclerView del carrito
    inner class CartAdapter(private val items: List<CartItem>) :
        androidx.recyclerview.widget.RecyclerView.Adapter<CartAdapter.CartViewHolder>() {

        inner class CartViewHolder(private val binding: ItemCartProductBinding) :
            androidx.recyclerview.widget.RecyclerView.ViewHolder(binding.root) {

            fun bind(item: CartItem) {
                binding.productName.text = item.name
                binding.productPrice.text = "$${item.price}"
                binding.productImage.setImageResource(item.imageResId)
                
                binding.removeButton.setOnClickListener {
                    // TODO: Implementar la lógica para eliminar items del carrito
                }
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
            val binding = ItemCartProductBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
            return CartViewHolder(binding)
        }

        override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
            holder.bind(items[position])
        }

        override fun getItemCount() = items.size
    }
} 