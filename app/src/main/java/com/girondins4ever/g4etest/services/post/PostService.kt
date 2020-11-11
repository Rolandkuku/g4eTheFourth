package com.girondins4ever.g4etest.services.post

import android.content.Context
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.girondins4ever.g4etest.services.RequestSingleton

class PostService {
    private var c: Context? = null

    private val url = "https://www.girondins4ever.com/wp-json/wp/v2/breves?per_page=5&page=1&offset=5"

    fun setContext (context: Context) {
        c = context
    }

    fun fetchPosts() {
        if (c === null) {
            throw Exception("PostService needs a context to run requests")
        } else {
            val request = StringRequest(
                Request.Method.GET, url,
                { response ->
                    try {
                        println(response.toString())
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