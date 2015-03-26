package com.janderson.slumber;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.BatteryManager;

public class ChargingReceiver extends BroadcastReceiver {
    public ChargingReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        SharedPreferences sharedpreferences =
                context.getSharedPreferences("prefs", Context.MODE_PRIVATE);
        String enabled = sharedpreferences.getString("enabled", "true");
        if (enabled.equals("true")){
            Intent i = new Intent();
            i.setClassName("com.janderson.slumber", "com.janderson.slumber.WearActivity");
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            context.startActivity(i);
        }
    }
}
