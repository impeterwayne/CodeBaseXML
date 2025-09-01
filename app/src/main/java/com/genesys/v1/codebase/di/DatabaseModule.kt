package com.genesys.v1.codebase.di

import android.content.Context
import androidx.room.Room
import com.genesys.v1.codebase.data.database.TemplateDatabase
import com.genesys.v1.codebase.data.database.converters.TemplateListConverter
import com.genesys.v1.codebase.data.database.dao.TemplateCollectionsDao
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import kotlin.jvm.java

@InstallIn(SingletonComponent::class)
@Module
object DatabaseModule {
    @Provides
    @Singleton
    fun provideAppDatabase(
        @ApplicationContext appContext: Context,
        templateListConverter: TemplateListConverter
    ): TemplateDatabase {
        return Room.databaseBuilder(
            appContext,
            TemplateDatabase::class.java,
            "remover_database.db")
            .addTypeConverter(templateListConverter)
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideTemplateCollectionDao(removerDatabase: TemplateDatabase): TemplateCollectionsDao {
        return removerDatabase.templateCollectionsDao()
    }

    @Provides
    fun provideContext(@ApplicationContext context: Context): Context {
        return context
    }
    @Provides
    @Singleton
    fun provideMoshi(): Moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()
}
