package com.doubleline.kwangzip.kwangzip;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.ArrayList;

public class ImageListViewAdapter extends BaseAdapter {
    ArrayList<Object> card;
    Context context;

    public ImageListViewAdapter(Context context) {
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

        ImageViewHolde imageViewHolder;

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_image, parent, false);

            imageViewHolder = new ImageViewHolde();
            imageViewHolder.imageView = (ImageView)convertView.findViewById(R.id.item_image);

            convertView.setTag(imageViewHolder);

        } else {
            imageViewHolder = (ImageViewHolde) convertView.getTag();
        }

        String fileName = "drawable/" + (String)card.get(position);


        int imageResource = context.getResources().getIdentifier(fileName, null, context.getPackageName());
        Drawable image = context.getResources().getDrawable(imageResource);
        imageViewHolder.imageView.setImageDrawable(image);

        return convertView;
    }

    void addImageView(String fileName) {
        card.add(fileName);
    }

    class ImageViewHolde {
        ImageView imageView;
    }
}