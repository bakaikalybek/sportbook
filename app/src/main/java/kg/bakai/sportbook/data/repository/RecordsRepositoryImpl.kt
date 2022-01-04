package kg.bakai.sportbook.data.repository

import kg.bakai.sportbook.data.data_source.RecordsDao
import kg.bakai.sportbook.domain.model.Record
import kg.bakai.sportbook.domain.repository.RecordsRepository
import kotlinx.coroutines.flow.Flow

class RecordsRepositoryImpl(
    private val recordsDao: RecordsDao
): RecordsRepository {
    override fun getRecords(): Flow<List<Record>> {
        return recordsDao.getRecords()
    }

    override suspend fun getRecordById(id: Int): Record? {
        return recordsDao.getRecordById(id)
    }

    override suspend fun insertRecord(record: Record) {
        recordsDao.insertRecord(record)
    }

    override suspend fun deleteRecord(record: Record) {
        recordsDao.deleteRecord(record)
    }
}