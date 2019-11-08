package com.yap.pokedex_android.ui.common

import android.view.View
import androidx.databinding.BindingConversion
import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField

object BindingConverters {

    @BindingConversion
    @JvmStatic fun convertBooleanToVisibility(visible: Boolean): Int {
        return if (visible) View.VISIBLE else View.GONE
    }

    @BindingConversion
    @JvmStatic fun convertBooleanToVisibility(visible: ObservableBoolean?): Int {
        if (visible == null) {
            return View.GONE
        }
        return if (visible.get()) View.VISIBLE else View.GONE
    }

    @BindingConversion
    @JvmStatic fun convertStringToVisibility(text: String?): Int {
        return if (!text.isNullOrEmpty()) View.VISIBLE else View.GONE
    }

    @BindingConversion
    @JvmStatic fun convertStringToVisibility(text: ObservableField<String?>?): Int {
        return if (!text?.get().isNullOrEmpty()) View.VISIBLE else View.GONE
    }

    /*@BindingConversion
    @JvmStatic fun convertBooleanAndToVisibility(visible: Boolean, visible2: Boolean): Int {
        return if (visible && visible2) View.VISIBLE else View.GONE
    }

    @BindingConversion
    @JvmStatic fun convertBooleanOrToVisibility(visible: Boolean, visible2: Boolean): Int {
        return if (visible || visible2) View.VISIBLE else View.GONE
    }*/

    @BindingConversion
    @JvmStatic fun convertBooleanToInVisibility(visible: Boolean): Int {
        return if (visible) View.VISIBLE else View.INVISIBLE
    }

    @BindingConversion
    @JvmStatic fun convertNullStringToGone(text: String?): Int {
        return if (text != null && !text.isEmpty()) View.VISIBLE else View.GONE
    }

    @BindingConversion
    @JvmStatic fun convertNullStringToGone(text: ObservableField<String>): Int {
        return if (!text.get().isNullOrEmpty()) View.VISIBLE else View.GONE
    }

    @BindingConversion
    @JvmStatic fun convertColorTextToColor(text: ObservableField<String>): Int {
        return if (!text.get().isNullOrEmpty()) View.VISIBLE else View.GONE
    }

    @BindingConversion
    @JvmStatic fun convertInttoString(integer : Int) : String {
        return integer.toString()
    }

}
