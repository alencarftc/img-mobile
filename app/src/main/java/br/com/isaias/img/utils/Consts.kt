package br.com.isaias.img.utils

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val client = OkHttpClient.Builder()
    .readTimeout(100, TimeUnit.SECONDS)
    .connectTimeout(100, TimeUnit.SECONDS)
    .writeTimeout(100, TimeUnit.SECONDS)
    .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
    .build()

val baseRetrofit: Retrofit = Retrofit.Builder()
    .baseUrl("https://www.figma.com/")
    .client(client)
    .addConverterFactory(GsonConverterFactory.create())
    .build()