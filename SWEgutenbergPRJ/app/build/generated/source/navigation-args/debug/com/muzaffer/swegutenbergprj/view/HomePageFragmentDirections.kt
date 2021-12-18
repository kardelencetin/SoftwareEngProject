package com.muzaffer.swegutenbergprj.view

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.muzaffer.swegutenbergprj.R

public class HomePageFragmentDirections private constructor() {
  public companion object {
    public fun actionHomePageFragmentToSecondPageFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_homePageFragment_to_secondPageFragment)
  }
}
