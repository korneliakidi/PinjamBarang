package com.example.pinjambarang.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.compose.ui.unit.dp


@Entity
data class Peminjaman(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val namaPeminjam: String,
    val namaBarang: String,
    val tanggalPinjam: String,
    val tanggalKembali: String
)
