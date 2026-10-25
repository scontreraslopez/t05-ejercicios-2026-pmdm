package net.iessochoa.sergiocontreras.t05ejercicios2026_pmdm.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import net.iessochoa.sergiocontreras.t05ejercicios2026_pmdm.R

/**
 * Project: T05 Ejercicios 2026 - PMDM
 * From: net.iessochoa.sergiocontreras.t05ejercicios2026_pmdm.data
 * Created by: Contr
 * On: 25/10/2026 at 20:14
 * Creado en Settings -> Editor -> File and Code Templates
 */
enum class Ingredientes(
    @StringRes val nombreRes: Int,
    @DrawableRes val imageRes: Int,
    val precio: Int = 2
) {
    QUESO(R.string.ingrediente_1, R.drawable.queso, 2),
    CHAMPINONES(R.string.ingrediente_2, R.drawable.champinones, 2),
    PEPPERONI(R.string.ingrediente_3, R.drawable.pepperoni, 2),
}