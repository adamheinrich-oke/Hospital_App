package com.example.ahzd.di

import com.example.ahzd.data.DataModule
import com.example.ahzd.doctoractivity.viewmodel.ViewModelFactory
import com.example.ahzd.doctoractivity.viewmodel.ViewModelModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [DataModule::class, ViewModelModule::class])
interface AppComponent {

    val factory: ViewModelFactory
}