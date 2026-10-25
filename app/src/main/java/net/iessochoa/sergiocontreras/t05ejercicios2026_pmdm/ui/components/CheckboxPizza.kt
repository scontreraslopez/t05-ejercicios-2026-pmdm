package net.iessochoa.sergiocontreras.t05ejercicios2026_pmdm.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Checkbox
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
 * On: 25/10/2026 at 20:11
 * Creado en Settings -> Editor -> File and Code Templates
 */


@Composable
fun CheckboxPizza(
    label: String,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
        Checkbox(
            checked = checked,
            onCheckedChange = onCheckedChange
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = label,
            modifier = Modifier
                .weight(1f)
                .padding(start = 16.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CheckboxPizzaPreview() = CheckboxPizza(
    label = "Pepperoni",
    checked = true,
    onCheckedChange = {}
)