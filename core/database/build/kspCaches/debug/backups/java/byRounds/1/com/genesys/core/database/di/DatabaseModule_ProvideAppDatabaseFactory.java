package com.genesys.core.database.di;

import android.content.Context;
import com.genesys.core.database.TemplateDatabase;
import com.genesys.core.database.converters.TemplateListConverter;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata("dagger.hilt.android.qualifiers.ApplicationContext")
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
public final class DatabaseModule_ProvideAppDatabaseFactory implements Factory<TemplateDatabase> {
  private final Provider<Context> appContextProvider;

  private final Provider<TemplateListConverter> templateListConverterProvider;

  public DatabaseModule_ProvideAppDatabaseFactory(Provider<Context> appContextProvider,
      Provider<TemplateListConverter> templateListConverterProvider) {
    this.appContextProvider = appContextProvider;
    this.templateListConverterProvider = templateListConverterProvider;
  }

  @Override
  public TemplateDatabase get() {
    return provideAppDatabase(appContextProvider.get(), templateListConverterProvider.get());
  }

  public static DatabaseModule_ProvideAppDatabaseFactory create(
      Provider<Context> appContextProvider,
      Provider<TemplateListConverter> templateListConverterProvider) {
    return new DatabaseModule_ProvideAppDatabaseFactory(appContextProvider, templateListConverterProvider);
  }

  public static TemplateDatabase provideAppDatabase(Context appContext,
      TemplateListConverter templateListConverter) {
    return Preconditions.checkNotNullFromProvides(DatabaseModule.INSTANCE.provideAppDatabase(appContext, templateListConverter));
  }
}
