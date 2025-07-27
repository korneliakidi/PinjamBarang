package com.example.pinjambarang.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.pinjambarang.data.Peminjaman
import com.example.pinjambarang.data.PeminjamanDatabase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import com.example.pinjambarang.viewmodel.PeminjamanViewModel

import androidx.compose.ui.unit.dp


class PeminjamanViewModel(application: Application) : AndroidViewModel(application) {
    private val dao = PeminjamanDatabase.getDatabase(application).peminjamanDao()
    val semuaData: Flow<List<Peminjaman>> = dao.getAll()

    fun tambah(p: Peminjaman) {
        viewModelScope.launch {
            dao.insert(p)
        }
    }

    fun hapus(p: Peminjaman) {
        viewModelScope.launch {
            dao.delete(p)
        }
    }

    fun update(p: Peminjaman) {
        viewModelScope.launch {
            dao.update(p)
        }
    }
}
