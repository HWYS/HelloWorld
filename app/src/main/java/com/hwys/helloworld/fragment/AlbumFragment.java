package com.hwys.helloworld.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.hwys.helloworld.AlbumInfo;
import com.hwys.helloworld.DatabaseHelper;
import com.hwys.helloworld.R;
import com.hwys.helloworld.adapter.RecyclerAdapter;

import java.util.List;


public class AlbumFragment extends Fragment {

    Button btnSave;
    RecyclerView rvAlbum;
    List<AlbumInfo> albumInfoList;
    LinearLayoutManager layoutManager; Context context;
    RecyclerAdapter adapter; DatabaseHelper dbHelper;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_album, container, false);
        View v = inflater.inflate(R.layout.fragment_album, container, false);

        context = container.getContext();
        initializeControls(v);
        return  v;
    }

    void initializeControls(View v){
        dbHelper = new DatabaseHelper(context);

        btnSave = v.findViewById(R.id.btnSave);
        rvAlbum = v.findViewById(R.id.rvAlbum);
        rvAlbum.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(context);
        rvAlbum.setLayoutManager(layoutManager);

        albumInfoList = dbHelper.getAllBum();
        adapter = new RecyclerAdapter(context, albumInfoList);
        rvAlbum.setAdapter(adapter);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlbumInfo info = new AlbumInfo("Hello", "Adele", "", 0);
                dbHelper.insertAlbum(info);

                albumInfoList.add(info);
                adapter.notifyItemInserted(albumInfoList.size());
                adapter.notifyDataSetChanged();
            }
        });

    }

    /*@Override
    public void onResume() {
        super.onResume();

        albumInfoList = dbHelper.getAllBum();
        adapter.notifyDataSetChanged();
    }*/
}
