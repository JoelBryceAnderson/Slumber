package com.janderson.slumber;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PowerManager;
import android.support.wearable.view.WatchViewStub;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

public class WearActivity extends Activity {

    private float originalBrightness;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wear);
        final WatchViewStub stub = (WatchViewStub) findViewById(R.id.watch_view_stub);
        stub.setOnLayoutInflatedListener(new WatchViewStub.OnLayoutInflatedListener() {
            @Override
            public void onLayoutInflated(WatchViewStub stub) {
                WindowManager.LayoutParams settings = getWindow().getAttributes();
                originalBrightness = settings.screenBrightness;
                WindowManager.LayoutParams params = getWindow().getAttributes();
                params.screenBrightness = 0.0f;
                params.flags = WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON;
                getWindow().setAttributes(params);
                LinearLayout screen = (LinearLayout) findViewById(R.id.screen);
                screen.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        WindowManager.LayoutParams params = getWindow().getAttributes();
                        params.screenBrightness = originalBrightness;
                        getWindow().setAttributes(params);
                        finish();
                    }
                });
            }
        });
    }
}
