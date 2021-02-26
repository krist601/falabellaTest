package com.example.falabellatest.data.entities

import com.example.falabellatest.domain.entities.HeaderMemory

data class HeaderEntry (
    var version: String?,
    var autor: String?,
    var fecha: String?,
    var uf: EconomicIndicatorEntry?,
    var ivp: EconomicIndicatorEntry?,
    var dolar: EconomicIndicatorEntry?,
    var dolar_intercambio: EconomicIndicatorEntry?,
    var euro: EconomicIndicatorEntry?,
    var ipc: EconomicIndicatorEntry?,
    var utm: EconomicIndicatorEntry?,
    var imacec: EconomicIndicatorEntry?,
    var tpm: EconomicIndicatorEntry?,
    var libra_cobre: EconomicIndicatorEntry?,
    var tasa_desempleo: EconomicIndicatorEntry?,
    var bitcoin: EconomicIndicatorEntry?
) {
    fun toEntityMemory() = HeaderMemory(
        version = version,
        autor = autor,
        fecha = fecha,
        economicIndicators = listOf(uf?.toEntityMemory(),
                                    ivp?.toEntityMemory(),
                                    dolar?.toEntityMemory(),
                                    dolar_intercambio?.toEntityMemory(),
                                    euro?.toEntityMemory(),
                                    ipc?.toEntityMemory(),
                                    utm?.toEntityMemory(),
                                    imacec?.toEntityMemory(),
                                    tpm?.toEntityMemory(),
                                    libra_cobre?.toEntityMemory(),
                                    tasa_desempleo?.toEntityMemory(),
                                    bitcoin?.toEntityMemory()
        )
    )
}
