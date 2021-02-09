package com.example.seonoh.fundamentalproject

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
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
        val mCurrent = mWordList[position]
        holder.wordItemView!!.text = mCurrent
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): WordViewHolder {
        val mItemView : View = mInflater.inflate(R.layout.wordlist_item,parent,false)

        return WordViewHolder(mItemView, this)
    }

    override fun getItemCount(): Int {
        return mWordList.size
    }

    inner class WordViewHolder : RecyclerView.ViewHolder{
        var wordItemView: TextView? = null
        var mAdapter: WordListAdapter? = null
        constructor(itemView: View, adapter: WordListAdapter?) {
            wordItemView = itemView.findViewById(R.id.word)
            mAdapter = adapter
        }
    }
}

