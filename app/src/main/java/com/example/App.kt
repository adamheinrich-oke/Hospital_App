package com.example

import android.app.Application

class App : Application() {

    companion object {
      //  lateinit var component: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        //component = DaggerAppComponent.create()
    }

  //  fun getAppComponent(): AppComponent = component
}