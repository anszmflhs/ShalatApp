package com.example.shalatapp.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.shalatapp.model.BatalShalatItem
import com.example.shalatapp.model.DalilShalatItem
import com.example.shalatapp.model.ShalatItem

@Dao
interface RoomDao {

    // Menampilkan Data Semua Sesuai typenya
    // CRUD = R (Read)
    @Query("SELECT * FROM item WHERE type = :type")
    fun getDataByType(type : String) : LiveData<List<BatalShalatItem>>

    // Menghapus Semua Data
    // CRUD = D (DELETE)
    @Query("DELETE FROM item")
    suspend fun resetDatabase()

    // Menghapus 1 Data
    // CRUD = D (Delete)
    @Query("DELETE FROM item WHERE type = :type")
    suspend fun resetType(type: String)

    //Membuat Data
    // CRUD = C (Create)
    @Insert
    suspend fun insertData(data : List<BatalShalatItem>)
}

//@Dao
//interface RoomDaos {
//    @Query("SELECT * FROM items WHERE type = :type")
//    fun getDataByTypes(type: String) : LiveData<List<DalilShalatItem>>
//
//    @Query("DELETE FROM items")
//    suspend fun resetDatabases()
//
//    @Query("DELETE FROM items WHERE type = :type")
//    suspend fun resetTypes(type: String)
//
//    @Insert
//    suspend fun insertDatas(data : List<ShalatItem>)
//}