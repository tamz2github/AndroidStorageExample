package com.vsb.kru13.androidstorageexample;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
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

        saveToInternalStorageFile();
        readFromInternalStorageFile();

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

    private void saveToInternalStorageFile() {
        String filename = "soubor.txt";
        String fileContents = "Hello world!";
        FileOutputStream outputStream;

        try {
            outputStream = openFileOutput(filename, Context.MODE_PRIVATE);
            outputStream.write(fileContents.getBytes());
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void readFromInternalStorageFile() {
        String filename = "soubor.txt";
        FileInputStream inputStream;

        try {
            inputStream = openFileInput(filename);


            InputStreamReader isr = new InputStreamReader(inputStream);
            BufferedReader br = new BufferedReader(isr);
            Log.d("MainActivity", "File line = " + br.readLine());


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
