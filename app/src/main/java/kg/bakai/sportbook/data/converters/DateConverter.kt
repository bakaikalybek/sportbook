package kg.bakai.sportbook.data.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.util.*

class DateConverter {
    @TypeConverter
    fun fromDate(date: Date): String {
        return Gson().toJson(date)
    }

    @TypeConverter
    fun toDate(json: String): Date {
        return Gson().fromJson(json, object : TypeToken<Date>() {}.type)
    }
}