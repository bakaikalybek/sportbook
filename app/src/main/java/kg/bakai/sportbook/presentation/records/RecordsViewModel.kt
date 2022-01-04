package kg.bakai.sportbook.presentation.records

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import kg.bakai.sportbook.domain.model.Record
import kg.bakai.sportbook.domain.repository.RecordsRepository
import kotlinx.coroutines.launch

class RecordsViewModel(
    private val recordsRepository: RecordsRepository
): ViewModel() {
    val records: LiveData<List<Record>> = recordsRepository.getRecords().asLiveData()

    fun deleteRecord(record: Record) {
        viewModelScope.launch {
            recordsRepository.deleteRecord(record)
        }
    }

    fun addNewRecord(record: Record) {
        viewModelScope.launch {
            recordsRepository.insertRecord(record)
        }
    }
}