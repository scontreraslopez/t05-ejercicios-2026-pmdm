package net.iessochoa.sergiocontreras.t05ejercicios2026_pmdm.ui.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import net.iessochoa.sergiocontreras.t05ejercicios2026_pmdm.R

/**
 * Project: T05 Ejercicios 2026 - PMDM
 * From: net.iessochoa.sergiocontreras.t05ejercicios2026_pmdm.ui.components
 * Created by: Contr
 * On: 25/10/2026 at 20:29
 * Creado en Settings -> Editor -> File and Code Templates
 */

@Composable
fun PrecioPizza(
    precio: Int,
    modifier: Modifier = Modifier
) {
    Text(
        text = stringResource(R.string.total_pizza, precio),
        style = MaterialTheme.typography.displayLarge,
        textAlign = TextAlign.Center,
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun PrecioPizzaPreview() = PrecioPizza(
    precio = 16
)
