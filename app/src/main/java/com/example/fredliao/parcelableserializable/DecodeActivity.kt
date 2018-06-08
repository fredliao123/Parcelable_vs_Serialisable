package com.example.fredliao.parcelableserializable

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.example.fredliao.parcelableserializable.model.UserParcelable
import com.example.fredliao.parcelableserializable.model.UserSerializable

class DecodeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.decode_activity)
    }

    fun buttonClick(v: View) {

        var total_time_difference_parcelble: Double = 0.0
        var total_time_difference_serialisable: Double = 0.0

        for (i in 1..5000) {
            val intent = getIntent()
            val startP = System.nanoTime()
            val userP: UserParcelable = intent.getParcelableExtra("userParcelable")
            val endP = System.nanoTime()
            total_time_difference_parcelble += (endP - startP)

            val startS = System.nanoTime()
            val userS: UserSerializable = intent.getSerializableExtra("userSerializable") as UserSerializable
            val endS = System.nanoTime()
            total_time_difference_serialisable += (endS - startS)
        }

        println("Deparcel time difference  " + total_time_difference_parcelble / 5000)

        println("Deserialise time difference  " + total_time_difference_serialisable / 5000)
    }
}