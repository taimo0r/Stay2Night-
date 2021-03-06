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
import com.chaos.view.PinView;
import com.taimoor.stay2night.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityRetailerVerifyOtpBinding implements ViewBinding {
  @NonNull
  private final ScrollView rootView;

  @NonNull
  public final ImageView OTPCloseBtn;

  @NonNull
  public final TextView OTPDescription;

  @NonNull
  public final PinView pinView;

  @NonNull
  public final Button verifyCodeBtn;

  private ActivityRetailerVerifyOtpBinding(@NonNull ScrollView rootView,
      @NonNull ImageView OTPCloseBtn, @NonNull TextView OTPDescription, @NonNull PinView pinView,
      @NonNull Button verifyCodeBtn) {
    this.rootView = rootView;
    this.OTPCloseBtn = OTPCloseBtn;
    this.OTPDescription = OTPDescription;
    this.pinView = pinView;
    this.verifyCodeBtn = verifyCodeBtn;
  }

  @Override
  @NonNull
  public ScrollView getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityRetailerVerifyOtpBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityRetailerVerifyOtpBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_retailer_verify_otp, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityRetailerVerifyOtpBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.OTP_close_btn;
      ImageView OTPCloseBtn = rootView.findViewById(id);
      if (OTPCloseBtn == null) {
        break missingId;
      }

      id = R.id.OTP_Description;
      TextView OTPDescription = rootView.findViewById(id);
      if (OTPDescription == null) {
        break missingId;
      }

      id = R.id.pin_view;
      PinView pinView = rootView.findViewById(id);
      if (pinView == null) {
        break missingId;
      }

      id = R.id.verify_code_btn;
      Button verifyCodeBtn = rootView.findViewById(id);
      if (verifyCodeBtn == null) {
        break missingId;
      }

      return new ActivityRetailerVerifyOtpBinding((ScrollView) rootView, OTPCloseBtn,
          OTPDescription, pinView, verifyCodeBtn);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
