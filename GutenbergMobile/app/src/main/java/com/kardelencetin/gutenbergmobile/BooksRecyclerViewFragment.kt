package com.kardelencetin.gutenbergmobile

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.KeyEvent
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.kardelencetin.gutenbergmobile.adapter.UserAdapter
import com.kardelencetin.gutenbergmobile.databinding.FragmentBooksRecyclerViewBinding
import com.kardelencetin.gutenbergmobile.viewmodel.BooksRecyclerViewModel

class BooksRecyclerViewFragment : Fragment() {


    private lateinit var binding: FragmentBooksRecyclerViewBinding
    private lateinit var adapter: UserAdapter
    private lateinit var viewModel: BooksRecyclerViewModel




    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        binding = FragmentBooksRecyclerViewBinding.inflate(layoutInflater)


        adapter = UserAdapter()

        adapter.notifyDataSetChanged()



        viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()).get(BooksRecyclerViewModel::class.java)
        binding.apply {


            val linearLayoutManager:LinearLayoutManager = LinearLayoutManager(this@BooksRecyclerViewFragment.requireContext())
            linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
            rvUser.layoutManager = linearLayoutManager
            rvUser.adapter = adapter
            rvUser.setHasFixedSize(true)



            btnSearch.setOnClickListener {

                searchUser()

            }

            etQuery.setOnKeyListener { v, keyCode, event ->

                if (event.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER){
                    searchUser()
                    return@setOnKeyListener true
                }
                return@setOnKeyListener false
            }

        }
        viewModel.getSearchUsers().observe(this,{

            if(it!=null){

                adapter.setList(it)
                showLoading(false)
            }


        })

    }




    private fun searchUser(){

        binding.apply {

            val query = etQuery.text.toString()
            if (query.isEmpty()) return
            showLoading(true)
            viewModel.setSearchUser(query)

        }

    }


    private fun showLoading(state: Boolean) {

        if (state) {
            binding.progressBar.visibility = View.VISIBLE


        }
        else {

            binding.progressBar.visibility = View.GONE
        }

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnSearch.setOnClickListener {

            searchUser()

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_books_recycler_view, container, false)
    }


}