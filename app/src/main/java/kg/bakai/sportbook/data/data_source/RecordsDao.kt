package kg.bakai.sportbook.data.data_source

import androidx.room.*
import kg.bakai.sportbook.domain.model.Record
import kotlinx.coroutines.flow.Flow

@Dao
interface RecordsDao {
    @Query("SELECT * FROM record")
    fun getRecords(): Flow<List<Record>>

    @Query("SELECT * FROM record WHERE id = :id")
    suspend fun getRecordById(id: Int): Record?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRecord(record: Record)

    @Delete
    suspend fun deleteRecord(record: Record)
}