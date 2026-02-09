package com.genesys.core.database.converters;

import com.squareup.moshi.Moshi;
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
public final class TemplateListConverter_Factory implements Factory<TemplateListConverter> {
  private final Provider<Moshi> moshiProvider;

  public TemplateListConverter_Factory(Provider<Moshi> moshiProvider) {
    this.moshiProvider = moshiProvider;
  }

  @Override
  public TemplateListConverter get() {
    return newInstance(moshiProvider.get());
  }

  public static TemplateListConverter_Factory create(Provider<Moshi> moshiProvider) {
    return new TemplateListConverter_Factory(moshiProvider);
  }

  public static TemplateListConverter newInstance(Moshi moshi) {
    return new TemplateListConverter(moshi);
  }
}
