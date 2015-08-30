package com.doubleline.kwangzip.kwangzip;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.doubleline.kwangzip.kwangzip.model.TastyHouse;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by HyunWoo on 2015-08-30.
 */
public class RandomActivity extends FragmentActivity {

    ArrayList<TastyHouse> tastyHouses;
    TextView textView_name;
    ImageView imageView_image;
    Button button_select;
    Handler handler;
    TimerTask mTask;
    Timer mTimer;
    Boolean random = true;
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random);

        Intent intent = getIntent();
        tastyHouses = (ArrayList<TastyHouse>) intent.getSerializableExtra("TASTYHOUSE");

        setView();

        button_select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(button_select.getText().toString().equals("선택!!!")) {
                    random = false;
                    button_select.setText("메뉴 보러가기");
                } else {
                    Intent tastyHouseIntent = new Intent(getApplicationContext(), TastyHouseActivity.class);
                    tastyHouseIntent.putExtra("TASTYHOUSE", tastyHouses.get(i));
                    startActivity(tastyHouseIntent);
                }
            }
        });

        handler = new Handler();
        mTask = new TimerTask() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        if (random) {
                            if (i < 20) {
                                i++;
                            } else {
                                i = 0;
                            }
                            String fileName = "drawable/hi" + i;
                            int imageResource = getResources().getIdentifier(fileName, null, getPackageName());
                            Drawable image = getResources().getDrawable(imageResource);
                            imageView_image.setImageDrawable(image);
                            textView_name.setText(tastyHouses.get(i).getName());
                        }
                    }
                });
            }
        };

        mTimer = new Timer();
        mTimer.schedule(mTask, 0, 200);

    }

    void setView() {
        textView_name = (TextView) findViewById(R.id.random_name);
        imageView_image = (ImageView) findViewById(R.id.random_image);
        button_select = (Button) findViewById(R.id.random_select);
    }
}
