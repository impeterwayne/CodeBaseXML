package com.genesys.core.data.repository.template;

import com.genesys.core.database.dao.TemplateCollectionsDao;
import com.genesys.core.network.service.ApiService;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
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
public final class TemplateRepositoryImpl_Factory implements Factory<TemplateRepositoryImpl> {
  private final Provider<ApiService> apiServiceProvider;

  private final Provider<TemplateCollectionsDao> templateCollectionsDaoProvider;

  public TemplateRepositoryImpl_Factory(Provider<ApiService> apiServiceProvider,
      Provider<TemplateCollectionsDao> templateCollectionsDaoProvider) {
    this.apiServiceProvider = apiServiceProvider;
    this.templateCollectionsDaoProvider = templateCollectionsDaoProvider;
  }

  @Override
  public TemplateRepositoryImpl get() {
    return newInstance(apiServiceProvider.get(), templateCollectionsDaoProvider.get());
  }

  public static TemplateRepositoryImpl_Factory create(Provider<ApiService> apiServiceProvider,
      Provider<TemplateCollectionsDao> templateCollectionsDaoProvider) {
    return new TemplateRepositoryImpl_Factory(apiServiceProvider, templateCollectionsDaoProvider);
  }

  public static TemplateRepositoryImpl newInstance(ApiService apiService,
      TemplateCollectionsDao templateCollectionsDao) {
    return new TemplateRepositoryImpl(apiService, templateCollectionsDao);
  }
}
