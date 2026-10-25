package net.iessochoa.sergiocontreras.t05ejercicios2026_pmdm.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import net.iessochoa.sergiocontreras.t05ejercicios2026_pmdm.R
import net.iessochoa.sergiocontreras.t05ejercicios2026_pmdm.model.Ingredientes

/**
 * Project: T05 Ejercicios 2026 - PMDM
 * From: net.iessochoa.sergiocontreras.t05ejercicios2026_pmdm.ui.components
 * Created by: Contr
 * On: 25/10/2026 at 19:29
 * Creado en Settings -> Editor -> File and Code Templates
 */

const val PRECIO_BASE = 10

@Composable
fun T05Fase1(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {

        val pizzaOptions = Ingredientes.entries.toList()
        var mostrarDialogo by remember { mutableStateOf(false) }


        var precio by remember { mutableIntStateOf(PRECIO_BASE) }

        val selectedPizzaOptions = remember {
            mutableStateListOf<Ingredientes>()
        }

        val onPizzaIngredientSelect = { ingrediente: Ingredientes, isSelected: Boolean ->
            if (isSelected) {
                selectedPizzaOptions.add(ingrediente)
                precio += ingrediente.precio
            } else {
                selectedPizzaOptions.remove(ingrediente)
                precio -= ingrediente.precio
            }
        }

        val onVaciarClick = {
            selectedPizzaOptions.clear()
            precio = PRECIO_BASE
        }

        val onPedidoClick = {
            // Aquí puedes manejar el pedido, por ejemplo, mostrar un mensaje o navegar a otra pantalla
        }

        if (mostrarDialogo) {
            AlertDialog(
                onDismissRequest = { mostrarDialogo = false },
                title = { Text(stringResource(R.string.pizza_vaciar_pedido_titulo)) },
                text = { Text(stringResource(R.string.pizza_vaciar_pedido_cuerpo)) },
                confirmButton = {
                    TextButton(onClick = {
                        onVaciarClick()
                        mostrarDialogo = false
                    }) { Text("Vaciar") }
                },
                dismissButton = {
                    TextButton(onClick = { mostrarDialogo = false }) { Text(stringResource(R.string.cancelar_button)) }
                }
            )
        }



        pizzaOptions.forEach { ingrediente ->
            CheckboxPizza(
                label = stringResource(ingrediente.nombreRes),
                checked = selectedPizzaOptions.contains(ingrediente),
                onCheckedChange = { isChecked ->
                    onPizzaIngredientSelect(ingrediente, isChecked)
                }
            )
        }

        Spacer(modifier = Modifier.height(32.dp))


        PrecioPizza(
            precio = precio,     // Esto esta mal. Iterativo
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(32.dp))

        BotonesPizza(
            modifier = Modifier.fillMaxWidth(),
            isVaciarEnabled = selectedPizzaOptions.isNotEmpty(),
            onVaciarClick = { mostrarDialogo = true },
        )

        Spacer(modifier = Modifier.height(32.dp))


        ImagenesPizza(
            ingredientes = selectedPizzaOptions,
            modifier = Modifier
                .weight(1f)
        )

    }

}

@Preview(showBackground = true)
@Composable
fun T05Fase1Preview() =  T05Fase1(
    modifier =  Modifier.fillMaxSize(),
)
