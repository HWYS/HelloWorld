package com.hwys.helloworld;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnHello, btnOne, btnTwo;

    ListView lvTest;

    int numOne, numTwo, result; EditText etTest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnOne = findViewById(R.id.btnOne);
        btnTwo = findViewById(R.id.btnTwo);

        btnOne.setOnClickListener(this);
        btnTwo.setOnClickListener(this);
        etTest = findViewById(R.id.etTest);
        etTest.setError("Error test");

        //DatabaseHelper dbHelper = new DatabaseHelper(getApplicationContext(), "Student", null, 1);

        /*String [] myArray = new String[]{"A", "B", "C"};

        MyListAdapter adapter = new MyListAdapter(myArray, getApplicationContext());
        lvTest.setAdapter(adapter);

        Button btnMyObj = new Button(getApplicationContext());
        btnMyObj.setText("Hello My Obj");
        RelativeLayout.LayoutParams params
        btnMyObj.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));


        LinearLayout mainLayout = findViewById(R.id.main);
        mainLayout.addView(btnMyObj);
        //initializeView();



        Toast.makeText(getApplicationContext(), "Fill NumOne", Toast.LENGTH_LONG).show();*/

    }

    public void onClick(View view){
        switch (view.getId()){


            case R.id.btnOne:
                //SharedPreferences pref = getPreferences(MODE_PRIVATE);
                //SharedPreferences pref = getSharedPreferences("My_Pref", MODE_PRIVATE);
                SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                SharedPreferences.Editor editor = pref.edit();
                editor.putString("hello", "Hello Android 06");
                editor.putBoolean("login", true);
                editor.apply();
                break;

            case R.id.btnTwo:
                Intent i = new Intent(getApplicationContext(), TabActivity.class);
                startActivity(i);
                break;
        }
    }

    void initializeView(){
        btnHello = findViewById(R.id.btnOne);
        btnHello.setText("Hello Android 06");
        btnHello.setText(getString(R.string.hello));

        btnHello.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }

    void initiaizeArray(){
        ArrayList<AlbumInfo> songList = new ArrayList<>();

        AlbumInfo song1 = new AlbumInfo();
        song1.setSongName("Someone Like You");
        song1.setArtistName("Adele");
        song1.setDuration("04:30");
        song1.setAlbumCover(R.mipmap.ic_call_black);

        songList.add(0, song1);
        songList.add(song1);


        AlbumInfo song2 = new AlbumInfo("Perfect", "Ad Sheerean", "04:00", R.mipmap.ic_launcher);
        songList.add(song2);

    }

}
