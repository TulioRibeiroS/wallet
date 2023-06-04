package dev.mlds.wallet.ui.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import dev.mlds.wallet.R
import dev.mlds.wallet.ui.theme.WalletLigthTheme
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(findNavController: NavController) {
    LaunchedEffect(Unit) {
        delay(3000)
        findNavController.navigate(R.id.nav_to_list)
    }
    Surface(modifier = Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(WalletLigthTheme.colors.background),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(R.drawable.background),
                contentDescription = null,
                modifier = Modifier.fillMaxSize()
            )

            Image(
                painter = painterResource(R.drawable.ic_animation_wallet),
                contentDescription = null
            )
        }
    }
}