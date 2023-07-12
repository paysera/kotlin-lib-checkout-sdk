package com.paysera.lib.checkout.clients

import com.paysera.lib.checkout.retrofit.NetworkApiFactory
import com.paysera.lib.common.entities.PayseraApiCredentials
import com.paysera.lib.common.exceptions.ApiError
import com.paysera.lib.common.interfaces.ErrorLoggerInterface
import com.paysera.lib.common.interfaces.TokenRefresherInterface
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.Deferred
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.TestInstance.Lifecycle

@TestInstance(Lifecycle.PER_METHOD)
open class BaseTest {

    companion object {
        private val userAgent = "okhttp/3.12.1"
        private val apiCredentials = PayseraApiCredentials(
            token = "insert_me",
            locale = "en",
            expirationLeeway = 120000
        ).apply {
            locale = "lt"
        }
        private val timeout: Long? = null
        private val loggingLevel = HttpLoggingInterceptor.Level.BODY

        private val errorLoggerInterface = object : ErrorLoggerInterface {
            override fun log(request: Request, error: ApiError) {
                //  log
            }
        }
        private val tokenRefresher = object : TokenRefresherInterface {
            override fun refreshToken(): Deferred<Any> {
                return CompletableDeferred(1)
            }
        }
    }

    protected lateinit var apiClient: CheckoutApiClient

    @BeforeAll
    open fun setUp() {
        apiClient = NetworkApiFactory(
            baseUrl = "https://mobile-checkout-integration.paysera.com/rest/v1/",
            userAgent = userAgent,
            credentials = apiCredentials,
            timeout = timeout,
            httpLoggingInterceptorLevel = loggingLevel,
            errorLogger = errorLoggerInterface,
            certificateInterceptor = null
        ).createClient(tokenRefresher)
    }

    @AfterAll
    open fun tearDown() {
        apiClient.cancelCalls()
    }
}