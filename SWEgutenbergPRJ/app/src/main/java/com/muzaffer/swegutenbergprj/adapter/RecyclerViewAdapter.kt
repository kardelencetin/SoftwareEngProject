package com.muzaffer.swegutenbergprj.adapter

import android.content.Intent
import android.graphics.Color
import android.text.Layout
import android.view.LayoutInflater
import android.view.OnReceiveContentListener
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.muzaffer.swegutenbergprj.R
import com.muzaffer.swegutenbergprj.model.BooksModel
import com.muzaffer.swegutenbergprj.view.SecondPageFragment
import com.muzaffer.swegutenbergprj.view.HomePageFragment
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.row_home_page.view.*

class RecyclerViewAdapter (private val booksList : ArrayList<BooksModel>,private val listener: Listener) : RecyclerView.Adapter<RecyclerViewAdapter.RowHolder>() {

    interface Listener {

        fun onItemClick (booksModel: BooksModel) {
        }
    }
    private val colors : Array<String> = arrayOf("#FFE082","#FFD54F","#FFCA28","#FFC107","#FFB300","#FFA000","#FF8F00","#FF6F00","#FFE57F", "#FFD740", "#FFC400","#FFAB00")


    class RowHolder( view : View) : RecyclerView.ViewHolder(view) {
        fun bind(booksModel: BooksModel,colors : Array<String>,position: Int, listener: Listener){
            itemView.setBackgroundColor(Color.parseColor(colors[position % 12]))
            itemView.setOnClickListener{
                listener.onItemClick(booksModel)
            }
            itemView.text_name.text = booksModel.title
            itemView.text_tagline.text = booksModel.subtitle
            Picasso.get()
                .load(booksModel.image)
                .into(itemView.imageView)



        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_home_page,parent,false)
        
        return RowHolder(view)
    }
    override fun onBindViewHolder(holder: RowHolder, position: Int) {

        holder.bind(booksList[position],colors,position,listener)
    }
    override fun getItemCount(): Int {
        return booksList.count()
    }
}