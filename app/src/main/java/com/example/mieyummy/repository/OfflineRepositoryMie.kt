package com.example.mieyummy.repository

import com.example.mieyummy.data.MieYummy
import com.example.mieyummy.data.MieYummyDao
import kotlinx.coroutines.flow.Flow

class OfflineRepositoryMie(private val mieYummyDao: MieYummyDao): RepositoryMie {
    override fun getAllMieStream(): Flow<List<MieYummy>> = mieYummyDao.getAllMie()
    override fun getMieStream(id: Int): Flow<MieYummy?> = mieYummyDao.getMie(id)
    override suspend fun insertMenu(mieYummy: MieYummy) = mieYummyDao.insert(mieYummy)
    override suspend fun deleteMenu(mieYummy: MieYummy) = mieYummyDao.delete(mieYummy)
    override suspend fun updateMenu(mieYummy: MieYummy) =mieYummyDao.update(mieYummy)


}