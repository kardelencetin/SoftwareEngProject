package com.kardelencetin.gutenbergmobile

import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val animatedBackgroundImage = (loginLayout.background as AnimationDrawable)
        animatedBackgroundImage.setEnterFadeDuration(2500)
        animatedBackgroundImage.setExitFadeDuration(5000)
        animatedBackgroundImage.start()

        btnRegLogin.setOnClickListener {

            val action = LoginFragmentDirections.actionLoginFragmentToRegisterFragment()
            Navigation.findNavController(it).navigate(action)

        }

        buttonLogin.setOnClickListener {

            val action = LoginFragmentDirections.actionLoginFragmentToBooksRecyclerView()
            Navigation.findNavController(it).navigate(action)
        }
    }


}