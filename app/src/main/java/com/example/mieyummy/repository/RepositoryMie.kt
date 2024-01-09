package com.example.mieyummy.repository

import com.example.mieyummy.data.MieYummy
import kotlinx.coroutines.flow.Flow

interface RepositoryMie {
    fun getAllMieStream(): Flow<List<MieYummy>>
    fun getMieStream(id: Int): Flow<MieYummy?>
    suspend fun insertMenu(mieYummy: MieYummy)
    suspend fun deleteMenu(mieYummy: MieYummy)
    suspend fun updateMenu(mieYummy: MieYummy)
}