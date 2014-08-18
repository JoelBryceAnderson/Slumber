package com.janderson.slumber;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

public class UnpluggedReceiver extends BroadcastReceiver {
    public UnpluggedReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        SharedPreferences sharedpreferences =
                context.getSharedPreferences("prefs", Context.MODE_PRIVATE);
        String enabled = sharedpreferences.getString("enabled", "true");
        if (enabled.equals("true")) {
            Intent startMain = new Intent(Intent.ACTION_MAIN);
            startMain.addCategory(Intent.CATEGORY_HOME);
            startMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(startMain);
        }
    }
}
