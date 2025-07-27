package com.example.pinjambarang.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow
import androidx.compose.ui.unit.dp


@Dao
interface PeminjamanDao {
    @Query("SELECT * FROM peminjaman ORDER BY id DESC")
    fun getAll(): Flow<List<Peminjaman>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(peminjaman: Peminjaman)

    @Delete
    suspend fun delete(peminjaman: Peminjaman)

    @Update
    suspend fun update(peminjaman: Peminjaman)
}
