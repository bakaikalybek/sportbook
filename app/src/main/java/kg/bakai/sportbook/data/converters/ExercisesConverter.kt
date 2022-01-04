package kg.bakai.sportbook.data.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kg.bakai.sportbook.domain.model.Exercise

class ExercisesConverter {
    @TypeConverter
    fun fromList(list: List<Exercise>): String {
        return Gson().toJson(list)
    }

    @TypeConverter
    fun toList(json: String): List<Exercise> {
        return Gson().fromJson(json, object : TypeToken<List<Exercise>>() {}.type)
    }
}