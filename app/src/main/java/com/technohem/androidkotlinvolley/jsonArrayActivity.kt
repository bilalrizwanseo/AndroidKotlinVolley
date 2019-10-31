package com.technohem.androidkotlinvolley

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_json_array.*

class jsonArrayActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_json_array)

        var url:String = "http://192.168.0.103/UdemyKotlinWeb/all_emp.php"
        // var list = ArrayList<String>()
        var result:String = ""

        var rq: RequestQueue = Volley.newRequestQueue(this)
        // 'null' -> use for json request (we dont have it now)
        // JsonObjectRequest(1,2,3,4,5)
        var jar = JsonArrayRequest(Request.Method.GET,url,null, Response.Listener { response ->

            for(x in 0..response.length()-1){
                result+=(response.getJSONObject(x).getString("name") + " - " +
                        response.getJSONObject(x).getString("salary") + "\n")
            }

            textView2.text = result

        }, Response.ErrorListener { error ->
            textView2.text = error.message
        })

        rq.add(jar)
    }
}
