package com.app.akio.todolist

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import java.util.*

open class Todo : RealmObject() {
    @PrimaryKey
    var id: Long = 0
    var date: Date = Date()
    var title: String = ""
    var detail: String = ""

}