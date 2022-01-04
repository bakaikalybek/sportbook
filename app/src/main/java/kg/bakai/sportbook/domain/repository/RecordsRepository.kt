package kg.bakai.sportbook.domain.repository

import kg.bakai.sportbook.domain.model.Record
import kotlinx.coroutines.flow.Flow

interface RecordsRepository {

    fun getRecords(): Flow<List<Record>>

    suspend fun getRecordById(id: Int): Record?

    suspend fun insertRecord(record: Record)

    suspend fun deleteRecord(record: Record)
}