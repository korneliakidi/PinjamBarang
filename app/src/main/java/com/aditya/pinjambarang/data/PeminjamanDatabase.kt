package com.example.pinjambarang.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.compose.ui.unit.dp


@Database(entities = [Peminjaman::class], version = 1)
abstract class PeminjamanDatabase : RoomDatabase() {
    abstract fun peminjamanDao(): PeminjamanDao

    companion object {
        @Volatile private var instance: PeminjamanDatabase? = null

        fun getDatabase(context: Context): PeminjamanDatabase =
            instance ?: synchronized(this) {
                instance ?: Room.databaseBuilder(
                    context.applicationContext,
                    PeminjamanDatabase::class.java,
                    "peminjaman_db"
                ).build().also { instance = it }
            }
    }
}
