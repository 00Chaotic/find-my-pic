package com.chaoticdevelopments.findmypic

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.chaoticdevelopments.findmypic.databinding.FragmentGalleryBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation. Contains a gallery
 * of images.
 */
class GalleryFragment : BaseMenuFragment() {
    private var _binding: FragmentGalleryBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override val menuRes = R.menu.menu_gallery

    override fun handleMenuItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_action_settings -> {
                findNavController().navigate(R.id.action_GalleryFragment_to_SettingsFragment)
                true
            }
            else -> false
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentGalleryBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}