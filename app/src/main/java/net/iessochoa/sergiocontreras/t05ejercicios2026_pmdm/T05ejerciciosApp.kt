package net.iessochoa.sergiocontreras.t05ejercicios2026_pmdm

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import kotlinx.coroutines.launch
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

    val pantallas = listOf(
        stringResource(R.string.titulo_fase1),
        stringResource(R.string.titulo_fase2),
        stringResource(R.string.titulo_fase3)
    )

    val (pantallaSeleccionada, onPantallaSelect) = rememberSaveable { mutableStateOf(pantallas[0]) }

    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()
    // stringResource no se puede llamar dentro del onClick, así que el mensaje se prepara aquí
    val mensaje = stringResource(
        R.string.mensaje_snackbar,
        stringResource(R.string.mi_nombre),
        pantallaSeleccionada
    )

    T05Ejercicios2026PMDMTheme {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = { T05TopAppBar(pantallaSeleccionada) },
            snackbarHost = { SnackbarHost(hostState = snackbarHostState) },
            floatingActionButton = {
                ExtendedFloatingActionButton(
                    onClick = {
                        scope.launch { snackbarHostState.showSnackbar(mensaje) }
                    },
                    icon = {
                        Icon(
                            painter = painterResource(R.drawable.ic_favorite),
                            contentDescription = stringResource(R.string.mostrar_mensaje)
                        )
                    },
                    text = { Text(text = stringResource(R.string.mostrar_mensaje)) }
                )
            }
        ) { innerPadding ->
            MainScreen(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                screenOptions = pantallas,
                selectedScreen = pantallaSeleccionada,
                onScreenSelect = { onPantallaSelect(it) }
            )
        }
    }
}