package com.example.ahzd.di

import com.example.ahzd.doctoractivity.doctorfragment.DoctorFragment
import dagger.Component

@SearchTitleScope
@Component(dependencies = [AppComponent::class])
interface GetPatientComponent {
    fun inject(fragment: DoctorFragment)
}