package com.example.mieyummy.model

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.mieyummy.AplikasiMieYummy

object PenyediaViewModel {
    val factory = viewModelFactory {
        initializer {
            MenuViewModel(aplikasiMieYummy().container.repositoryMie)
        }
        initializer {
            CreateViewModel(aplikasiMieYummy().container.repositoryMie)

        }
        initializer {
            EditViewModel(
                createSavedStateHandle(),aplikasiMieYummy().container.repositoryMie)

        }

    }
}

fun CreationExtras.aplikasiMieYummy(): AplikasiMieYummy =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as AplikasiMieYummy)