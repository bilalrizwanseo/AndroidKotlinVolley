package com.technohem.androidkotlinvolley

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_json_object.*

class jsonObjectActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_json_object)

        button_find.setOnClickListener {

            var url:String = "http://192.168.0.103/UdemyKotlinWeb/find_emp.php?id=" + edit_id.text.toString()

            var rq:RequestQueue = Volley.newRequestQueue(this)
            // 'null' -> use for json request (we dont have it now)
            // JsonObjectRequest(1,2,3,4,5)
            var jor = JsonObjectRequest(Request.Method.GET,url,null, Response.Listener { response ->

                text_name.text = response.getString("name")
                text_salary.text = response.getString("salary")

            },Response.ErrorListener { error ->
                text_name.text = error.message
            })

            // to make connection
            rq.add(jor)

        }
    }
}
