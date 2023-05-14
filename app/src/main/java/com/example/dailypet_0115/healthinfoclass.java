package com.example.dailypet_0115;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;

import java.util.List;

public class healthinfoclass  extends ArrayAdapter<healthclass> {
    private Activity context;
    private List<healthclass> healthList;

    public healthinfoclass(Activity context,List<healthclass> healthList){
        super(context,R.layout.healthrecord_dontuse,healthList);
        this.context=context;
        this.healthList=healthList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View listView=inflater.inflate(R.layout.healthrecord_dontuse,null,true);
        EditText Th=(EditText) listView.findViewById(R.id.ShowTh);
        EditText Tw=(EditText) listView.findViewById(R.id.ShowTw);
        healthclass healthclass=healthList.get(position);
        Th.setText(healthclass.getrHigh());
        Tw.setText(healthclass.getrWeight());
        return listView;
    }
}
