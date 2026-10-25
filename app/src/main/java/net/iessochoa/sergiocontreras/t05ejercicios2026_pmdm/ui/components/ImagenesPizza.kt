package net.iessochoa.sergiocontreras.t05ejercicios2026_pmdm.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import net.iessochoa.sergiocontreras.t05ejercicios2026_pmdm.R
import net.iessochoa.sergiocontreras.t05ejercicios2026_pmdm.model.Ingredientes

/**
 * Project: T05 Ejercicios 2026 - PMDM
 * From: net.iessochoa.sergiocontreras.t05ejercicios2026_pmdm.ui.components
 * Created by: Contr
 * On: 25/10/2026 at 20:29
 * Creado en Settings -> Editor -> File and Code Templates
 */

@Composable
fun ImagenesPizza(
    modifier: Modifier = Modifier,
    ingredientes: List<Ingredientes>,   // Si es un componente adhoc para Pizza, está OK usar modelo (Ingrediente)
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        ingredientes.forEach { ingrediente ->
            Image(
                painter = painterResource(ingrediente.imageRes),
                contentDescription = stringResource(
                    R.string.imagen_pizza_description,
                    stringResource(ingrediente.nombreRes)
                ),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 16.dp)
            )

        }

    }

}

@Preview(showBackground = true)
@Composable
fun ImagenesPizzaPreview() = ImagenesPizza(
    modifier = Modifier.fillMaxSize(),
    ingredientes = listOf(
        Ingredientes.PEPPERONI,
        Ingredientes.QUESO
    )
)
