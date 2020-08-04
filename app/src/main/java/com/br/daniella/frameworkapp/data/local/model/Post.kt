package com.br.daniella.frameworkapp.data.local.model

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmClass

@RealmClass
open class Post : RealmObject() {
    @PrimaryKey var userId: Int? = null
    var id: Int? = null
    var title: String? = null
    var body: String? = null
}