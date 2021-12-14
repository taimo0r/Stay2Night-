// Generated by view binder compiler. Do not edit!
package com.taimoor.stay2night.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.taimoor.stay2night.R;
import de.hdodenhof.circleimageview.CircleImageView;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityProfileBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final TextView profileDisplayName;

  @NonNull
  public final CircleImageView profileDp;

  @NonNull
  public final TextView profileEmail;

  @NonNull
  public final Button profileLogoutBtn;

  @NonNull
  public final TextView profileName;

  private ActivityProfileBinding(@NonNull LinearLayout rootView,
      @NonNull TextView profileDisplayName, @NonNull CircleImageView profileDp,
      @NonNull TextView profileEmail, @NonNull Button profileLogoutBtn,
      @NonNull TextView profileName) {
    this.rootView = rootView;
    this.profileDisplayName = profileDisplayName;
    this.profileDp = profileDp;
    this.profileEmail = profileEmail;
    this.profileLogoutBtn = profileLogoutBtn;
    this.profileName = profileName;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityProfileBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityProfileBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_profile, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityProfileBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.profile_displayName;
      TextView profileDisplayName = rootView.findViewById(id);
      if (profileDisplayName == null) {
        break missingId;
      }

      id = R.id.profile_dp;
      CircleImageView profileDp = rootView.findViewById(id);
      if (profileDp == null) {
        break missingId;
      }

      id = R.id.profile_email;
      TextView profileEmail = rootView.findViewById(id);
      if (profileEmail == null) {
        break missingId;
      }

      id = R.id.profile_logoutBtn;
      Button profileLogoutBtn = rootView.findViewById(id);
      if (profileLogoutBtn == null) {
        break missingId;
      }

      id = R.id.profile_name;
      TextView profileName = rootView.findViewById(id);
      if (profileName == null) {
        break missingId;
      }

      return new ActivityProfileBinding((LinearLayout) rootView, profileDisplayName, profileDp,
          profileEmail, profileLogoutBtn, profileName);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}