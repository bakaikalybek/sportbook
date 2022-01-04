package kg.bakai.sportbook.data.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import kg.bakai.sportbook.data.converters.DateConverter
import kg.bakai.sportbook.data.converters.ExercisesConverter
import kg.bakai.sportbook.domain.model.Record

@Database(
    entities = [Record::class],
    version = 1
)
@TypeConverters(
    DateConverter::class,
    ExercisesConverter::class
)
abstract class RecordsDatabase: RoomDatabase() {
    abstract val recordsDao: RecordsDao
}