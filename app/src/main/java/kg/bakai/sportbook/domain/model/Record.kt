package kg.bakai.sportbook.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class Record(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val date: Date,
    val weight: Double,
    val exercises: List<Exercise>?
)
