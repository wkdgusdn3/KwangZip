package com.doubleline.kwangzip.kwangzip;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.doubleline.kwangzip.kwangzip.model.TastyHouse;

import java.util.ArrayList;

public class TastyHouseListViewAdapter extends BaseAdapter {
    ArrayList<Object> card;
    Context context;

    public TastyHouseListViewAdapter(Context context) {
        this.context = context;

        card = new ArrayList<Object>();
    }

    @Override
    public int getCount() {
        return card.size();
    }

    @Override
    public Object getItem(int position) {
        return card.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        TastyHouseHolder tastyHouseHolder;

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_tastyhouse, parent, false);

            tastyHouseHolder = new TastyHouseHolder();
            tastyHouseHolder.layout = (RelativeLayout) convertView.findViewById(R.id.item_tastyHouse_layout);
            tastyHouseHolder.number = (TextView) convertView.findViewById(R.id.item_tastyHouse_number);
            tastyHouseHolder.name = (TextView) convertView.findViewById(R.id.item_tastyHouse_name);
            tastyHouseHolder.category = (TextView) convertView.findViewById(R.id.item_tastyHouse_category);
            tastyHouseHolder.distance = (TextView) convertView.findViewById(R.id.item_tastyHouse_distance);
            tastyHouseHolder.grade = (ImageView) convertView.findViewById(R.id.item_tastyHouse_grade);
            tastyHouseHolder.gradeTv = (TextView) convertView.findViewById(R.id.item_tastyHouse_gradeTv);

            convertView.setTag(tastyHouseHolder);

        } else {
            tastyHouseHolder = (TastyHouseHolder) convertView.getTag();
        }

        final TastyHouse tastyHouse = (TastyHouse) card.get(position);
        tastyHouseHolder.number.setText(tastyHouse.getNumber());
        tastyHouseHolder.name.setText(tastyHouse.getName());
        tastyHouseHolder.category.setText(tastyHouse.getCategory());
        tastyHouseHolder.distance.setText(tastyHouse.getDistance());

        try {
            if (Double.parseDouble(tastyHouse.getGrade()) == 0) {
                tastyHouseHolder.grade.setBackgroundResource(R.drawable.grade1);
            } else if (Double.parseDouble(tastyHouse.getGrade()) < 0.5) {
                tastyHouseHolder.grade.setBackgroundResource(R.drawable.grade1);
            } else if (Double.parseDouble(tastyHouse.getGrade()) < 1.0) {
                tastyHouseHolder.grade.setBackgroundResource(R.drawable.grade2);
            } else if (Double.parseDouble(tastyHouse.getGrade()) < 1.5) {
                tastyHouseHolder.grade.setBackgroundResource(R.drawable.grade3);
            } else if (Double.parseDouble(tastyHouse.getGrade()) < 2.0) {
                tastyHouseHolder.grade.setBackgroundResource(R.drawable.grade4);
            } else if (Double.parseDouble(tastyHouse.getGrade()) < 2.5) {
                tastyHouseHolder.grade.setBackgroundResource(R.drawable.grade5);
            } else if (Double.parseDouble(tastyHouse.getGrade()) < 3.0) {
                tastyHouseHolder.grade.setBackgroundResource(R.drawable.grade6);
            } else if (Double.parseDouble(tastyHouse.getGrade()) < 3.5) {
                tastyHouseHolder.grade.setBackgroundResource(R.drawable.grade7);
            } else if (Double.parseDouble(tastyHouse.getGrade()) < 4.0) {
                tastyHouseHolder.grade.setBackgroundResource(R.drawable.grade8);
            } else if (Double.parseDouble(tastyHouse.getGrade()) < 4.5) {
                tastyHouseHolder.grade.setBackgroundResource(R.drawable.grade9);
            } else {
                tastyHouseHolder.grade.setBackgroundResource(R.drawable.grade10);
            }
        } catch (Exception e) {
            tastyHouseHolder.gradeTv.setVisibility(View.VISIBLE);
        }

        tastyHouseHolder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, TastyHouseActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("TASTYHOUSE", tastyHouse);
                context.startActivity(intent);
            }
        });

        return convertView;
    }

    void addTastyHouse(TastyHouse tastyHouse) {
        card.add(tastyHouse);
    }

    class TastyHouseHolder {
        RelativeLayout layout;
        TextView number;
        TextView name;
        TextView category;
        TextView distance;
        ImageView grade;
        TextView gradeTv;
    }
}