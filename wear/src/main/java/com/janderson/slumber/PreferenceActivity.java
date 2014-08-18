package com.janderson.slumber;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.wearable.view.CircledImageView;
import android.support.wearable.view.WatchViewStub;
import android.view.View;
import android.widget.TextView;

public class PreferenceActivity extends Activity {

    private CircledImageView circleButton;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preference);
        sharedPreferences = getSharedPreferences("prefs", Context.MODE_PRIVATE);
        final String enabled = sharedPreferences.getString("enabled", "true");
        final WatchViewStub stub = (WatchViewStub) findViewById(R.id.watch_view_stub);
        stub.setOnLayoutInflatedListener(new WatchViewStub.OnLayoutInflatedListener() {
            @Override
            public void onLayoutInflated(WatchViewStub stub) {
                circleButton =
                        (CircledImageView) stub.findViewById(R.id.circle_button);
                circleButton.setCircleRadius(56);
                circleButton.setCircleColor(Color.parseColor("#673ab7"));
                if (enabled.equals("true")) {
                    circleButton.setImageResource(R.drawable.ic_check);
                    circleButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            disable();
                        }
                    });
                } else {
                    circleButton.setImageResource(R.drawable.ic_close);
                    circleButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            enable();
                        }
                    });
                }
            }
        });
    }

    private void enable() {
        sharedPreferences.edit().putString("enabled", "true").commit();
        circleButton.setImageResource(R.drawable.ic_check);
        circleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                disable();
            }
        });
    }

    private void disable() {
        sharedPreferences.edit().putString("enabled", "false").commit();
        circleButton.setImageResource(R.drawable.ic_close);
        circleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enable();
            }
        });
    }
}
