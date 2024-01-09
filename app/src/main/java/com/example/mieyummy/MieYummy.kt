package com.example.mieyummy

import android.app.Application
import com.example.mieyummy.repository.ContainerApp
import com.example.mieyummy.repository.ContainerDataApp


class AplikasiMieYummy : Application() {
    lateinit var container: ContainerApp

    override fun onCreate() {
        super.onCreate()
        container = ContainerDataApp(this)
    }
}
