package com.chaoticdevelopments.findmypic

import androidx.fragment.app.Fragment
import androidx.core.view.MenuProvider
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View

abstract class BaseMenuFragment : Fragment() {
    abstract val menuRes: Int
    open fun handleMenuItemSelected(item: MenuItem): Boolean = false

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        requireActivity().addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menu.clear()
                menuInflater.inflate(menuRes, menu)
            }
            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return handleMenuItemSelected(menuItem)
            }
        }, viewLifecycleOwner)
    }
}