package com.example.pinjambarang

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.pinjambarang.ui.theme.PinjamBarangTheme
import com.example.pinjambarang.ui.MainScreen
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.pinjambarang.viewmodel.PeminjamanViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PinjamBarangTheme {
                // ViewModel harus disesuaikan dengan nama kamu
                val viewModel: PeminjamanViewModel = viewModel()
                MainScreen(viewModel = viewModel)
            }
        }
    }
}
