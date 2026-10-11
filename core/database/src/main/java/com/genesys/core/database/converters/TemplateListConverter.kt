package com.genesys.core.database.converters

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.genesys.core.model.template.Template
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import javax.inject.Inject

@ProvidedTypeConverter
class TemplateListConverter @Inject constructor(private val gson: Gson) {
    private val type = object : TypeToken<List<Template>>() {}.type

    @TypeConverter
    fun fromString(value: String): List<Template>? {
        return gson.fromJson(value, type)
    }

    @TypeConverter
    fun fromList(list: List<Template>?): String {
        return gson.toJson(list, type)
    }
}
