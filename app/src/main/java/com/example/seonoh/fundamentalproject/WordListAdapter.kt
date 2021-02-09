package com.example.seonoh.fundamentalproject

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.seonoh.fundamentalproject.databinding.WordlistItemBinding
import java.util.*


class WordListAdapter : RecyclerView.Adapter<WordListAdapter.WordViewHolder> {
    private lateinit var mInflater: LayoutInflater
    private lateinit var mWordList: LinkedList<String>

    constructor(
        context: Context?,
        wordList: LinkedList<String>
    ) {
        mInflater = LayoutInflater.from(context)
        this.mWordList = wordList
    }

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        holder.bind(mWordList[position])
//        val mCurrent =
//        holder.wordItemView!!.text = mCurrent
    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): WordViewHolder {
        return WordViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.wordlist_item,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return mWordList.size
    }

    inner class WordViewHolder(private val binding: WordlistItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(data : String) {
            binding.run {
                word.text = data
                executePendingBindings()
            }
        }
    }
}

