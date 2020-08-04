package com.br.daniella.frameworkapp.data.local

import io.realm.Realm
import io.realm.RealmConfiguration

class RealmManager {

    companion object {
        private const val LOCAL_DB = "localDB.realm"

        val mRealm: Realm
            get() = Realm.getDefaultInstance()

        private val config = RealmConfiguration.Builder()
                .name(LOCAL_DB)
                .deleteRealmIfMigrationNeeded()
                .build()

        fun setUpRealm() {
            Realm.setDefaultConfiguration(config)
        }

    }
}

