// Generated by view binder compiler. Do not edit!
package com.taimoor.stay2night.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.taimoor.stay2night.R;
import java.lang.NullPointerException;
import java.lang.Override;

public final class ActivityRoomsMapLocationBinding implements ViewBinding {
  @NonNull
  private final View rootView;

  private ActivityRoomsMapLocationBinding(@NonNull View rootView) {
    this.rootView = rootView;
  }

  @Override
  @NonNull
  public View getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityRoomsMapLocationBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityRoomsMapLocationBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_rooms_map_location, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityRoomsMapLocationBinding bind(@NonNull View rootView) {
    if (rootView == null) {
      throw new NullPointerException("rootView");
    }

    return new ActivityRoomsMapLocationBinding(rootView);
  }
}
