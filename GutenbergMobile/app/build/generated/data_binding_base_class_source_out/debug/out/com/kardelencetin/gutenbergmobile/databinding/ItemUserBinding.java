// Generated by view binder compiler. Do not edit!
package com.kardelencetin.gutenbergmobile.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.kardelencetin.gutenbergmobile.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ItemUserBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ImageView ivUser;

  @NonNull
  public final TextView tvUsername;

  private ItemUserBinding(@NonNull ConstraintLayout rootView, @NonNull ImageView ivUser,
      @NonNull TextView tvUsername) {
    this.rootView = rootView;
    this.ivUser = ivUser;
    this.tvUsername = tvUsername;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ItemUserBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ItemUserBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.item_user, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ItemUserBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.iv_user;
      ImageView ivUser = ViewBindings.findChildViewById(rootView, id);
      if (ivUser == null) {
        break missingId;
      }

      id = R.id.tv_username;
      TextView tvUsername = ViewBindings.findChildViewById(rootView, id);
      if (tvUsername == null) {
        break missingId;
      }

      return new ItemUserBinding((ConstraintLayout) rootView, ivUser, tvUsername);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
