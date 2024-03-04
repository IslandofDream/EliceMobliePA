package com.junwoo.elicemobliepa.di

import com.junwoo.elicemobliepa.BuildConfig
import com.junwoo.elicemobliepa.data.remote.EliceApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ServiceModule {

    @Provides
    @Singleton
    fun providesLoggerInterceptor() = HttpLoggingInterceptor().apply {
        level = if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor.Level.BODY
        } else {
            HttpLoggingInterceptor.Level.NONE
        }
    }

    @Provides
    @Singleton
    fun providesOkHttpClient(
        headerInterceptor: Interceptor,
        loggerInterceptor: HttpLoggingInterceptor
    ) =
        OkHttpClient.Builder()
            .connectTimeout(10, TimeUnit.SECONDS)
            .writeTimeout(10, TimeUnit.SECONDS)
            .readTimeout(10, TimeUnit.SECONDS)
            .addInterceptor(headerInterceptor)
            .addInterceptor(loggerInterceptor)
            .build()


    @Singleton
    @Provides
    fun provideEliceRetrofit(okHttpClient: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL) //local.properties
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()


    @Singleton
    @Provides
    fun provideEliceService(eliceService: Retrofit): EliceApi {
        return eliceService.create(EliceApi::class.java)
    }

}