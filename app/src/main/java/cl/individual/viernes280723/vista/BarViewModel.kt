package cl.individual.viernes280723.vista

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import cl.individual.viernes280723.data.Repositorio
import cl.individual.viernes280723.data.local.BarDatabase
import cl.individual.viernes280723.data.local.BarItem
import kotlinx.coroutines.launch

class BarViewModel (app: Application) : AndroidViewModel(app){
    private val repositorio : Repositorio

    init {
        val dao = BarDatabase.getDatabase(app).getBarDao()
        repositorio = Repositorio(dao)
    }

    fun getItemList(): LiveData<List<BarItem>> {
        return repositorio.getItemList()
    }

    fun insertItem(producto:String, precio: Int, cantidad : Int) = viewModelScope.launch {
        val barItem = BarItem(producto, precio, cantidad)
        repositorio.insertItem(barItem)
    }
}