package com.example.fredliao.parcelableserializable

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.example.fredliao.parcelableserializable.model.UserParcelable
import com.example.fredliao.parcelableserializable.model.UserSerializable

class MainActivity : AppCompatActivity() {

    val userParcelable = UserParcelable()

    val userSerializable = UserSerializable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun buttonClick(v: View) {
        val intent = Intent(this, DecodeActivity::class.java)
        val startP = System.nanoTime()
        intent.putExtra("userParcelable", userParcelable)
        val endP = System.nanoTime()
        println("Parcel time difference " + (endP - startP))

        val startS = System.nanoTime()
        intent.putExtra("userSerializable", userSerializable)
        val endS = System.nanoTime()
        println("Serialise time difference " + (endS - startS))
        startActivity(intent)
    }
}