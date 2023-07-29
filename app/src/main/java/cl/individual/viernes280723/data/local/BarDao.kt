package cl.individual.viernes280723.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface BarDao {

    @Insert
    suspend fun insertItem(item: Item)

    @Query ("SELECT * FROM tabla_item ORDER BY id ASC")
    fun getItemList(): LiveData<List<Item>>

}