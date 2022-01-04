package kg.bakai.sportbook.domain.model

import androidx.room.PrimaryKey

data class Exercise(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val name: String,
    val weightLifted: Int,
    val sets: Int,
    val reps: Int
)
