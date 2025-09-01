package com.genesys.v1.codebase.di

import com.genesys.v1.codebase.domain.repository.template.TemplateRepository
import com.genesys.v1.codebase.domain.repository.template.TemplateRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)

internal interface DataModule {
    @Binds
    fun bindTemplateRepository(
        templateRepositoryImpl: TemplateRepositoryImpl
    ) : TemplateRepository
}