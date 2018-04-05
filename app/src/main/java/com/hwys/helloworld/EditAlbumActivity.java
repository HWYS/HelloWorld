package com.hwys.helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditAlbumActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_album);

        final EditText etSongName = findViewById(R.id.etSongName);
        final EditText etArtistName = findViewById(R.id.etArtistName);
        Button btnEdit = findViewById(R.id.btnEdit);

        final DatabaseHelper dbHelper = new DatabaseHelper(getApplicationContext());

        etSongName.setText(getIntent().getExtras().getString("songName"));
        etArtistName.setText(getIntent().getExtras().getString("artistName"));

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlbumInfo info = new AlbumInfo(etSongName.getText().toString(), etArtistName.getText().toString(), "", 0);
                info.setId(getIntent().getExtras().getInt("id"));
                info.setSongName(etSongName.getText().toString());

                dbHelper.updateAlbum(info);

                finish();
            }
        });
    }
}
