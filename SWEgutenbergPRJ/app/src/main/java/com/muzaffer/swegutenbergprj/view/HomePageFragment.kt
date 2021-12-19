package com.muzaffer.swegutenbergprj.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.muzaffer.swegutenbergprj.R

import android.content.Intent
import android.widget.Toast


import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.muzaffer.swegutenbergprj.adapter.RecyclerViewAdapter

import com.muzaffer.swegutenbergprj.model.BooksModel
import com.muzaffer.swegutenbergprj.service.BooksAPI
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_home_page.*
import kotlinx.android.synthetic.main.row_home_page.*
import org.jetbrains.annotations.NotNull
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class HomePageFragment : Fragment(), RecyclerViewAdapter.Listener {

    //http://localhost:4000/books/search/The%20Confessions%20of%20Jean%20Jacques%20Roussea
    private val BASE_URL = "http://10.0.2.2:4000/"
    private var booksModels: ArrayList<BooksModel>? = null
    private var recyclerViewAdapter: RecyclerViewAdapter? = null

    override fun onCreate( savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        loadData()

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home_page, container, false)
    }


    private fun loadData() {

        val retrofit = Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val service = retrofit.create(BooksAPI::class.java)
        val call = service.getData()
        call.enqueue(object : Callback<List<BooksModel>> {
            override fun onResponse(
                call: Call<List<BooksModel>>,
                response: Response<List<BooksModel>>
            ) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        booksModels = ArrayList(it)
                        booksModels?.let {
                            recyclerViewAdapter = RecyclerViewAdapter(it, this@HomePageFragment)
                            recyclerViewBook.adapter =  recyclerViewAdapter
                        }
                        for (bookModel: BooksModel in booksModels!!){

                            println(bookModel.title)
                            println(bookModel.subtitle)
                            println(bookModel.image)


                        }
                    }
                }
            }
            override fun onFailure(call: Call<List<BooksModel>>, t: Throwable) {
                t.printStackTrace()
            }
        })
    }

    override fun onItemClick(booksModel: BooksModel) {
        //val intent = Intent(this.requireActivity(),SecondPageFragment::class.java)
        // start your next activity
       // intent.putExtra("Language",booksModel.Language)
       // intent.putExtra("Subject", booksModel.Subject)
       // intent.putExtra("image",booksModel.image)
       // startActivity(intent)
       // onStop()
        Toast.makeText(this.requireContext(), "Clicked : ${booksModel.subtitle} ", Toast.LENGTH_LONG).show()
    }


}