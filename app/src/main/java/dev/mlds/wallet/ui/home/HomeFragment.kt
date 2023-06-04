package dev.mlds.wallet.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import dev.mlds.wallet.R
import dev.mlds.wallet.databinding.FragmentHomeBinding
import dev.mlds.wallet.ui.commons.BaseFragment

class HomeFragment : BaseFragment() {
    private lateinit var viewBinding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = FragmentHomeBinding.inflate(layoutInflater)
        return ComposeView(requireContext()).apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                HomeScreen(
                    openList = { openScreen(navigationId = R.id.action_homeFragment_to_cardListFragment) },
                    openCreate = { openScreen(navigationId = R.id.action_homeFragment_to_createCardFragment) }
                )
            }
        }
    }
}