package com.girondins4ever.g4etest.ui.postDetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.girondins4ever.g4etest.R
import com.girondins4ever.g4etest.ui.postList.Post


/**
 * A simple [Fragment] subclass.
 * Use the [PostDetails.newInstance] factory method to
 * create an instance of this fragment.
 */
class PostDetails : Fragment() {
    private lateinit var mPost: Post

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_post_details, container, false)
        /*view.findViewById<TextView>(R.id.post_details_body).text = mPost.body
        view.findViewById<TextView>(R.id.post_details_meta).text = mPost.date
        view.findViewById<TextView>(R.id.post_details_title).text = mPost.title*/
        view.findViewById<TextView>(R.id.post_details_title).text = "lalalalallalalala"
        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @return A new instance of fragment postDetails.
         */
        @JvmStatic
        fun newInstance() =
            PostDetails().apply {
                arguments = Bundle().apply {
                    //
                }
            }
    }
}