package cl.individual.viernes280723.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database (entities = [Item::class], version = 1)
abstract class BarDatabase : RoomDatabase() {

    abstract fun getBarDao(): BarDao

    companion object {
        @Volatile
        private var INSTANCE: BarDatabase? = null

        fun getDatabase(context: Context): BarDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    BarDatabase::class.java,
                    "bar_database"
                ).build()

                INSTANCE = instance
                return instance
            }
        }
    }
}