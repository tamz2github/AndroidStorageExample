package com.vsb.kru13.androidstorageexample;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends Activity {

    public static final String MY_PREFS_NAME = "MyPreferencesFile";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        saveToSharedPreferences();

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

}
