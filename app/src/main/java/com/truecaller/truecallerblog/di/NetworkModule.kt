package com.truecaller.truecallerblog.di

import android.content.Context
import com.truecaller.truecallerblog.BuildConfig
import com.truecaller.truecallerblog.data.api.BlogService
import com.truecaller.truecallerblog.utils.NoInternetException
import com.truecaller.truecallerblog.utils.isNetworkConnected
import com.truecaller.truecallerblog.utils.showLog
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import javax.inject.Singleton

/**
 * @Details NetworkModule
 * @Author Roshan Bhagat
 * @constructor Create Network module
 */
@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {

    /**
     * Provide log interceptor
     *
     * @return
     */
    @Singleton
    @Provides
    fun provideLogInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor { message ->
            showLog("OkHttp", message)
        }.apply {
            level = when {
                BuildConfig.DEBUG -> HttpLoggingInterceptor.Level.BODY
                else -> HttpLoggingInterceptor.Level.NONE
            }
        }
    }

    /**
     * Provide error interceptor
     *
     * @param context
     * @return
     */
    @Singleton
    @Provides
    fun provideErrorInterceptor(@ApplicationContext context: Context): Interceptor {
        return Interceptor { chain: Interceptor.Chain ->
            if (!isNetworkConnected(context)) {
                throw NoInternetException(
                    "",
                    Throwable(NoInternetException::class.java.toString())
                )
            }
            val request = chain.request()
            chain.proceed(request)
        }
    }


    /**
     * Provide ok http
     *
     * @param error
     * @param logging
     * @return
     */
    @Singleton
    @Provides
    fun provideOkHttp(error: Interceptor, logging: HttpLoggingInterceptor): OkHttpClient =
        OkHttpClient.Builder().run {
            addInterceptor(logging)
            addInterceptor(error)
            build()
        }

    /**
     * Provide retrofit
     *
     * @param client
     * @return
     */
    @Singleton
    @Provides
    fun provideRetrofit(client: OkHttpClient): Retrofit = Retrofit.Builder().run {
        addConverterFactory(ScalarsConverterFactory.create())
        baseUrl(BuildConfig.BASE_URL)
        client(client)
        build()
    }


    /**
     * Provide api
     *
     * @param retrofit
     * @return
     */
    @Singleton
    @Provides
    fun provideApi(retrofit: Retrofit): BlogService =
        retrofit.create(BlogService::class.java)
}