package com.sargames.sublimstore.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.sargames.sublimstore.data.repository.ProductRepository
import com.sargames.sublimstore.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val productRepository = ProductRepository()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Configurar RecyclerView de ofertas
        binding.offersRecyclerView.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = ProductAdapter(productRepository.getOffers())
        }

        // Configurar RecyclerView de destacados
        binding.featuredRecyclerView.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = ProductAdapter(productRepository.getFeatured())
        }

        // Configurar RecyclerView de catálogo
        binding.catalogRecyclerView.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = ProductAdapter(productRepository.getCatalog())
        }

        // Configurar la barra de búsqueda
        binding.searchLayout.setEndIconOnClickListener {
            val query = binding.searchLayout.editText?.text.toString()
            // Aquí puedes implementar la lógica de búsqueda
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}