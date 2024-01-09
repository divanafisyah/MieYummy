package com.example.admin.data

import android.content.Context
import android.provider.CalendarContract.Instances
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [MieYummy::class], version = 1, exportSchema = false)
abstract class DatabaseMieYummy: RoomDatabase(){
    abstract fun mieYummyDao() : MieYummyDao
    companion object{
        @Volatile
        private var Instances: DatabaseMieYummy? = null

        fun getDatabase(context: Context): DatabaseMieYummy{
            return(Instances?: synchronized(this){
                Room.databaseBuilder(
                    context,
                    DatabaseMieYummy::class.java,
                    "mieyummy_database"
                ).build().also { Instances = it }
            })
        }
    }
}