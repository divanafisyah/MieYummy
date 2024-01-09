package com.example.mieyummy

import android.app.Application
import com.example.admin.repository.ContainerApp
import com.example.admin.repository.ContainerDataApp


class AplikasiMieYummy : Application() {
    lateinit var container: ContainerApp

    override fun onCreate() {
        super.onCreate()
        container = ContainerDataApp(this)
    }
}
