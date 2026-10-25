package net.iessochoa.sergiocontreras.t05ejercicios2026_pmdm.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import net.iessochoa.sergiocontreras.t05ejercicios2026_pmdm.R

/**
 * Project: T05 Ejercicios 2026 - PMDM
 * From: net.iessochoa.sergiocontreras.t05ejercicios2026_pmdm.ui.components
 * Created by: Contr
 * On: 25/10/2026 at 21:10
 * Creado en Settings -> Editor -> File and Code Templates
 */

private const val MAX_RATING = 5

@Composable
fun T05Valoracion(
    modifier: Modifier = Modifier
) {
    // rememberSaveable para que la valoración sobreviva a la rotación
    var rating by rememberSaveable { mutableIntStateOf(0) }
    var comentario by rememberSaveable { mutableStateOf("") }
    var enviada by rememberSaveable { mutableStateOf(false) }

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = stringResource(R.string.valoracion_pregunta),
            style = MaterialTheme.typography.headlineSmall,
            textAlign = TextAlign.Center
        )

        RatingBar(
            rating = rating,
            onRatingChange = { rating = it },
            maxRating = MAX_RATING,
            starSize = 48.dp
        )

        Text(
            text = if (rating == 0) stringResource(R.string.valoracion_sin_valorar)
            else stringResource(R.string.valoracion_actual, rating, MAX_RATING),
            style = MaterialTheme.typography.titleMedium
        )

        if (enviada) {
            Text(
                text = stringResource(R.string.valoracion_gracias),
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.primary
            )
            TextButton(
                onClick = {
                    rating = 0
                    comentario = ""
                    enviada = false
                }
            ) {
                Text(text = stringResource(R.string.boton_valorar_otra))
            }
        } else {
            OutlinedTextField(
                value = comentario,
                onValueChange = { comentario = it },
                label = { Text(text = stringResource(R.string.valoracion_comentario)) },
                minLines = 3,
                modifier = Modifier.fillMaxWidth()
            )
            Button(
                onClick = { enviada = true },
                enabled = rating > 0 // No se puede enviar sin valorar
            ) {
                Text(text = stringResource(R.string.boton_enviar_valoracion))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun T05ValoracionPreview() = T05Valoracion()