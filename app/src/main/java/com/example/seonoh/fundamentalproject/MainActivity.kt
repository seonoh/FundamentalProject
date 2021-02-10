package com.example.seonoh.fundamentalproject

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.seonoh.fundamentalproject.databinding.ActivityMainBinding
import java.util.*


class MainActivity : AppCompatActivity() {
    private val mWordList: LinkedList<String> = LinkedList<String>();
    private lateinit var mAdapter: WordListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)

        for (i in 0..19) {
            mWordList.addLast("Word $i")
        }

        mAdapter = WordListAdapter(this, mWordList)
        binding.recyclerview.run {
            adapter = mAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }
    }
}