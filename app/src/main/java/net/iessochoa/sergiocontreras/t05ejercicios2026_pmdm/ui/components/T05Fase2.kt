package net.iessochoa.sergiocontreras.t05ejercicios2026_pmdm.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import net.iessochoa.sergiocontreras.t05ejercicios2026_pmdm.R
import kotlin.random.Random

/**
 * Project: T05 Ejercicios 2026 - PMDM
 * From: net.iessochoa.sergiocontreras.t05ejercicios2026_pmdm.ui.components
 * Created by: Contr
 * On: 25/10/2026 at 21:12
 * Creado en Settings -> Editor -> File and Code Templates
 */

private const val INITIAL_R = 149f
private const val INITIAL_G = 208f
private const val INITIAL_B = 115f

@Composable
fun T05Fase2(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {

        // rememberSaveable para que el color sobreviva a la rotación
        var r by rememberSaveable { mutableFloatStateOf(INITIAL_R) }
        var g by rememberSaveable { mutableFloatStateOf(INITIAL_G) }
        var b by rememberSaveable { mutableFloatStateOf(INITIAL_B) }

        val red = r.toInt()
        val green = g.toInt()
        val blue = b.toInt()
        val isInitialColor = r == INITIAL_R && g == INITIAL_G && b == INITIAL_B

        TextSlider(
            value = r,
            onValueChange = { r = it },
            text = stringResource(R.string.canal_rojo),
        )
        TextSlider(
            value = g,
            onValueChange = { g = it },
            text = stringResource(R.string.canal_verde),
        )
        TextSlider(
            value = b,
            onValueChange = { b = it },
            text = stringResource(R.string.canal_azul),
        )

        Text(
            text = stringResource(R.string.color_actual, red, green, blue),
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.headlineLarge
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            FilledTonalButton(
                onClick = {
                    r = Random.nextInt(256).toFloat()
                    g = Random.nextInt(256).toFloat()
                    b = Random.nextInt(256).toFloat()
                }
            ) {
                Text(text = stringResource(R.string.boton_aleatorio))
            }
            TextButton(
                onClick = {
                    r = INITIAL_R
                    g = INITIAL_G
                    b = INITIAL_B
                },
                enabled = !isInitialColor
            ) {
                Text(text = stringResource(R.string.boton_reiniciar))
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        Surface(
            color = Color(red, green, blue),
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
        ) {

        }

        Text(
            text = "#%02X%02X%02X".format(red, green, blue),
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.titleMedium
        )
    }
}

@Preview(showBackground = true)
@Composable
fun T05Fase2Preview() = T05Fase2()
