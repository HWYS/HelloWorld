package com.hwys.helloworld;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        SharedPreferences preferences = getSharedPreferences("My_Pref", MODE_PRIVATE);

        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        Toast.makeText(getApplicationContext(), preferences.getString("hello", ""), Toast.LENGTH_LONG).show();
    }
}
