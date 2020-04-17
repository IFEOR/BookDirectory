package com.ifeor.bookdirectory.util

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.ifeor.bookdirectory.R

fun ImageView.setImagePlaceholder(uri: String?) {
    val options = RequestOptions()
        .placeholder(R.drawable.no_photo)
        .error(R.mipmap.ic_launcher)
    Glide.with(this.context)
        .setDefaultRequestOptions(options)
        .load(uri)
        .into(this)
}
