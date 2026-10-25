package net.iessochoa.sergiocontreras.t05ejercicios2026_pmdm.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

/**
 * Project: T05 Ejercicios 2026 - PMDM
 * From: net.iessochoa.sergiocontreras.t05ejercicios2026_pmdm.ui.components
 * Created by: Contr
 * On: 25/10/2026 at 21:13
 * Creado en Settings -> Editor -> File and Code Templates
 */

@Composable
fun TextSlider(
    text: String,
    value: Float,
    onValueChange: (Float) -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = text)
        Spacer(modifier = Modifier.width(8.dp))
        Slider(
            value = value,
            steps = 254, // 254 pasos intermedios + 2 extremos = 256 valores (0..255)
            valueRange = 0f..255f,
            onValueChange = onValueChange,
            modifier = Modifier.weight(1f)
                .padding(end = 16.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun TextSliderPreview() = TextSlider(
    text = "R",
    value = 128f,
    onValueChange = {}
)