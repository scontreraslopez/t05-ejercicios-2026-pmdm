package net.iessochoa.sergiocontreras.t05ejercicios2026_pmdm.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuAnchorType
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

/**
 * Project: T05 Ejercicios 2026 - PMDM
 * From: net.iessochoa.sergiocontreras.t05ejercicios2026_pmdm.ui.components
 * Created by: Contr
 * On: 25/10/2026 at 21:15
 * Creado en Settings -> Editor -> File and Code Templates
 */

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DynamicSelectTextField(
    selectedValue: String,
    options: List<String>,
    label: String,
    onValueChangedEvent: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    var expanded by remember { mutableStateOf(false) }

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = { expanded = it }, // El componente ya nos da el valor nuevo
        modifier = modifier
    ) {
        OutlinedTextField(
            value = selectedValue,
            onValueChange = {}, // Vacío porque es readOnly
            readOnly = true,    // El campo de texto no se edita directamente
            label = { Text(label) },
            trailingIcon = {
                // Icono que indica si el menú está desplegado o no
                ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
            },
            modifier = Modifier
                .menuAnchor(ExposedDropdownMenuAnchorType.PrimaryNotEditable) // Ancla el menú al campo
                .fillMaxWidth()
        )
        // El menú desplegable en sí
        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false } // Al pulsar fuera, se cierra
        ) {
            // Un item del menú por cada opción
            options.forEach { option ->
                DropdownMenuItem(
                    text = { Text(option) },
                    onClick = {
                        onValueChangedEvent(option) // Avisa de la opción elegida
                        expanded = false            // Cierra el menú
                    },
                    contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding
                )
            }
        }
    }
}