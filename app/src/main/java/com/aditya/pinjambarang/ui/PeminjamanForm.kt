package com.example.pinjambarang.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.pinjambarang.data.Peminjaman

@Composable
fun PeminjamanForm(
    onSubmit: (Peminjaman) -> Unit,
    onCancel: () -> Unit,
    itemEdit: Peminjaman? = null
) {
    var nama by remember { mutableStateOf(itemEdit?.namaPeminjam ?: "") }
    var barang by remember { mutableStateOf(itemEdit?.namaBarang ?: "") }
    var tglPinjam by remember { mutableStateOf(itemEdit?.tanggalPinjam ?: "") }
    var tglKembali by remember { mutableStateOf(itemEdit?.tanggalKembali ?: "") }

    Column(Modifier.padding(16.dp)) {
        OutlinedTextField(nama, { nama = it }, label = { Text("Nama Peminjam") })
        OutlinedTextField(barang, { barang = it }, label = { Text("Nama Barang") })
        OutlinedTextField(tglPinjam, { tglPinjam = it }, label = { Text("Tanggal Pinjam") })
        OutlinedTextField(tglKembali, { tglKembali = it }, label = { Text("Tanggal Kembali") })

        Spacer(Modifier.height(16.dp))

        Row {
            Button(onClick = {
                onSubmit(
                    Peminjaman(
                        id = itemEdit?.id ?: 0,
                        namaPeminjam = nama,
                        namaBarang = barang,
                        tanggalPinjam = tglPinjam,
                        tanggalKembali = tglKembali
                    )
                )
            }) {
                Text(if (itemEdit == null) "Simpan" else "Update")
            }

            Spacer(Modifier.width(8.dp))

            OutlinedButton(onClick = { onCancel() }) {
                Text("Batal")
            }
        }
    }
}
