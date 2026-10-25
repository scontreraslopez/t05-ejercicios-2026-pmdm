package net.iessochoa.sergiocontreras.t05ejercicios2026_pmdm.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import net.iessochoa.sergiocontreras.t05ejercicios2026_pmdm.ui.components.T05Fase1
import net.iessochoa.sergiocontreras.t05ejercicios2026_pmdm.ui.theme.T05Ejercicios2026PMDMTheme

/**
 * Project: T05 Ejercicios 2026 - PMDM
 * From: net.iessochoa.sergiocontreras.t05ejercicios2026_pmdm.ui.screens
 * Created by: Contr
 * On: 25/10/2026 at 19:10
 * Creado en Settings -> Editor -> File and Code Templates
 */

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    // Aquí puedes agregar el contenido de la pantalla principal
    Column(
        modifier = modifier
    ) {


        T05Fase1(
            modifier = Modifier.fillMaxSize(),
        )

    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    T05Ejercicios2026PMDMTheme {
        MainScreen()
    }
}