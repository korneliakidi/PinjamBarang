package com.example.pinjambarang.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.example.pinjambarang.data.Peminjaman
import com.example.pinjambarang.viewmodel.PeminjamanViewModel
import androidx.compose.ui.unit.dp


@Composable
fun MainScreen(viewModel: PeminjamanViewModel) {
    var formMode by remember { mutableStateOf(false) }
    var itemEdit by remember { mutableStateOf<Peminjaman?>(null) }

    val semuaData by viewModel.semuaData.collectAsState(initial = emptyList())

    if (formMode) {
        PeminjamanForm(
            itemEdit = itemEdit,
            onSubmit = {
                if (itemEdit == null) viewModel.tambah(it)
                else viewModel.update(it)
                formMode = false
                itemEdit = null
            },
            onCancel = {
                formMode = false
                itemEdit = null
            }
        )

    } else {
        Column(Modifier.padding(8.dp)) {
            Button(onClick = { formMode = true }) {
                Text("Tambah Peminjaman")
            }
            LazyColumn {
                items(semuaData.size) { i ->
                    val item = semuaData[i]
                    PeminjamanItem(
                        data = item,
                        onEdit = {
                            itemEdit = item
                            formMode = true
                        },
                        onDelete = { viewModel.hapus(item) }
                    )
                }
            }
        }
    }
}
