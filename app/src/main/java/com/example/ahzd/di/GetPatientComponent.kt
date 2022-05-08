package com.example.ahzd.di

import com.example.ahzd.doctoractivity.doctorfragment.DoctorFragment
import com.example.ahzd.nurseactivity.nursefragment.AddPatientFragment
import dagger.Component

@SearchTitleScope
@Component(dependencies = [AppComponent::class])
interface GetPatientComponent {
    fun inject(fragment: DoctorFragment)
    fun inject(fragment: AddPatientFragment)

}