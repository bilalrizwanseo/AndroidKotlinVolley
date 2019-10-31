package com.technohem.androidkotlinvolley

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_picasso_image.*

class PicassoImageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_picasso_image)

        var url = "http://192.168.0.103/UdemyKotlinWeb/kotlin_image.png"

        Picasso.with(this).load(url).into(imageView)
    }
}
