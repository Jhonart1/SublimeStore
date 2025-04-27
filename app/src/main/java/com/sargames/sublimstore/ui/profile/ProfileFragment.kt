package com.sargames.sublimstore.ui.profile

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.sargames.sublimstore.LoginActivity
import com.sargames.sublimstore.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        setupClickListeners()
    }

    private fun setupClickListeners() {
        binding.editProfileButton.setOnClickListener {
            // TODO: Implementar navegación a la pantalla de edición de perfil
        }

        binding.ordersButton.setOnClickListener {
            // TODO: Implementar navegación a la pantalla de pedidos
        }

        binding.settingsButton.setOnClickListener {
            // TODO: Implementar navegación a la pantalla de configuración
        }

        binding.logoutButton.setOnClickListener {
            // Navegar a la pantalla de login
            val intent = Intent(requireContext(), LoginActivity::class.java)
            startActivity(intent)
            requireActivity().finish()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
} 