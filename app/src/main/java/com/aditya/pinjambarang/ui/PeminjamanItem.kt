package com.example.pinjambarang.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.pinjambarang.data.Peminjaman


@Composable
fun PeminjamanItem(
    data: Peminjaman,
    onEdit: () -> Unit,
    onDelete: () -> Unit
) {
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp)
        .clickable { onEdit() }) {
        Column(Modifier.padding(16.dp)) {
            Text("Peminjam: ${data.namaPeminjam}", style = MaterialTheme.typography.titleMedium)
            Text("Barang: ${data.namaBarang}")
            Text("Dari ${data.tanggalPinjam} s.d ${data.tanggalKembali}")
            Row(Modifier.padding(top = 8.dp)) {
                Button(onClick = onEdit) {
                    Text("Edit")
                }
                Spacer(Modifier.width(8.dp))
                OutlinedButton(onClick = onDelete) {
                    Text("Hapus")
                }
            }
        }
    }
}
