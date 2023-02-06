package com.example.simplewishlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var wishlist: List<wishlist>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.submit).setOnClickListener {
            val itemname= findViewById<EditText>(R.id.itemname).text.toString()
            val itemprice= findViewById<EditText>(R.id.itemprice).text.toString()
            val itemurl= findViewById<EditText>(R.id.itemurl).text.toString()
            //println(itemname+itemprice+itemurl)
            // Lookup the RecyclerView in activity layout
            val listRv = findViewById<RecyclerView>(R.id.list)
            listRv.layoutManager = LinearLayoutManager(this)
            fetcher.wappend(itemname,itemprice,itemurl)
            wishlist = fetcher.getlist()
            val adap = adapter(wishlist)
            listRv.adapter = adap
            adap.notifyDataSetChanged()
        }
    }
}