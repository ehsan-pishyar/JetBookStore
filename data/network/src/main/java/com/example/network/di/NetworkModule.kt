package com.example.network.di

import com.example.network.ApiService
import com.example.network.utils.NetworkConstants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.security.KeyStore
import java.util.concurrent.TimeUnit
import javax.inject.Singleton
import javax.net.ssl.SSLContext
import javax.net.ssl.TrustManagerFactory
import javax.net.ssl.X509TrustManager

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    // Used to log HTTP request and response information
//    @[Provides Singleton]
//    fun providesLoggingInterceptor(): HttpLoggingInterceptor =
//        HttpLoggingInterceptor().apply {
//            level = HttpLoggingInterceptor.Level.BODY
//        }

    // Used to add SSL & timeouts to retrofit requests
//    @[Provides Singleton]
//    fun providesOkHttpsBuilder(
//        httpLoggingInterceptor: HttpLoggingInterceptor
//    ): OkHttpClient {
//        val trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm())
//        trustManagerFactory.init(null as KeyStore?)
//
//        // Create an SSLContext with the trust manager
//        val sslContext = SSLContext.getInstance("TLS")
//        sslContext.init(null, trustManagerFactory.trustManagers, null)
//
//        return OkHttpClient.Builder()
//            .addInterceptor(httpLoggingInterceptor)
//            .readTimeout(30, TimeUnit.SECONDS)
//            .writeTimeout(30, TimeUnit.SECONDS)
//            .connectTimeout(30, TimeUnit.SECONDS)
//            .sslSocketFactory(sslContext.socketFactory, trustManagerFactory.trustManagers[0] as X509TrustManager)
//            .hostnameVerifier { _, _ -> true }
//            .build()
//    }

    // Used to create only one instance of retrofit
    @[Provides Singleton]
    fun providesRetrofit(): Retrofit =
        Retrofit.Builder()
            .baseUrl(NetworkConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
//            .client(okHttpClient)
            .build()

    // Used to create only one instance of ApiService interface
    @[Provides Singleton]
    fun providesApiService(retrofit: Retrofit): ApiService =
        retrofit.create(ApiService::class.java)
}