package com.yap.pokedex_android.ui.common

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.request.RequestOptions

object BindingAdapters {
    @JvmStatic
    fun loadGlide(imageView : ImageView, url : String?) {
        url?.let {
            Glide.with(imageView.context).load(it).apply(
                RequestOptions().transforms(CenterCrop())
                    .diskCacheStrategy(DiskCacheStrategy.RESOURCE))
                .into(imageView)
        }
    }

    @BindingAdapter("android:GlideSrc")
    @JvmStatic
    fun loadGlideUrl(imageView: ImageView, url : String?) {
        loadGlide(imageView, url)
    }


}