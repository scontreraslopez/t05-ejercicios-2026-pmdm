package net.iessochoa.sergiocontreras.t05ejercicios2026_pmdm.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import net.iessochoa.sergiocontreras.t05ejercicios2026_pmdm.model.Ingredientes

/**
 * Project: T05 Ejercicios 2026 - PMDM
 * From: net.iessochoa.sergiocontreras.t05ejercicios2026_pmdm.ui.components
 * Created by: Contr
 * On: 25/10/2026 at 19:29
 * Creado en Settings -> Editor -> File and Code Templates
 */

@Composable
fun T05Fase1(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        val pizzaOptions = Ingredientes.entries.toList()
        val precio = 10 + pizzaOptions.sumOf { it.precio }


        pizzaOptions.forEach { ingrediente ->
            CheckboxPizza(
                label = stringResource(ingrediente.nombreRes),
                checked = false,
                onCheckedChange = { isChecked ->
                    // Aquí puedes manejar el cambio de estado del checkbox
                }
            )
        }

        Spacer(modifier = Modifier.height(32.dp))


        PrecioPizza(
            precio = precio,     // Esto esta mal. Iterativo
            modifier = Modifier.fillMaxWidth()
        )



        ImagenesPizza(
            ingredientes = pizzaOptions,
            modifier = Modifier
                .weight(1f)
        )

    }

}

@Preview(showBackground = true)
@Composable
fun T05Fase1Preview() =  T05Fase1(
    modifier =  Modifier.fillMaxSize()
)
