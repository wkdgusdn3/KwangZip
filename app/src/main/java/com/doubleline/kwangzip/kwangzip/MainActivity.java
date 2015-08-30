package com.doubleline.kwangzip.kwangzip;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.doubleline.kwangzip.kwangzip.model.TastyHouse;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptionsv
    GoogleMap gmap;
    ListView listView;
    TastyHouseListViewAdapter tastyHouseListViewAdapter;
    Button button_startRandom;
    ArrayList<TastyHouse> tastyHouses = new ArrayList<TastyHouse>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setView();
        setMap();
        addTastyHouse();

        button_startRandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), RandomActivity.class);
                intent.putExtra("TASTYHOUSE", tastyHouses);
                startActivity(intent);
            }
        });

        listView.setAdapter(tastyHouseListViewAdapter);
        setListViewHeightBasedOnChildren(listView);
    }

    void setView() {
        gmap = ((MapFragment) getFragmentManager().findFragmentById(R.id.main_map))
                .getMap();
        listView = (ListView)findViewById(R.id.main_listView);
        button_startRandom = (Button)findViewById(R.id.main_startRandom);
        tastyHouseListViewAdapter = new TastyHouseListViewAdapter(getApplicationContext());
    }

    private void setMap() {
        // CameraUpdateFactory is not initialized error를 고치기 위한 코드
        try {
            MapsInitializer.initialize(getApplicationContext());
        } catch (Exception e) {
            e.printStackTrace();
        }

        LatLng startingPoint = new LatLng(Double.parseDouble("37.620037"), Double.parseDouble("127.061137"));
        gmap.moveCamera(CameraUpdateFactory.newLatLngZoom(startingPoint, 16));
        gmap.setMyLocationEnabled(true);

    }

    private void addTastyHouse() {
        tastyHouseListViewAdapter.addTastyHouse(new TastyHouse("순서", "이름", "분류", "거리", "평점"));

        tastyHouses.add(new TastyHouse("1", "이삭 토스트", "분식", "279m", "127.0615741", "37.6202812", "4.3", "02-916-1546","08:00~20:00","서울특별시 노원구 월계동 429-6"));
        tastyHouses.add(new TastyHouse("2", "피자헤븐", "양식", "117m", "127.0585562", "37.6205737", "4.1","02-941-7675","10:00~23:00","서울특별시 노원구 월계동"));
        tastyHouses.add(new TastyHouse("3", "치킨 매니아", "분식", "280m", "127.0602785", "37.6236487", "3.8","02-943-9992","평일16:00~02:00","서울특별시 노원구 광운로 46 대동아파트상가 112,113호"));
        tastyHouses.add(new TastyHouse("4", "치킨 클럽", "분식", "485m", "127.0609375", "37.622986", "3.9","02-911-3141","18:00~24:00","서울특별시 노원구 월계동 379-2"));
        tastyHouses.add(new TastyHouse("5", "에뽕버거", "양식", "333m", "127.059542", "37.6226574", "4.2","02-917-9200","9:00~22:00","서울특별시 노원구 월계동 383-16"));
        tastyHouses.add(new TastyHouse("6", "만남곱창", "한식", "188m", "127.059479", "37.621233", "3.7"," ","17:00~3:00","서울특별시 노원구 광운로12길 5 "));
        tastyHouses.add(new TastyHouse("7", "치르치르", "양식", "424m", "127.0605389", "37.6231722", "4.5","02-915-5959","16:00~02:00","서울특별시 노원구 석계로18길 4"));
        tastyHouses.add(new TastyHouse("8", "홍천강매운탕", "한식", "674m", "127.06088", "37.622986", "4.6","02-943-4432","12:00~20:00","서울특별시 노원구 석계로1길 8"));
        tastyHouses.add(new TastyHouse("9", "더만나", "한식", "411m", "127.060726", "37.622938", "4.1","02-971-1100","11:30~23:30","서울특별시 노원구 석계로 103 동우빌딩"));
        tastyHouses.add(new TastyHouse("10", "하늘푸름", "양식", "285m", "127.061564", "37.620241", "3.9"," ","10:00~20:00","서울특별시 노원구 월계1동"));
        tastyHouses.add(new TastyHouse("11", "이층집", "한식", "93m", "127.05752", "37.61934", "5.0","02-941-3588","10:00~20:00","서울특별시 노원구 광운로 17-5"));
        tastyHouses.add(new TastyHouse("12", "오도리", "한식", "405m", "127.061033", "37.622693", "2.0","02-941-6238","10:00~20:00","서울특별시 노원구 월계1동"));
        tastyHouses.add(new TastyHouse("13", "알촌", "한식", "95m", "127.0585566", "37.6205704", "4.2","02-913-0415","09:00~21:00","서울특별시 노원구 광운로 33"));
        tastyHouses.add(new TastyHouse("14", "작은집", "분식", "264m", "127.061358", "37.620194", "4.0"," ","08:00~20:00","서울특별시 노원구 월계1동 429-5"));
        tastyHouses.add(new TastyHouse("15", "광인수집", "분식", "269m", "127.060966", "37.621051", "4.9"," ","10:00~20:00","서울특별시 노원구 월계1동 411-20"));
        tastyHouses.add(new TastyHouse("16", "안씨네쭈꾸미", "한식", "359km", "127.0585566", "37.6205704", "3.6","02-943-1171","12:00~01:00","서울특별시 노원구 월계동 410-3"));
        tastyHouses.add(new TastyHouse("17", "지지고", "분식", "39m", "127.0582129", "37.6200736", "3.9","02-943-2171","10:00~20:00","서울특별시 노원구 광운로 25"));
        tastyHouses.add(new TastyHouse("18", "토마토도시락", "한식", "115m", "127.0585566", "37.6205704", "3.8","02-942-5003","09:00~22:00","서울특별시 노원구 광운로 37"));
        tastyHouses.add(new TastyHouse("19", "빽다방", "카페", "161km", "127.058994", "37.621299", "4.2","070-7752-5322","09:00~20:00","서울특별시 노원구 월계동"));
        tastyHouses.add(new TastyHouse("20", "공차", "카페", "467m", "127.0615595", "37.6232526", "4.6","02-941-0325","09:00~21:30","서울특별시 노원구 석계로 98-2"));
        tastyHouses.add(new TastyHouse("21", "디아디아", "양식", "159km", "127.059033", "37.621183", "2.5"," ","09:00~20:00"," "));

        Bitmap markerImage =  BitmapFactory.decodeResource(getResources(), R.drawable.marker);
        markerImage = Bitmap.createScaledBitmap(markerImage, 100, 100, true);

        for(int i=0; i<tastyHouses.size(); i++) {
            tastyHouseListViewAdapter.addTastyHouse(tastyHouses.get(i));

            MarkerOptions markerOptions = new MarkerOptions();
            LatLng latLng = new LatLng(Double.parseDouble(tastyHouses.get(i).getLongitude()), Double.parseDouble(tastyHouses.get(i).getLatitude()));
            markerOptions.position(latLng);
            markerOptions.title(tastyHouses.get(i).getName());
            markerOptions.snippet(tastyHouses.get(i).getName());
            markerOptions.icon(BitmapDescriptorFactory.fromBitmap(markerImage));
            gmap.addMarker(markerOptions).showInfoWindow();
        }
    }

    public static void setListViewHeightBasedOnChildren(ListView listView) {
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null) {
            // pre-condition
            return;
        }

        int totalHeight = 0;
        int desiredWidth = View.MeasureSpec.makeMeasureSpec(listView.getWidth(), View.MeasureSpec.AT_MOST);

        for (int i = 0; i < listAdapter.getCount(); i++) {
            View listItem = listAdapter.getView(i, null, listView);
            listItem.measure(desiredWidth, View.MeasureSpec.UNSPECIFIED);
            totalHeight += listItem.getMeasuredHeight();
        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
        listView.requestLayout();
    }

}
