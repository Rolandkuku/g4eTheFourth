package com.girondins4ever.g4etest.services.post

import android.content.Context
import android.os.Build
import android.text.Html
import com.android.volley.Request
import com.android.volley.toolbox.JsonArrayRequest
import com.girondins4ever.g4etest.services.RequestSingleton
import com.girondins4ever.g4etest.ui.postList.Post

fun parseHtmlToString(value: String): String {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
       return Html.fromHtml(
           value, Html.FROM_HTML_MODE_LEGACY
       ).toString()
    }
    return ""
    // return Html.fromHtml(value).toString()
}

class PostService {
    private var c: Context? = null

    private val url = "https://www.girondins4ever.com/wp-json/wp/v2/breves?per_page=5&page=1&offset=5"

    fun setContext (context: Context) {
        c = context
    }

    fun fetchPosts(callback: (MutableList<Post>) -> Unit) {
        if (c === null) {
            throw Exception("PostService needs a context to run requests")
        } else {
            val request = JsonArrayRequest(
                Request.Method.GET, url, null,
                { response ->
                    try {
                        val arr = ArrayList<Post>()
                        for (i in 0 until response.length()) {
                            val post = response.getJSONObject(i)
                            arr.add(
                                Post(
                                    post.getString("id"),
                                    post.getString("date"),
                                    parseHtmlToString(
                                        post.getJSONObject("title")
                                            .getString("rendered"),
                                    ),
                                    parseHtmlToString(
                                        post.getJSONObject("excerpt")
                                            .getString("rendered")
                                    ),
                                    parseHtmlToString(
                                        post.getJSONObject("content")
                                            .getString("rendered")
                                    )
                                )
                            )
                        }
                        println(arr)
                        callback(arr)
                    } catch (e: Exception) {
                        throw Exception(e)
                    }
                },
                { error ->
                    error(error.toString())
                }
            )
            RequestSingleton.getInstance(c!!).requestQueue.add(request)
        }

    }
}