package dev.mlds.wallet.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.navigation.fragment.findNavController
import dev.mlds.wallet.R
import dev.mlds.wallet.databinding.FragmentCardListBinding
import dev.mlds.wallet.ui.commons.BaseFragment
import dev.mlds.wallet.ui.theme.WalletLigthTheme

class CardListFragment : BaseFragment() {

    private lateinit var viewBinding: FragmentCardListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = FragmentCardListBinding.inflate(layoutInflater)
        return ComposeView(requireContext()).apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                WalletLigthTheme {
                    CardListScreen(
                        backClick = ::backClick,
                        createClick = ::nextPageClick
                    )
                }
            }
        }
    }

    override fun nextPageClick() {
        findNavController().navigate(R.id.action_cardListFragment_to_createCardFragment)
    }
}