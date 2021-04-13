package com.trungluu9798.charactersapp.view.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.trungluu9798.charactersapp.R
import com.trungluu9798.charactersapp.view.list.ListViewModel

class DetailFragment: Fragment() {

    private lateinit var viewModel: ListViewModel
    private lateinit var characterImage: ImageView
    private lateinit var characterTitle: TextView
    private lateinit var characterDesc:TextView

    override fun onStart() {
        super.onStart()
        viewModel = ViewModelProvider(requireActivity()).get(ListViewModel::class.java)
        characterImage = requireActivity().findViewById<ImageView>(R.id.image_view)
        characterTitle = requireActivity().findViewById<TextView>(R.id.title_content)
        characterDesc = requireActivity().findViewById<TextView>(R.id.description_content)

        updateUI()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    fun updateUI() {
        val character = viewModel.selected

        Glide.with(requireContext())
                .applyDefaultRequestOptions(
                        RequestOptions()
                                .placeholder(R.drawable.ic_default_image)
                                .error(R.drawable.ic_default_image))
                .load(IMG_SRC + character?.icon?.url)
                .override(500, 500)
                .into(characterImage)
        characterTitle.text = character?.title
        characterDesc.text = character?.description
    }

    companion object {
        private const val IMG_SRC = "https://duckduckgo.com"
    }
}