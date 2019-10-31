package com.technohem.androidkotlinvolley

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var url:String = "http://192.168.0.103/UdemyKotlinWeb/greeting.php"

        var rq:RequestQueue = Volley.newRequestQueue(this)
        // type of data
        // String, JSON Object, JSON Array

        // request required four parameters -> StringRequest(1,2,3,4)
        // var sr = StringRequest(Request.Method.GET,url,Response.Listener { response ->  },Response.ErrorListener { error ->  })

        // response -> 'parameter' of type 'String'
        // 'Get'-> "fast with low security"  and  'POST' -> "slow but high security"
        var sr = StringRequest(Request.Method.GET,url,Response.Listener { response ->
            textView.text = response
        },Response.ErrorListener { error ->
            textView.text = error.message
        })

        // to make connection
        rq.add(sr)
    }
}
