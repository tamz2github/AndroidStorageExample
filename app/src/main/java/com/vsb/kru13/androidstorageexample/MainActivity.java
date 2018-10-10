package com.vsb.kru13.androidstorageexample;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends Activity {

    public static final String MY_PREFS_NAME = "MyPreferencesFile";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        saveToSharedPreferences();
        loadFromSharedPreferences();

    }

    private void saveToSharedPreferences() {

        SharedPreferences sharedPreferences = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("id", "TAMZ2");
        editor.putInt("lectureNo", 4);
        editor.putFloat( "piNumber", 3.1415926f);
        editor.putBoolean( "boolValue", true);
        editor.putLong( "longNumber", 123456);

        editor.apply();

    }

    private void loadFromSharedPreferences() {
        SharedPreferences sharedPreferences = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);

        Log.d("MainActivity", "SharedPreferences id = " + sharedPreferences.getString("id", " defaultId"));
        Log.d("MainActivity", "SharedPreferences lectureNo = " + sharedPreferences.getInt("lectureNo", 0));
        Log.d("MainActivity", "SharedPreferences piNumber = " + sharedPreferences.getFloat("piNumber", 0));
        Log.d("MainActivity", "SharedPreferences boolValue = " + sharedPreferences.getBoolean("boolValue", true));
        Log.d("MainActivity", "SharedPreferences longNumber = " + sharedPreferences.getLong("longNumber", 0));

    }

}
