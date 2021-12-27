package com.kardelencetin.gutenbergmobile

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections

public class LoginFragmentDirections private constructor() {
  public companion object {
    public fun actionLoginFragmentToRegisterFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_loginFragment_to_registerFragment)

    public fun actionLoginFragmentToBooksRecyclerView(): NavDirections =
        ActionOnlyNavDirections(R.id.action_loginFragment_to_booksRecyclerView)
  }
}
