package com.example.recyclerview_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    lateinit var items: MutableList<Items>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        items = ItemTracker.getItems()

        val adapter = ItemAdapter(items)

        val itemRecyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        itemRecyclerView.adapter = adapter
        itemRecyclerView.layoutManager = LinearLayoutManager(this)


        adapter.setOnItemClickListener(object : ItemAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {
                Toast.makeText(getApplicationContext(), position.toString(), Toast.LENGTH_SHORT).show();
            }

        })



        val addButton = findViewById<Button>(R.id.button)

        addButton.setOnClickListener {


            var Name = findViewById<EditText>(R.id.itemName).getText().toString()

            var Price = findViewById<EditText>(R.id.itemPrice).getText().toString()

            var Link = findViewById<EditText>(R.id.itemLink).getText().toString()

            val newItem = Items(Name, Price, Link)
            ItemTracker.addItem(newItem)

            adapter.notifyDataSetChanged()

            Log.d("test", ItemTracker.getItems().toString())
        }
    }
}

