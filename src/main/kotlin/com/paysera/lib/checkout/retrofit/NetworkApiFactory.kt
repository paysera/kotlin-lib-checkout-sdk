package com.paysera.lib.checkout.retrofit

import com.paysera.lib.checkout.clients.CheckoutApiClient
import com.paysera.lib.common.interfaces.BaseApiCredentials
import com.paysera.lib.common.interfaces.ErrorLoggerInterface
import com.paysera.lib.common.interfaces.TokenRefresherInterface
import com.paysera.lib.common.retrofit.BaseApiFactory
import okhttp3.Interceptor
import okhttp3.logging.HttpLoggingInterceptor

class NetworkApiFactory(
    baseUrl: String,
    userAgent: String?,
    credentials: BaseApiCredentials,
    timeout: Long? = null,
    httpLoggingInterceptorLevel: HttpLoggingInterceptor.Level = HttpLoggingInterceptor.Level.BASIC,
    errorLogger: ErrorLoggerInterface,
    certificateInterceptor: Interceptor?
) : BaseApiFactory<CheckoutApiClient>(
    baseUrl,
    userAgent,
    credentials,
    timeout,
    httpLoggingInterceptorLevel,
    errorLogger,
    certificateInterceptor
) {
    override fun createClient(tokenRefresher: TokenRefresherInterface?): CheckoutApiClient {
        createRetrofit(tokenRefresher).apply {
            return CheckoutApiClient(
                retrofit.create(NetworkApiClient::class.java),
                apiRequestManager
            )
        }
    }
}