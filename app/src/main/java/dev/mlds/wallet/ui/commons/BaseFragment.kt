package dev.mlds.wallet.ui.commons

import android.os.Bundle
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

abstract class BaseFragment : Fragment() {

    protected open fun nextPageClick() = Unit

    protected open fun openScreen(navigationId: Int, bundle: Bundle = bundleOf()) {
        findNavController().navigate(navigationId, bundle)
    }

    protected fun backClick() {
        findNavController().popBackStack()
    }
}