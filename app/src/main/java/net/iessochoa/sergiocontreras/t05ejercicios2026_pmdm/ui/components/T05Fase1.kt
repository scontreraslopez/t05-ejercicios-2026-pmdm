package net.iessochoa.sergiocontreras.t05ejercicios2026_pmdm.ui.components

import android.widget.Toast
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


        val selectedPizzaOptions = remember {
            mutableStateListOf<Ingredientes>()
        }

        // El precio se deriva de la selección: se recalcula en cada recomposición y no puede descuadrarse
        val precio = PRECIO_BASE + selectedPizzaOptions.sumOf { it.precio }

        val onPizzaIngredientSelect = { ingrediente: Ingredientes, isSelected: Boolean ->
            if (isSelected) {
                selectedPizzaOptions.add(ingrediente)
            } else {
                selectedPizzaOptions.remove(ingrediente)
            }
        }

        val onVaciarClick = {
            selectedPizzaOptions.clear()
        }

        val context = LocalContext.current // Se lee fuera del lambda
        val mensajePedidoEnviado = stringResource(R.string.pedido_enviado)

        // Al confirmar el pedido: avisamos con un Toast y vaciamos la selección
        val onConfirmarPedido = {
            Toast.makeText(context, mensajePedidoEnviado, Toast.LENGTH_SHORT).show()
            onVaciarClick()
            mostrarDialogo = false
        }

        // Diálogo con el resumen del pedido: ingredientes elegidos y total
        if (mostrarDialogo) {
            val ingredientesTexto = if (selectedPizzaOptions.isEmpty()) {
                stringResource(R.string.pedido_sin_ingredientes)
            } else {
                selectedPizzaOptions.map { stringResource(it.nombreRes) }.joinToString(", ")
            }

            AlertDialog(
                onDismissRequest = { mostrarDialogo = false },
                title = { Text(stringResource(R.string.pedido_resumen_titulo)) },
                text = {
                    Column {
                        Text(stringResource(R.string.pedido_resumen_ingredientes, ingredientesTexto))
                        Text(stringResource(R.string.total_pizza, precio))
                    }
                },
                confirmButton = {
                    TextButton(onClick = onConfirmarPedido) {
                        Text(stringResource(R.string.confirmar_button))
                    }
                },
                dismissButton = {
                    // Cancelar solo cierra el diálogo, sin tocar la selección
                    TextButton(onClick = { mostrarDialogo = false }) {
                        Text(stringResource(R.string.cancelar_button))
                    }
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
            precio = precio,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(32.dp))

        BotonesPizza(
            modifier = Modifier.fillMaxWidth(),
            isVaciarEnabled = selectedPizzaOptions.isNotEmpty(),
            onVaciarClick = onVaciarClick,
            onPedidoClick = { mostrarDialogo = true },
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
