package net.iessochoa.sergiocontreras.t05ejercicios2026_pmdm

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import net.iessochoa.sergiocontreras.t05ejercicios2026_pmdm.ui.components.T05TopAppBar
import net.iessochoa.sergiocontreras.t05ejercicios2026_pmdm.ui.screens.MainScreen
import net.iessochoa.sergiocontreras.t05ejercicios2026_pmdm.ui.theme.T05Ejercicios2026PMDMTheme

/**
 * Project: T05 Ejercicios 2026 - PMDM
 * From: net.iessochoa.sergiocontreras.t05ejercicios2026_pmdm
 * Created by: Contr
 * On: 25/10/2026 at 19:25
 * Creado en Settings -> Editor -> File and Code Templates
 */

@Composable
fun T05EjerciciosApp() {
    T05Ejercicios2026PMDMTheme {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = { T05TopAppBar() }
        ) { innerPadding ->
            MainScreen(modifier = Modifier.padding(innerPadding))
        }
    }
}