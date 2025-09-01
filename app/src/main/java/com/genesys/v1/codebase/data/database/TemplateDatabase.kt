package com.genesys.v1.codebase.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.genesys.v1.codebase.data.database.converters.TemplateListConverter
import com.genesys.v1.codebase.data.database.dao.TemplateCollectionsDao
import com.genesys.v1.codebase.data.database.entity.TemplateCollectionsEntity

@Database(
    entities = [TemplateCollectionsEntity::class],
    version = 1,
    exportSchema = true
)
@TypeConverters(value = [TemplateListConverter::class])
abstract class TemplateDatabase : RoomDatabase() {
    abstract fun templateCollectionsDao(): TemplateCollectionsDao
}