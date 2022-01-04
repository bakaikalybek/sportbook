package kg.bakai.sportbook.presentation.main

import androidx.lifecycle.*
import kg.bakai.sportbook.domain.model.Record
import kg.bakai.sportbook.domain.repository.RecordsRepository
import kotlinx.coroutines.launch

class MainViewModel(
    private val recordsRepository: RecordsRepository
): ViewModel() {

}