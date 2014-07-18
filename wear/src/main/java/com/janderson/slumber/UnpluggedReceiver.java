package com.janderson.slumber;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class UnpluggedReceiver extends BroadcastReceiver {
    public UnpluggedReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Intent startMain = new Intent(Intent.ACTION_MAIN);
        startMain.addCategory(Intent.CATEGORY_HOME);
        startMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(startMain);
    }
}
