

package com.fsct.android.appportaria.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update


/**
 * Defines methods for using the Registro class with Room.
 */
@Dao
interface RegistroDatabaseDao {

    @Insert
    suspend fun insert(evento: Registro)

    /**
     * When updating a row with a value already set in a column,
     * replaces the old value with the new one.
     *
     * @param evento new value to write
     */
    @Update
    suspend fun update(evento: Registro)

    /**
     * Selects and returns the row that matches the supplied start time, which is our key.
     *
     * @param key horaEntradaMs to match
     */
    @Query("SELECT * from tabela_entrada_saida WHERE registroId = :key")
    suspend fun get(key: Long): Registro

    /**
     * Deletes all values from the table.
     *
     * This does not delete the table, only its contents.
     */
    @Query("DELETE FROM tabela_entrada_saida")
    suspend fun clear()

    /**
     * Selects and returns all rows in the table,
     *
     * sorted by start time in descending order.
     */
    @Query("SELECT * FROM tabela_entrada_saida ORDER BY registroId DESC")
    fun getTodosRegistros(): LiveData<List<Registro>>

    /**
     * Selects and returns the latest night.
     */
    @Query("SELECT * FROM tabela_entrada_saida ORDER BY registroId DESC LIMIT 1")
    suspend fun getEsseRegistro(): Registro?
}
