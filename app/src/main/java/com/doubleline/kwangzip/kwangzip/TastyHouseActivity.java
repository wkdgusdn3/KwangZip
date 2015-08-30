package com.doubleline.kwangzip.kwangzip;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.doubleline.kwangzip.kwangzip.model.Menu;
import com.doubleline.kwangzip.kwangzip.model.TastyHouse;

public class TastyHouseActivity extends AppCompatActivity {

    TextView textView_name;
    TextView textView_operationTime;
    TextView textView_phoneNumber;
    TextView textView_category;
    ImageView imageView;
    TastyHouse tastyHouse;
    ImageView imageView_grade;
    ListView listView;
    MenuListViewAdapter menuListViewAdapter;
    ListView imageListView;
    ImageListViewAdapter imageListViewAdapter;
    TextView textView_location;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tastyhouse);

        setView();

        Intent intent = getIntent();
        tastyHouse = (TastyHouse) intent.getSerializableExtra("TASTYHOUSE");

        textView_name.setText(tastyHouse.getName());
        textView_category.setText(tastyHouse.getCategory());
        textView_phoneNumber.setText(tastyHouse.getPhoneNumber());
        textView_operationTime.setText(tastyHouse.getOperationTime());
        textView_location.setText(tastyHouse.getLocation());

        setGrade();
        setMenu();
        setImage();

        String uri = "drawable/hi" + (Integer.parseInt(tastyHouse.getNumber()) - 1);
        int imageResource = getResources().getIdentifier(uri, null, getPackageName());
        Drawable image = getResources().getDrawable(imageResource);
        imageView.setImageDrawable(image);

        listView.setAdapter(menuListViewAdapter);
        MainActivity.setListViewHeightBasedOnChildren(listView);

        imageListView.setAdapter(imageListViewAdapter);
        MainActivity.setListViewHeightBasedOnChildren(imageListView);
    }

    void setView() {
        textView_name = (TextView) findViewById(R.id.textView3);
        textView_operationTime = (TextView) findViewById(R.id.textView5);
        textView_phoneNumber = (TextView) findViewById(R.id.textView6);
        textView_category = (TextView) findViewById(R.id.textView8);
        imageView = (ImageView) findViewById(R.id.imageView);
        imageView_grade = (ImageView) findViewById(R.id.gradeImage);
        listView = (ListView) findViewById(R.id.tastyHouse_listView);
        menuListViewAdapter = new MenuListViewAdapter(getApplicationContext());
        imageListView = (ListView) findViewById(R.id.tastyHouse_imageListView);
        imageListViewAdapter = new ImageListViewAdapter(getApplicationContext());
        textView_location = (TextView) findViewById(R.id.location);
    }

    void setGrade() {
        if (Double.parseDouble(tastyHouse.getGrade()) == 0) {
            imageView_grade.setBackgroundResource(R.drawable.grade1);
        } else if (Double.parseDouble(tastyHouse.getGrade()) < 0.5) {
            imageView_grade.setBackgroundResource(R.drawable.grade1);
        } else if (Double.parseDouble(tastyHouse.getGrade()) < 1.0) {
            imageView_grade.setBackgroundResource(R.drawable.grade2);
        } else if (Double.parseDouble(tastyHouse.getGrade()) < 1.5) {
            imageView_grade.setBackgroundResource(R.drawable.grade3);
        } else if (Double.parseDouble(tastyHouse.getGrade()) < 2.0) {
            imageView_grade.setBackgroundResource(R.drawable.grade4);
        } else if (Double.parseDouble(tastyHouse.getGrade()) < 2.5) {
            imageView_grade.setBackgroundResource(R.drawable.grade5);
        } else if (Double.parseDouble(tastyHouse.getGrade()) < 3.0) {
            imageView_grade.setBackgroundResource(R.drawable.grade6);
        } else if (Double.parseDouble(tastyHouse.getGrade()) < 3.5) {
            imageView_grade.setBackgroundResource(R.drawable.grade7);
        } else if (Double.parseDouble(tastyHouse.getGrade()) < 4.0) {
            imageView_grade.setBackgroundResource(R.drawable.grade8);
        } else if (Double.parseDouble(tastyHouse.getGrade()) < 4.5) {
            imageView_grade.setBackgroundResource(R.drawable.grade9);
        } else {
            imageView_grade.setBackgroundResource(R.drawable.grade10);
        }
    }

    void setMenu() {
        switch (tastyHouse.getNumber()) {
            case "1":
                menuListViewAdapter.addMenu(new Menu("1", "치즈토스트", "2000"));
                menuListViewAdapter.addMenu(new Menu("2", "감자 MVP", "3000"));
                menuListViewAdapter.addMenu(new Menu("3", "계란토스트", "1500"));
                menuListViewAdapter.addMenu(new Menu("4", "핫치킨MVP", "3200"));
                menuListViewAdapter.addMenu(new Menu("5", "새우버거 토스트", "2400"));
                menuListViewAdapter.addMenu(new Menu("6", "불갈비 토스트", "2800"));
                menuListViewAdapter.addMenu(new Menu("7", "핫치킨 토스트", "2600"));
                menuListViewAdapter.addMenu(new Menu("8", "딸기 쥬스", "2500"));
                break;
            case "2":
                menuListViewAdapter.addMenu(new Menu("1", "헤븐스폐셜피자 M", "24500"));
                menuListViewAdapter.addMenu(new Menu("2", "슈퍼슈프림피자 M", "15200"));
                menuListViewAdapter.addMenu(new Menu("3", "불고기 피자 M", "14500"));
                menuListViewAdapter.addMenu(new Menu("4", "포테이토 피자 M", "14500"));
                menuListViewAdapter.addMenu(new Menu("5", "더블치즈베이컨 피자 M", "16900"));
                menuListViewAdapter.addMenu(new Menu("6", "쿼터드레싱포테이토피자 L", "18900"));
                menuListViewAdapter.addMenu(new Menu("7", "핫앤스파이시 피자 M", "14500"));
                break;
            case "3":
                menuListViewAdapter.addMenu(new Menu("1", "새우치킨", "17000"));
                menuListViewAdapter.addMenu(new Menu("2", "양념치킨", "16000"));
                menuListViewAdapter.addMenu(new Menu("3", "마늘치킨", "16000"));
                menuListViewAdapter.addMenu(new Menu("4", "간장치킨", "17000"));
                menuListViewAdapter.addMenu(new Menu("5", "델리순살치킨", "17000"));
                menuListViewAdapter.addMenu(new Menu("7", "로스트핫바비큐", "16000"));
                menuListViewAdapter.addMenu(new Menu("7", "매니아 순살파닭", "17000"));
                break;
            case "4":
                menuListViewAdapter.addMenu(new Menu("1", "후라이드", "15000"));
                menuListViewAdapter.addMenu(new Menu("2", "양념치킨", "16000"));
                menuListViewAdapter.addMenu(new Menu("3", "마늘치킨", "17000"));
                menuListViewAdapter.addMenu(new Menu("4", "파닭", "17000"));
                break;
            case "5":
                menuListViewAdapter.addMenu(new Menu("1", "순살버거set", "5600"));
                menuListViewAdapter.addMenu(new Menu("2", "고구마순살버거set", "6000"));
                menuListViewAdapter.addMenu(new Menu("3", "갈릭순살버거set", "6200"));
                menuListViewAdapter.addMenu(new Menu("4", "칠리치즈순살버거set", "6400"));
                menuListViewAdapter.addMenu(new Menu("5", "바비큐버거set", "6200"));
                menuListViewAdapter.addMenu(new Menu("6", "불고기치즈버거set", "6400"));
                menuListViewAdapter.addMenu(new Menu("7", "새우버거set", "5700"));
                menuListViewAdapter.addMenu(new Menu("8", "피쉬버거set", "5000"));
                break;
            case "6":
                menuListViewAdapter.addMenu(new Menu("1", "야채곱창", "9000"));
                menuListViewAdapter.addMenu(new Menu("2", "막창구이", "10000"));
                menuListViewAdapter.addMenu(new Menu("3", "막창양념", "10000"));
                menuListViewAdapter.addMenu(new Menu("4", "곱창구이", "10000"));
                menuListViewAdapter.addMenu(new Menu("5", "신막창양념", "19000"));
                menuListViewAdapter.addMenu(new Menu("6", "볶음밥", "2000"));
                menuListViewAdapter.addMenu(new Menu("7", "소주", "4000"));
                break;
            case "7":
                menuListViewAdapter.addMenu(new Menu("1", "크리스피후라이드", "17000"));
                menuListViewAdapter.addMenu(new Menu("2", "크리스피양념", "18000"));
                menuListViewAdapter.addMenu(new Menu("3", "크리스피간장", "18000"));
                menuListViewAdapter.addMenu(new Menu("4", "스윗허니치킨", "18000"));
                menuListViewAdapter.addMenu(new Menu("5", "치르치르 미치르", "18900"));
                menuListViewAdapter.addMenu(new Menu("6", "둥지스노우치킨", "18900"));
                menuListViewAdapter.addMenu(new Menu("7", "둥지철파닭", "17900"));
                menuListViewAdapter.addMenu(new Menu("8", "치즈볼", "4500"));
                break;
            case "8":
                menuListViewAdapter.addMenu(new Menu("1", "빠가사리", "17000"));
                menuListViewAdapter.addMenu(new Menu("2", "메기", "50000"));
                menuListViewAdapter.addMenu(new Menu("3", "잡고기", "40000"));
                menuListViewAdapter.addMenu(new Menu("4", "다슬기전골", "35000"));
                menuListViewAdapter.addMenu(new Menu("5", "다슬기해장국", "6000"));
                menuListViewAdapter.addMenu(new Menu("6", "추어튀김", "15000"));
                menuListViewAdapter.addMenu(new Menu("7", "장어구이2마리", "50000"));
                break;
            case "9":
                menuListViewAdapter.addMenu(new Menu("1", "더만나정식", "8000"));
                menuListViewAdapter.addMenu(new Menu("2", "물냉/비냉", "6000"));
                menuListViewAdapter.addMenu(new Menu("3", "갈비탕 정식", "8000"));
                menuListViewAdapter.addMenu(new Menu("4", "전골불고기", "13000"));
                menuListViewAdapter.addMenu(new Menu("5", "소고기 진갈비", "19000"));
                menuListViewAdapter.addMenu(new Menu("6", "대잎갈비", "15000"));
                menuListViewAdapter.addMenu(new Menu("7", "포장 떡갈비", "3000"));
                break;
            case "10":
                menuListViewAdapter.addMenu(new Menu("1", "왕돈까스/카레돈가스", "5000"));
                menuListViewAdapter.addMenu(new Menu("2", "치즈돈가스", "6000"));
                menuListViewAdapter.addMenu(new Menu("3", "파돈가스", "5000"));
                menuListViewAdapter.addMenu(new Menu("4", "제육덮밥", "6000"));
                menuListViewAdapter.addMenu(new Menu("5", "순두부찌개", "5000"));
                menuListViewAdapter.addMenu(new Menu("6", "미니돈까스", "4500"));
                menuListViewAdapter.addMenu(new Menu("7", "오삼덮밥", "4000"));
                menuListViewAdapter.addMenu(new Menu("8", "피자돈까스", "6000"));
                break;
            case "11":
                menuListViewAdapter.addMenu(new Menu("1", "부대찌개/김치찌개 소", "13000"));
                menuListViewAdapter.addMenu(new Menu("2", "부대찌개/김치찌개 중", "18000"));
                menuListViewAdapter.addMenu(new Menu("3", "부대찌개/김치찌개 대", "23000"));
                menuListViewAdapter.addMenu(new Menu("4", "라면사리", "1000"));
                break;
            case "12":
                menuListViewAdapter.addMenu(new Menu("1", "몇몇 메뉴 점심 한정", ""));
                menuListViewAdapter.addMenu(new Menu("2", "김치찌개", "5000"));
                menuListViewAdapter.addMenu(new Menu("3", "된장찌개", "5000"));
                menuListViewAdapter.addMenu(new Menu("4", "김치제육", "6000"));
                menuListViewAdapter.addMenu(new Menu("5", "두부김치", "10000"));
                menuListViewAdapter.addMenu(new Menu("6", "오징어볶음", "6000"));
                menuListViewAdapter.addMenu(new Menu("7", "해물파전", "10000"));
                menuListViewAdapter.addMenu(new Menu("7", "청국장", "6000"));
                break;
            case "13":
                menuListViewAdapter.addMenu(new Menu("1", "알밥 순한", "3500"));
                menuListViewAdapter.addMenu(new Menu("2", "알밥 약매", "3900"));
                menuListViewAdapter.addMenu(new Menu("3", "알밥 매운", "3900"));
                menuListViewAdapter.addMenu(new Menu("4", "알밥 진매", "4000"));
                menuListViewAdapter.addMenu(new Menu("5", "카레/짜장알밥", "4000"));
                menuListViewAdapter.addMenu(new Menu("6", "오밥", "4000"));
                menuListViewAdapter.addMenu(new Menu("7", "치즈추가", "500"));
                break;
            case "14":
                menuListViewAdapter.addMenu(new Menu("1", "닭칼국수", "4000"));
                menuListViewAdapter.addMenu(new Menu("2", "순두부찌개", "4000"));
                menuListViewAdapter.addMenu(new Menu("3", "치즈라볶이", "3500"));
                menuListViewAdapter.addMenu(new Menu("4", "참치찌개", "4000"));
                menuListViewAdapter.addMenu(new Menu("5", "우동", "3500"));
                menuListViewAdapter.addMenu(new Menu("6", "오삼덮밥", "4000"));
                break;
            case "15":
                menuListViewAdapter.addMenu(new Menu("1", "계이득", "2000"));
                menuListViewAdapter.addMenu(new Menu("2", "계치득", "2500"));
                break;
            case "16":
                menuListViewAdapter.addMenu(new Menu("1", "주꾸미 볶음", "10000"));
                menuListViewAdapter.addMenu(new Menu("2", "주꾸미 삼겹", "12000"));
                menuListViewAdapter.addMenu(new Menu("3", "치즈 주꾸미", "12000"));
                menuListViewAdapter.addMenu(new Menu("4", "매운닭발", "15000"));
                menuListViewAdapter.addMenu(new Menu("5", "삼겹살", "8000"));
                menuListViewAdapter.addMenu(new Menu("6", "대하", "12000"));
                menuListViewAdapter.addMenu(new Menu("7", "가이바시", "15000"));
                break;
            case "17":
                menuListViewAdapter.addMenu(new Menu("1", "순한맛 라이스", "3000"));
                menuListViewAdapter.addMenu(new Menu("2", "순한맛 누들", "3000"));
                menuListViewAdapter.addMenu(new Menu("3", "매운맛 라이스", "3000"));
                menuListViewAdapter.addMenu(new Menu("4", "매운맛 누들", "3000"));
                break;
            case "18":
                menuListViewAdapter.addMenu(new Menu("1", "데리와퍼 치킨/참치", "3500"));
                menuListViewAdapter.addMenu(new Menu("2", " 돈치/돈돈와퍼", "4200"));
                menuListViewAdapter.addMenu(new Menu("3", "돈불와퍼", "3600"));
                menuListViewAdapter.addMenu(new Menu("4", "치킨/돈까스 마요", "2700"));
                menuListViewAdapter.addMenu(new Menu("5", "야채참치 비빔밥", "3000"));
                menuListViewAdapter.addMenu(new Menu("6", "버섯불고기", "3500"));
                menuListViewAdapter.addMenu(new Menu("7", "치킨마요", "2700"));
                menuListViewAdapter.addMenu(new Menu("8", "포테이토마요", "2700"));
                break;
            case "19":
                menuListViewAdapter.addMenu(new Menu("1", "사라다빵", "2000"));
                menuListViewAdapter.addMenu(new Menu("2", "앗! 메리카노", "2000"));
                menuListViewAdapter.addMenu(new Menu("3", "원조 냉커피", "2500"));
                menuListViewAdapter.addMenu(new Menu("4", "빽's라떼", "2500"));
                menuListViewAdapter.addMenu(new Menu("5", "카라멜마끼아또", "3000"));
                menuListViewAdapter.addMenu(new Menu("6", "얼음추가로 아이스시", "500"));
                break;
            case "20":
                menuListViewAdapter.addMenu(new Menu("1", "타로밀크티 라지/점보", "3800/4900"));
                menuListViewAdapter.addMenu(new Menu("2", "허니 밀크티", "3900/5200"));
                menuListViewAdapter.addMenu(new Menu("3", "초콜렛 밀크티", "3900/5200"));
                menuListViewAdapter.addMenu(new Menu("4", "타로스무디", "4300"));
                menuListViewAdapter.addMenu(new Menu("5", "블랙밀크티w펄", "3900"));
                menuListViewAdapter.addMenu(new Menu("6", "초코 쿠앤크 스무디", "4500"));
                menuListViewAdapter.addMenu(new Menu("7", "타로슈슈", "4500"));
                menuListViewAdapter.addMenu(new Menu("8", "초코슈슈", "4500"));
                break;
            case "21":
                menuListViewAdapter.addMenu(new Menu("1", "불고기 브리또", "3500"));
                menuListViewAdapter.addMenu(new Menu("2", "치킨 브리또", "3500"));
                menuListViewAdapter.addMenu(new Menu("3", "믹스 브리또", "3500"));
                menuListViewAdapter.addMenu(new Menu("4", "왕소세지 브리또", "3500"));
                menuListViewAdapter.addMenu(new Menu("5", "돈까스 브리또", "3500"));
                menuListViewAdapter.addMenu(new Menu("6", "다이어트 브리또", "4000"));
                menuListViewAdapter.addMenu(new Menu("7", "감자튀김", "2000"));
                menuListViewAdapter.addMenu(new Menu("8", "음료추가", "500"));
                break;
        }
    }

    void setImage() {
        switch (tastyHouse.getNumber()) {
            case "1":
                imageListViewAdapter.addImageView("image1_0");
                imageListViewAdapter.addImageView("image1_1");
                imageListViewAdapter.addImageView("image1_2");
                break;
            case "2":
                imageListViewAdapter.addImageView("image2_0");
                imageListViewAdapter.addImageView("image2_1");
                imageListViewAdapter.addImageView("image2_2");
                break;
            case "3":
                imageListViewAdapter.addImageView("image3_0");
                imageListViewAdapter.addImageView("image3_1");
                imageListViewAdapter.addImageView("image3_2");
                break;
            case "4":
                imageListViewAdapter.addImageView("image4_0");
                imageListViewAdapter.addImageView("image4_1");
                imageListViewAdapter.addImageView("image4_2");
                break;
            case "5":
                imageListViewAdapter.addImageView("image5_0");
                imageListViewAdapter.addImageView("image5_1");
                imageListViewAdapter.addImageView("image5_2");
                break;
            case "6":
                imageListViewAdapter.addImageView("image6_0");
                imageListViewAdapter.addImageView("image6_1");
                imageListViewAdapter.addImageView("image6_2");
                break;
            case "7":
                imageListViewAdapter.addImageView("image7_0");
                imageListViewAdapter.addImageView("image7_1");
                imageListViewAdapter.addImageView("image7_2");
                break;
            case "8":
                imageListViewAdapter.addImageView("image8_0");
                imageListViewAdapter.addImageView("image8_1");
                imageListViewAdapter.addImageView("image8_2");
                break;
            case "9":
                imageListViewAdapter.addImageView("image9_0");
                imageListViewAdapter.addImageView("image9_1");
                imageListViewAdapter.addImageView("image9_2");
                break;
            case "10":
                imageListViewAdapter.addImageView("image10_0");
                imageListViewAdapter.addImageView("image10_1");
                imageListViewAdapter.addImageView("image10_2");
                break;
            case "11":
                imageListViewAdapter.addImageView("image11_0");
                imageListViewAdapter.addImageView("image11_1");
                imageListViewAdapter.addImageView("image11_2");
                break;
            case "12":
                imageListViewAdapter.addImageView("image12_0");
                imageListViewAdapter.addImageView("image12_1");
                imageListViewAdapter.addImageView("image12_2");
                break;
            case "13":
                imageListViewAdapter.addImageView("image13_0");
                imageListViewAdapter.addImageView("image13_1");
                imageListViewAdapter.addImageView("image13_2");
                break;
            case "14":
                imageListViewAdapter.addImageView("image14_0");
                imageListViewAdapter.addImageView("image14_1");
                imageListViewAdapter.addImageView("image14_2");
                break;
            case "15":
                imageListViewAdapter.addImageView("image15_0");
                imageListViewAdapter.addImageView("image15_1");
                imageListViewAdapter.addImageView("image15_2");
                break;
            case "16":
                imageListViewAdapter.addImageView("image16_0");
                imageListViewAdapter.addImageView("image16_1");
                imageListViewAdapter.addImageView("image16_2");
                break;
            case "17":
                imageListViewAdapter.addImageView("image17_0");
                imageListViewAdapter.addImageView("image17_1");
                imageListViewAdapter.addImageView("image17_2");
                break;
            case "18":
                imageListViewAdapter.addImageView("image18_0");
                imageListViewAdapter.addImageView("image18_1");
                imageListViewAdapter.addImageView("image18_2");
                break;
            case "19":
                imageListViewAdapter.addImageView("image19_0");
                imageListViewAdapter.addImageView("image19_1");
                imageListViewAdapter.addImageView("image19_2");
                break;
            case "20":
                imageListViewAdapter.addImageView("image20_0");
                imageListViewAdapter.addImageView("image20_1");
                imageListViewAdapter.addImageView("image20_2");
                break;
            case "21":
                imageListViewAdapter.addImageView("image21_0");
                imageListViewAdapter.addImageView("image21_1");
                imageListViewAdapter.addImageView("image21_2");
                break;

        }
    }
}
