package cl.individual.viernes280723.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "tabla_item")
data class BarItem(val producto: String, val precio: Int, val cantidad: Int) {
    @PrimaryKey(autoGenerate = true) var id:Long = 0

}
