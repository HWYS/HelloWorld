package com.hwys.helloworld;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by htetwaiyanswe on 3/11/18.
 */

public class MyListAdapter extends BaseAdapter{
    private String[] arrayList;
    Context context;

    public MyListAdapter(String[] reciever, Context _context){
        arrayList = reciever;
        context = _context;
    }
    @Override
    public int getCount() {
        return arrayList.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_itme, parent, false);
        /*TextView tvTitle = view.findViewById(R.id.tvTitle);
        tvTitle.setText(arrayList[position]);*/

        return  view;
    }
}
