package com.hwys.helloworld.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.support.v7.widget.AppCompatButton;
import com.hwys.helloworld.AlbumInfo;
import com.hwys.helloworld.EditAlbumActivity;
import com.hwys.helloworld.R;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {
    List<AlbumInfo> albumInfoList; Context context;

    public RecyclerAdapter(Context _context, List<AlbumInfo> _albumInfoList){
        context = _context;
        albumInfoList = _albumInfoList;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.list_itme, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.tvArtistName.setText(albumInfoList.get(position).getSongName());
        holder.tvArtistName.setText(albumInfoList.get(position).getArtistName());
        holder.btnEdit.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent i = new Intent(context, EditAlbumActivity.class);
                i.putExtra("id", albumInfoList.get(position).getId());
                i.putExtra("songName", albumInfoList.get(position).getSongName());
                i.putExtra("artistName", albumInfoList.get(position).getArtistName());
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return albumInfoList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tvSongname, tvArtistName; AppCompatButton btnEdit;
        public MyViewHolder(View itemView) {
            super(itemView);

            tvSongname = itemView.findViewById(R.id.tvSongName);
            tvArtistName = itemView.findViewById(R.id.tvArtistName);
            btnEdit = itemView.findViewById(R.id.btnEdit);
        }
    }
}
