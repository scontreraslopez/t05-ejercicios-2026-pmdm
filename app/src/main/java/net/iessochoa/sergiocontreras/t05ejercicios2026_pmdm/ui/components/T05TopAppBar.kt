package net.iessochoa.sergiocontreras.t05ejercicios2026_pmdm.ui.components

import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import net.iessochoa.sergiocontreras.t05ejercicios2026_pmdm.R
import androidx.compose.ui.tooling.preview.Preview

/**
 * Project: T05 Ejercicios 2026 - PMDM
 * From: net.iessochoa.sergiocontreras.t05ejercicios2026_pmdm.ui.components
 * Created by: Contr
 * On: 25/10/2026 at 19:31
 * Creado en Settings -> Editor -> File and Code Templates
 */

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun T05TopAppBar(
    title: String = stringResource(R.string.titulo_fase1)
) {
    CenterAlignedTopAppBar(
        title = { Text(
            text = title,
            style = MaterialTheme.typography.headlineLarge
        ) },
    )
}

@Preview
@Composable
fun T05TopAppBarPreview() {
    T05TopAppBar()
}