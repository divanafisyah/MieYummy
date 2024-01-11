package com.example.mieyummy.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tblMie")
data class MieYummy(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val jenis: String ="",
    val nama: String ="",
    val deskripsi: String="",
    val harga: String="",
    val jumlah: Int = 0,
)
