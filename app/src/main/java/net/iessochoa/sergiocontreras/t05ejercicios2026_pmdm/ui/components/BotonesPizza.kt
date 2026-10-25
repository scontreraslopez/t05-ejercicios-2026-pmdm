package net.iessochoa.sergiocontreras.t05ejercicios2026_pmdm.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import net.iessochoa.sergiocontreras.t05ejercicios2026_pmdm.R

/**
 * Project: T05 Ejercicios 2026 - PMDM
 * From: net.iessochoa.sergiocontreras.t05ejercicios2026_pmdm.ui.components
 * Created by: Contr
 * On: 25/10/2026 at 21:14
 * Creado en Settings -> Editor -> File and Code Templates
 */

@Composable
fun BotonesPizza(
    modifier: Modifier = Modifier,
    isVaciarEnabled: Boolean = true,
    onVaciarClick: () -> Unit = {},
    onPedidoClick: () -> Unit = {},
) {

    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceAround
    )
    {
        OutlinedButton(
            enabled = isVaciarEnabled,
            onClick = onVaciarClick
        ) {
            Text(stringResource(R.string.boton_vaciar_pizza))
        }

        // Button con icono: Icon + separación estándar + texto
        Button(
            onClick = onPedidoClick,
            contentPadding = ButtonDefaults.ButtonWithIconContentPadding
        ) {
            Icon(
                painter = painterResource(R.drawable.ic_send),
                contentDescription = null, // Decorativo: el texto ya describe la acción
                modifier = Modifier.size(ButtonDefaults.IconSize)
            )
            Spacer(modifier = Modifier.width(ButtonDefaults.IconSpacing))
            Text(stringResource(R.string.boton_pedido_pizza))
        }

    }
}

@Preview
@Composable
fun BotonesPizzaPreview() = BotonesPizza(
    modifier = Modifier.fillMaxWidth()
)
