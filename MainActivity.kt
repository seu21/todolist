package com.example.my_to_do_list

import android.content.Context
import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listview = findViewById<ListView>(R.id.main_listview)

        listview.adapter = MyCustomAdapter(this)
    }

    private class MyCustomAdapter(context: Context) : BaseAdapter() {

        private val mcontext: Context

        private val tasks = arrayListOf<String>("Clean house", "do homework", "wash clothes")

        init {
            mcontext = context
        }

        override fun getCount(): Int {
            return tasks.size
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()

        }

        override fun getItem(position: Int): Any {
            return "TEST STRING"
        }

        override fun getView(position: Int, convertView: View?, viewGroup: ViewGroup?): View {
            val textview = TextView(mcontext)
            val layoutInflater = LayoutInflater.from(mcontext)
            val rowmain = layoutInflater.inflate(R.layout.row_main, viewGroup, false)

            val textView1 = rowmain.findViewById<TextView>(R.id.textView11)
            textView1.text = tasks.get(position)

            val positionTextView = rowmain.findViewById<TextView>(R.id.positiontextview)
            positionTextView.text = "Task Number $position"

            return rowmain

        }

    }
}
