package dev.rendrap.app.movienight.core.database.converter

import androidx.room.TypeConverter
import kotlinx.datetime.LocalDate

internal object LocalDateConverter {
    @TypeConverter
    fun stringToLocalDate(value: String): LocalDate = LocalDate.parse(value)

    @TypeConverter
    fun localDateToString(value: LocalDate): String = value.toString()
}