package cl.individual.viernes280723.data

import androidx.lifecycle.LiveData
import cl.individual.viernes280723.data.local.BarDao
import cl.individual.viernes280723.data.local.BarItem

class Repositorio(private val barDao: BarDao) {

    suspend fun insertItem(barItem: BarItem) {
        barDao.insertItem(barItem)
    }

    fun getItemList(): LiveData<List<BarItem>> {
        return barDao.getItemList()
    }

}