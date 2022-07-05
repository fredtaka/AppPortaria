

package com.fsct.android.appportaria.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Representa uma dia de acesso: cpf, entrada, saída, portaria
 *
 * // Avaliar se CPF usará Int ou Char (pode começar com zero)
 */
@Entity(tableName = "tabela_entrada_saida")
data class Registro(
        @PrimaryKey(autoGenerate = true)
        var registroId: Long = 0L,

        @ColumnInfo(name = "cpf_pessoa")
        var cpfPessoa: String = "0",

        @ColumnInfo(name = "hora_entrada_ms")
        val horaEntradaMs: Long = System.currentTimeMillis(),

        @ColumnInfo(name = "hora_saida_ms")
        var horaSaidaMs: Long = System.currentTimeMillis(),

        @ColumnInfo(name = "grupo_pessoa")
        var grupoPessoa: Int = -1)

