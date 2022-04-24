package com.example.ahzd.doctoractivity.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import javax.inject.Singleton

@Module
abstract class ViewModelModule {

    @Binds
    @Singleton
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @Singleton
    @IntoMap
    @ViewModelKey(GetPatientsViewModel::class)
    abstract fun splashViewModel(viewModel: GetPatientsViewModel): ViewModel
}