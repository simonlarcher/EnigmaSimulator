package com.masterprogrammer.enigmasimulator;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Simon on 27.04.2018.
 */

public class DatenHalter extends ArrayAdapter<String> {

    private static class ViewHolder {
        public TextView tvName;
    }


    public DatenHalter(@NonNull Context context, ArrayList<String> name){
        super(context, 0, name);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){

        final String sname = getItem(position);

        ViewHolder viewHolder;

        if(convertView == null){
            viewHolder = new ViewHolder();

            LayoutInflater inflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.activity_object, parent, false);
            viewHolder.tvName = (TextView)convertView.findViewById(R.id.et_name);
            convertView.setTag(viewHolder);
        }
        else{

            viewHolder = (ViewHolder)convertView.getTag();
        }

        viewHolder.tvName.setText(sname);


        return convertView;
    }


}
