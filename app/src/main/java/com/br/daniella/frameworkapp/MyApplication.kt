package com.br.daniella.frameworkapp

import android.app.Application
import com.br.daniella.frameworkapp.data.local.RealmManager
import com.br.daniella.frameworkapp.di.breedsModule
import io.realm.Realm
import org.koin.android.ext.android.startKoin

class MyApplication : Application(){

    override fun onCreate() {
        super.onCreate()
        startKoin(this, breedsModule)
        initRealm()
    }

    private fun initRealm() {
        Realm.init(this)
        RealmManager.setUpRealm()
    }
}