// Generated by view binder compiler. Do not edit!
package com.taimoor.stay2night.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.taimoor.stay2night.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityMakeSelectionBinding implements ViewBinding {
  @NonNull
  private final ScrollView rootView;

  @NonNull
  public final TextView EmailDesc;

  @NonNull
  public final ImageView EmailIcon;

  @NonNull
  public final TextView EmailTitle;

  @NonNull
  public final ImageView SelectionBackbtn;

  @NonNull
  public final TextView mobileDesc;

  @NonNull
  public final ImageView mobileIcon;

  @NonNull
  public final TextView mobileTitle;

  private ActivityMakeSelectionBinding(@NonNull ScrollView rootView, @NonNull TextView EmailDesc,
      @NonNull ImageView EmailIcon, @NonNull TextView EmailTitle,
      @NonNull ImageView SelectionBackbtn, @NonNull TextView mobileDesc,
      @NonNull ImageView mobileIcon, @NonNull TextView mobileTitle) {
    this.rootView = rootView;
    this.EmailDesc = EmailDesc;
    this.EmailIcon = EmailIcon;
    this.EmailTitle = EmailTitle;
    this.SelectionBackbtn = SelectionBackbtn;
    this.mobileDesc = mobileDesc;
    this.mobileIcon = mobileIcon;
    this.mobileTitle = mobileTitle;
  }

  @Override
  @NonNull
  public ScrollView getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityMakeSelectionBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityMakeSelectionBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_make_selection, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityMakeSelectionBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.Email_desc;
      TextView EmailDesc = rootView.findViewById(id);
      if (EmailDesc == null) {
        break missingId;
      }

      id = R.id.Email_icon;
      ImageView EmailIcon = rootView.findViewById(id);
      if (EmailIcon == null) {
        break missingId;
      }

      id = R.id.Email_title;
      TextView EmailTitle = rootView.findViewById(id);
      if (EmailTitle == null) {
        break missingId;
      }

      id = R.id.Selection_backbtn;
      ImageView SelectionBackbtn = rootView.findViewById(id);
      if (SelectionBackbtn == null) {
        break missingId;
      }

      id = R.id.mobile_desc;
      TextView mobileDesc = rootView.findViewById(id);
      if (mobileDesc == null) {
        break missingId;
      }

      id = R.id.mobile_icon;
      ImageView mobileIcon = rootView.findViewById(id);
      if (mobileIcon == null) {
        break missingId;
      }

      id = R.id.mobile_title;
      TextView mobileTitle = rootView.findViewById(id);
      if (mobileTitle == null) {
        break missingId;
      }

      return new ActivityMakeSelectionBinding((ScrollView) rootView, EmailDesc, EmailIcon,
          EmailTitle, SelectionBackbtn, mobileDesc, mobileIcon, mobileTitle);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
