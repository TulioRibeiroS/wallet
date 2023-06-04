package dev.mlds.wallet.ui.resume

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.navigation.fragment.findNavController
import dev.mlds.wallet.R
import dev.mlds.wallet.domain.models.CardModel
import dev.mlds.wallet.ui.commons.BaseFragment
import dev.mlds.wallet.ui.create.CreateFragment
import dev.mlds.wallet.ui.theme.WalletLigthTheme

class ResumeFragment : BaseFragment() {

    private var card: CardModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        card = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            arguments?.getParcelable(CreateFragment.CREATE_DATA, CardModel::class.java)
        } else {
            arguments?.getParcelable(CreateFragment.CREATE_DATA) as? CardModel
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return ComposeView(requireContext()).apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                WalletLigthTheme {
                    ResumeScreen(
                        card,
                        backClick = ::backClick,
                        nextPage = ::nextPageClick
                    )
                }
            }
        }
    }

    override fun nextPageClick() {
        findNavController().navigate(R.id.nav_to_splash)
    }

}