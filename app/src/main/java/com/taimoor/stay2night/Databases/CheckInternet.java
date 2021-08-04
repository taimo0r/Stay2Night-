package com.taimoor.stay2night.Databases;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.taimoor.stay2night.Common.LoginSignup.Login;

public class CheckInternet {

    public boolean isConnected(Context context) {

        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo wifiConn = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        NetworkInfo mobileConn = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);

        if((wifiConn != null && wifiConn.isConnected()) || (mobileConn!= null && mobileConn.isConnected())){
            return true;
        }
        else {
            return false;
        }

    }

}
