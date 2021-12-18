package com.muzaffer.swegutenbergprj

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections

public class RegisterFragmentDirections private constructor() {
  public companion object {
    public fun actionRegisterFragmentToLoginFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_registerFragment_to_loginFragment)
  }
}
