// Generated by view binder compiler. Do not edit!
package com.taimoor.stay2night.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.textfield.TextInputLayout;
import com.taimoor.stay2night.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityRetailerSignupBinding implements ViewBinding {
  @NonNull
  private final ScrollView rootView;

  @NonNull
  public final ImageView signupBackBtn;

  @NonNull
  public final TextInputLayout signupEmail;

  @NonNull
  public final TextInputLayout signupFullname;

  @NonNull
  public final Button signupLoginBtn;

  @NonNull
  public final Button signupNextBtn;

  @NonNull
  public final TextInputLayout signupPassword;

  @NonNull
  public final TextView signupSlideText;

  @NonNull
  public final TextView signupTitleText;

  @NonNull
  public final TextInputLayout signupUsername;

  private ActivityRetailerSignupBinding(@NonNull ScrollView rootView,
      @NonNull ImageView signupBackBtn, @NonNull TextInputLayout signupEmail,
      @NonNull TextInputLayout signupFullname, @NonNull Button signupLoginBtn,
      @NonNull Button signupNextBtn, @NonNull TextInputLayout signupPassword,
      @NonNull TextView signupSlideText, @NonNull TextView signupTitleText,
      @NonNull TextInputLayout signupUsername) {
    this.rootView = rootView;
    this.signupBackBtn = signupBackBtn;
    this.signupEmail = signupEmail;
    this.signupFullname = signupFullname;
    this.signupLoginBtn = signupLoginBtn;
    this.signupNextBtn = signupNextBtn;
    this.signupPassword = signupPassword;
    this.signupSlideText = signupSlideText;
    this.signupTitleText = signupTitleText;
    this.signupUsername = signupUsername;
  }

  @Override
  @NonNull
  public ScrollView getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityRetailerSignupBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityRetailerSignupBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_retailer_signup, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityRetailerSignupBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.signup_back_btn;
      ImageView signupBackBtn = rootView.findViewById(id);
      if (signupBackBtn == null) {
        break missingId;
      }

      id = R.id.signup_email;
      TextInputLayout signupEmail = rootView.findViewById(id);
      if (signupEmail == null) {
        break missingId;
      }

      id = R.id.signup_fullname;
      TextInputLayout signupFullname = rootView.findViewById(id);
      if (signupFullname == null) {
        break missingId;
      }

      id = R.id.signup_login_btn;
      Button signupLoginBtn = rootView.findViewById(id);
      if (signupLoginBtn == null) {
        break missingId;
      }

      id = R.id.signup_next_btn;
      Button signupNextBtn = rootView.findViewById(id);
      if (signupNextBtn == null) {
        break missingId;
      }

      id = R.id.signup_password;
      TextInputLayout signupPassword = rootView.findViewById(id);
      if (signupPassword == null) {
        break missingId;
      }

      id = R.id.signup_slide_text;
      TextView signupSlideText = rootView.findViewById(id);
      if (signupSlideText == null) {
        break missingId;
      }

      id = R.id.signup_title_text;
      TextView signupTitleText = rootView.findViewById(id);
      if (signupTitleText == null) {
        break missingId;
      }

      id = R.id.signup_username;
      TextInputLayout signupUsername = rootView.findViewById(id);
      if (signupUsername == null) {
        break missingId;
      }

      return new ActivityRetailerSignupBinding((ScrollView) rootView, signupBackBtn, signupEmail,
          signupFullname, signupLoginBtn, signupNextBtn, signupPassword, signupSlideText,
          signupTitleText, signupUsername);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
