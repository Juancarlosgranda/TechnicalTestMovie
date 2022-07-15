package com.jc.app.technical.presentation.dataBinding

import android.annotation.SuppressLint
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.CircleCropTransformation
import com.jc.app.technical.R
import com.jc.app.technical.presentation.adapters.MovieListAdapter
import com.jc.app.technical.presentation.ui.model.Movie
import com.jc.app.technical.presentation.utils.URL_IMAGE

@BindingAdapter("app:submitMovieList")
fun submitMovieListToAdapterListAdapter(listView: RecyclerView, items: List<Movie>?) {
    items?.let { (listView.adapter as MovieListAdapter).submitList(items) }
}

@BindingAdapter("app:showCircleCropImage")
fun showCircleCropImage(imageView: ImageView, imageUrl: String){
    if (imageUrl.isNotEmpty()){
        imageView.load(URL_IMAGE + imageUrl) {
            crossfade(true)
            placeholder(R.drawable.ic_placeholder)
            transformations(CircleCropTransformation())
        }
    }
}

@BindingAdapter("app:showImage")
fun showImage(imageView: ImageView, imageUrl: String){
    if (imageUrl.isNotEmpty()){
        imageView.load(URL_IMAGE + imageUrl) {
            crossfade(true)
            placeholder(R.drawable.ic_placeholder)
        }
    }
}

@BindingAdapter("app:gone_unless")
fun goneUnless(view: View, visible: Boolean) {
    view.visibility = if (visible) View.VISIBLE else View.GONE
}

@SuppressLint("SetTextI18n")
@BindingAdapter("setFirstText", "setSecondText")
fun setTextWithIntString(
    view: TextView,
    firstText: String?,
    secondText: String?
) {
    if (firstText != null && secondText != null){
        view.text = "$firstText $secondText"
    }
}