package cl.individual.viernes280723.data

import androidx.lifecycle.LiveData
import cl.individual.viernes280723.data.local.BarDao
import cl.individual.viernes280723.data.local.Item

class Repositorio(private val barDao: BarDao) {

    suspend fun insertItem(item: Item) {
        barDao.insertItem(item)
    }

    fun getItemList(): LiveData<List<Item>> {
        return barDao.getItemList()
    }

}