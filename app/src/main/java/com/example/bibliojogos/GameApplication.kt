package com.example.bibliojogos
import android.app.Application
import com.example.bibliojogos.data.GameDatabase
import com.example.bibliojogos.data.GameRepo

class GameApplication : Application() {
    val database by lazy {
        GameDatabase.getDatabase(this)
    }
    val repositorio by lazy {
        GameRepo(database.gameDao())
    }
}