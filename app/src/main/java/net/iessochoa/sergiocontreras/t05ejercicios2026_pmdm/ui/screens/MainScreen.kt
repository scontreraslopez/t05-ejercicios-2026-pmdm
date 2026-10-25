package net.iessochoa.sergiocontreras.t05ejercicios2026_pmdm.ui.screens

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import net.iessochoa.sergiocontreras.t05ejercicios2026_pmdm.R
import net.iessochoa.sergiocontreras.t05ejercicios2026_pmdm.ui.components.DynamicSelectTextField
import net.iessochoa.sergiocontreras.t05ejercicios2026_pmdm.ui.components.T05Fase1
import net.iessochoa.sergiocontreras.t05ejercicios2026_pmdm.ui.components.T05Fase2
import net.iessochoa.sergiocontreras.t05ejercicios2026_pmdm.ui.components.T05Valoracion
import net.iessochoa.sergiocontreras.t05ejercicios2026_pmdm.ui.theme.T05Ejercicios2026PMDMTheme

/**
 * Project: T05 Ejercicios 2026 - PMDM
 * From: net.iessochoa.sergiocontreras.t05ejercicios2026_pmdm.ui.screens
 * Created by: Contr
 * On: 25/10/2026 at 19:10
 * Creado en Settings -> Editor -> File and Code Templates
 */

@Composable
fun MainScreen(
    screenOptions: List<String>,
    selectedScreen: String,
    onScreenSelect: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current

    Column(
        modifier = modifier
            .padding(horizontal = 16.dp)
    ) {
        DynamicSelectTextField(
            options = screenOptions,
            selectedValue = selectedScreen,
            label = stringResource(R.string.seleccionar_ejercicio),
            onValueChangedEvent = { opcion ->
                onScreenSelect(opcion)
                // El Toast va en el callback, no en el cuerpo del composable
                Toast.makeText(
                    context,
                    context.getString(R.string.has_elegido, opcion),
                    Toast.LENGTH_SHORT
                ).show()
            },
            modifier = Modifier.fillMaxWidth(),
        )

        Spacer(modifier = Modifier.padding(vertical = 16.dp))

        when (selectedScreen) {
            stringResource(R.string.titulo_fase1) -> T05Fase1(modifier = Modifier.fillMaxSize())
            stringResource(R.string.titulo_fase2) -> T05Fase2(modifier = Modifier.fillMaxSize())
            stringResource(R.string.titulo_fase3) -> T05Valoracion(modifier = Modifier.fillMaxSize())
        }

    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    T05Ejercicios2026PMDMTheme {
        MainScreen(
            screenOptions = listOf("Pizza", "Color", "Valorar Pizza"),
            selectedScreen = "Pizza",
            onScreenSelect = {}
        )
    }
}