package com.doubleline.kwangzip.kwangzip;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.doubleline.kwangzip.kwangzip.model.Menu;

import java.util.ArrayList;

public class MenuListViewAdapter extends BaseAdapter {
    ArrayList<Object> card;
    Context context;

    public MenuListViewAdapter(Context context) {
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

        MenuHolder menuHolder;

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_menu, parent, false);

            menuHolder = new MenuHolder();
            menuHolder.number = (TextView) convertView.findViewById(R.id.item_menu_number);
            menuHolder.name = (TextView) convertView.findViewById(R.id.item_menu_name);
            menuHolder.price = (TextView) convertView.findViewById(R.id.item_menu_price);

            convertView.setTag(menuHolder);

        } else {
            menuHolder = (MenuHolder) convertView.getTag();
        }

        final Menu menu = (Menu) card.get(position);
        menuHolder.number.setText(menu.getNumber());
        menuHolder.name.setText(menu.getName());
        menuHolder.price.setText(menu.getPrice() + "원");

        return convertView;
    }

    void addMenu(Menu menu) {
        card.add(menu);
    }

    class MenuHolder {
        TextView number;
        TextView name;
        TextView price;
    }
}