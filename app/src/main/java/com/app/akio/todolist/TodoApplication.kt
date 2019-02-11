package com.app.akio.todolist

import android.app.Application
import io.realm.Realm

class TodoApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        Realm.init(this)
    }
}