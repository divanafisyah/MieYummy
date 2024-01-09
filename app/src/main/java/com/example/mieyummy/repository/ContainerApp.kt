package com.example.admin.repository

import android.content.Context
import com.example.admin.data.DatabaseMieYummy


interface ContainerApp{
    val repositoryMie: RepositoryMie
}

class ContainerDataApp(private val context: Context): ContainerApp{
    override val repositoryMie: RepositoryMie by lazy{
        OfflineRepositoryMie(DatabaseMieYummy.getDatabase(context).mieYummyDao())
    }
}