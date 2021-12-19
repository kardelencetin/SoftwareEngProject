package com.muzaffer.swegutenbergprj

import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import androidx.navigation.Navigation
import com.muzaffer.swegutenbergprj.view.HomePageFragment
import kotlinx.android.synthetic.main.fragment_login.*
import kotlinx.android.synthetic.main.fragment_register.*



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

            val action = LoginFragmentDirections.actionLoginFragmentToHomePageFragment()
            Navigation.findNavController(it).navigate(action)

        }

    }


}