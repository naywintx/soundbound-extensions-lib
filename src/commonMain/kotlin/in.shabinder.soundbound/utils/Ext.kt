package `in`.shabinder.soundbound.utils

import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.statement.*

/*
* Return URL after Redirections
*   - If Fails returns Input Url
* */
suspend inline fun HttpClient.getFinalUrl(
    url: String,
    crossinline block: HttpRequestBuilder.() -> Unit = {}
): String {
    return runCatching {
        get<HttpResponse>(url, block).call.request.url.toString()
    }.getOrNull() ?: url
}