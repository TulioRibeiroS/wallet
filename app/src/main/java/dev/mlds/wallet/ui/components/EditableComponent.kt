package dev.mlds.wallet.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.AbsoluteRoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.mlds.wallet.R
import dev.mlds.wallet.ui.commons.MaskUtil
import dev.mlds.wallet.ui.commons.MaskVisualTransformation
import dev.mlds.wallet.ui.theme.WalletLigthTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditableImageComponent(
    label: String = "Teste",
    showRigthIcon: Boolean = true,
    modifier: Modifier = Modifier,
    onChangeText: (value: String) -> Unit,
    keyboardOptions: KeyboardOptions? = null
) {
    var value by remember { mutableStateOf("") }

    Column(modifier = modifier) {
        ProvideTextStyle(
            value = WalletLigthTheme.typography.label
        ) {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = label
            )
        }

        TextField(
            modifier = modifier,
            value = value,
            shape = AbsoluteRoundedCornerShape(6.dp),
            onValueChange = {
                if (it.length <= 16) {
                    value = it
                    onChangeText(it)
                }
            },
            visualTransformation = MaskVisualTransformation(MaskUtil.CARD_MASK),
            keyboardOptions = keyboardOptions ?: KeyboardOptions(keyboardType = KeyboardType.Text),
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.White,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                cursorColor = WalletLigthTheme.colors.primary,
                disabledTextColor = WalletLigthTheme.colors.enabledColor
            ),
            textStyle = TextStyle(
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp
            ),
            leadingIcon = {
                if (showRigthIcon) {
                    Image(
                        painter = painterResource(R.drawable.ic_camera),
                        contentDescription = "Imagem"
                    )
                }
            }
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditableComponent(
    modifier: Modifier = Modifier,
    label: String? = null,
    content: @Composable (() -> Unit)? = null,
    onChangeText: (value: String) -> Unit,
    keyboardOptions: KeyboardOptions? = null
) {
    var value by remember { mutableStateOf("") }

    Column {
        label?.let {
            ProvideTextStyle(
                value = WalletLigthTheme.typography.label
            ) {
                Text(
                    modifier = modifier,
                    text = label
                )
            }
        }

        content?.invoke() ?: TextField(
            modifier = modifier.fillMaxWidth(),
            value = value,
            shape = AbsoluteRoundedCornerShape(6.dp),
            onValueChange = {
                value = it
                onChangeText(it)
            },
            keyboardOptions = keyboardOptions ?: KeyboardOptions(keyboardType = KeyboardType.Text),
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.White,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                cursorColor = WalletLigthTheme.colors.primary,
                disabledTextColor = WalletLigthTheme.colors.enabledColor
            ),
            textStyle = TextStyle(
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp
            )
        )
    }
}

@Composable
fun DateTextField(
    modifier: Modifier = Modifier,
    label: String,
    onValueChange: (String) -> Unit,
    textLength: Int
) {
    var valueDate by remember { mutableStateOf("") }
    ProvideTextStyle(
        value = WalletLigthTheme.typography.body
    ) {
        TextField(
            modifier = modifier,
            value = valueDate,
            shape = AbsoluteRoundedCornerShape(6.dp),
            onValueChange = {
                if (it.length <= textLength) {
                    valueDate = it
                    onValueChange(it)
                }
            },
            placeholder = {
                Text(
                    color = WalletLigthTheme.colors.primary,
                    text = label
                )
            },
            colors = TextFieldDefaults.colors(
                disabledTextColor = WalletLigthTheme.colors.enabledColor,
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White,
                disabledContainerColor = Color.White,
                cursorColor = WalletLigthTheme.colors.primary,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
            ),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            visualTransformation = MaskVisualTransformation(MaskUtil.DATE_MASK),
            textStyle = TextStyle(
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp
            )
        )
    }
}

@Preview(name = "Editable component", backgroundColor = 0xFF142995, showBackground = true)
@Composable
fun EditableComponentPreview() {
    WalletLigthTheme {
        Column {
            EditableImageComponent(
                onChangeText = {},
            )
            EditableComponent(
                label = "Test",
                onChangeText = {},
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            Spacer(modifier = Modifier.height(10.dp))
            DateTextField(
                label = stringResource(id = R.string.card_final_date),
                onValueChange = {},
                textLength = 4
            )
        }
    }
}