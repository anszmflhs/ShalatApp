package com.example.shalatapp.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.shalatapp.model.BatalShalatItem

@Database (entities = [BatalShalatItem::class], version = 1, exportSchema = false)

abstract class RoomDB : RoomDatabase() {
    abstract fun roomDao() : RoomDao

    companion object {
        private var roomDatabaseItem : RoomDB? = null

        fun getRoomDatabaseItem(context: Context): RoomDB {
            return roomDatabaseItem ?: synchronized(this) {
                roomDatabaseItem ?: Room.databaseBuilder(context,RoomDB::class.java,"item.db")
                    .fallbackToDestructiveMigration()
                    .build()
            }
        }
    }
}