package com.example.graduation.util

import android.content.Context
import android.content.res.ColorStateList
import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.drawable.Drawable
import android.location.Location
import android.view.View
import android.widget.ImageView
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat
import androidx.core.widget.ImageViewCompat
import coil.load
import coil.transform.RoundedCornersTransformation
import com.google.gson.Gson
import com.example.graduation.data.models.ErrorResponse

fun Context.getStringByName(name: String): String {
    return getString(resources.getIdentifier(name, "string", packageName))
}

val Float.toPx get() = this * Resources.getSystem().displayMetrics.density

val Float.toDp get() = this / Resources.getSystem().displayMetrics.density

val Int.toPx get() = (this * Resources.getSystem().displayMetrics.density).toInt()

val Int.toDp get() = (this / Resources.getSystem().displayMetrics.density).toInt()


fun View.showView() {
    this.visibility = View.VISIBLE
}

fun View.hideView() {
    this.visibility = View.GONE
}

fun View.invisibleView() {
    this.visibility = View.INVISIBLE
}

fun ImageView.setTint(@ColorRes color: Int?) {
    if (color == null) {
        ImageViewCompat.setImageTintList(this, null)
    } else {
        ImageViewCompat.setImageTintList(
            this,
            ColorStateList.valueOf(ContextCompat.getColor(context, color))
        )
    }
}

fun ImageView.loadImageFromInternet(
    imageUrl: String?,
    errorPlaceholder: Drawable? = null,
    roundedCorner: Float = 0f
) {
    this.load(imageUrl) {
        crossfade(true)
        crossfade(500)
        RoundedCornersTransformation(roundedCorner)
        error(errorPlaceholder)
    }
}


fun getErrorResponse(response: String): ErrorResponse {
    return Gson().fromJson(response, ErrorResponse::class.java)
}

fun Double.roundTheNumber(numberAfterDot: Int = 2): String {
    var result = ""
    result = "%.${numberAfterDot}f".format(this)
    if (result.endsWith("00"))
        result = result.dropLast(3)
    else if (result.endsWith(".0"))
        result = result.dropLast(2)
    return result

}

fun View.debounceClick(debounceTime: Long = 1000L, action: () -> Unit) {
    setOnClickListener {
        when {
            tag != null && (tag as Long) > System.currentTimeMillis() -> return@setOnClickListener
            else -> {
                tag = System.currentTimeMillis() + debounceTime
                action()
            }
        }
    }
}

fun Context.colorList(id: Int): ColorStateList {
    return ColorStateList.valueOf(ContextCompat.getColor(this, id))
}



fun distanceInMeter(startLat: Double, startLon: Double, endLat: Double, endLon: Double): Float {
    val results = FloatArray(1)
    Location.distanceBetween(startLat,startLon,endLat,endLon,results)
    return results[0]
}

