package com.example.falabellatest.data.entities

import com.example.falabellatest.domain.entities.EconomicIndicatorMemory

class EconomicIndicatorEntry(
    var codigo: String?,
    var nombre: String?,
    var unidad_medida: String?,
    var fecha: String?,
    var valor: Double?
) {
    fun toEntityMemory() = EconomicIndicatorMemory(
        codigo = codigo,
        nombre = nombre,
        unidad_medida = unidad_medida,
        fecha = fecha,
        valor = valor
    )
}