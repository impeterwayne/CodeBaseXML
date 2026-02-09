package com.genesys.core.database.di;

import com.genesys.core.database.TemplateDatabase;
import com.genesys.core.database.dao.TemplateCollectionsDao;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava",
    "cast",
    "deprecation",
    "nullness:initialization.field.uninitialized"
})
public final class DatabaseModule_ProvideTemplateCollectionDaoFactory implements Factory<TemplateCollectionsDao> {
  private final Provider<TemplateDatabase> removerDatabaseProvider;

  public DatabaseModule_ProvideTemplateCollectionDaoFactory(
      Provider<TemplateDatabase> removerDatabaseProvider) {
    this.removerDatabaseProvider = removerDatabaseProvider;
  }

  @Override
  public TemplateCollectionsDao get() {
    return provideTemplateCollectionDao(removerDatabaseProvider.get());
  }

  public static DatabaseModule_ProvideTemplateCollectionDaoFactory create(
      Provider<TemplateDatabase> removerDatabaseProvider) {
    return new DatabaseModule_ProvideTemplateCollectionDaoFactory(removerDatabaseProvider);
  }

  public static TemplateCollectionsDao provideTemplateCollectionDao(
      TemplateDatabase removerDatabase) {
    return Preconditions.checkNotNullFromProvides(DatabaseModule.INSTANCE.provideTemplateCollectionDao(removerDatabase));
  }
}
