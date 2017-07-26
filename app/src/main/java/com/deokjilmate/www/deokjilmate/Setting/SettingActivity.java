package com.deokjilmate.www.deokjilmate.Setting;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.deokjilmate.www.deokjilmate.R;
import com.deokjilmate.www.deokjilmate.Setting.Break.BreakActivity;
import com.deokjilmate.www.deokjilmate.Setting.Inquiry.InquiryActivity;
import com.deokjilmate.www.deokjilmate.Setting.Notice.NoticeActivity;
import com.deokjilmate.www.deokjilmate.Setting.Terms.TermsActivity;

import java.util.ArrayList;

public class SettingActivity extends AppCompatActivity {


    ArrayList<SettingListItem> datas= new ArrayList<SettingListItem>();
    ListView listview;
    Button logoutBtn;
    Intent intent_inquiry;
    Intent intent_notice;
    Intent intent_terms;
    Intent intent_break;
    SharedPreferences.Editor editor;
    SharedPreferences logout;
    android.app.ActionBar actionBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);

        actionBar = getActionBar();
        setContentView(R.layout.setting_activity);
       // getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        //getActionBar().setCustomView(R.layout.main_topbar);
//        getActionBar().setIcon(R.drawable.main_topbar);

       // getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.main_topbar);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);

        actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.main_topbar));


//        // Custom Actionbar를 사용하기 위해 CustomEnabled을 true 시키고 필요 없는 것은 false 시킨다
//        actionBar.setDisplayShowCustomEnabled(true);
//        actionBar.setDisplayHomeAsUpEnabled(false);            //액션바 아이콘을 업 네비게이션 형태로 표시합니다.
//        actionBar.setDisplayShowTitleEnabled(false);        //액션바에 표시되는 제목의 표시유무를 설정합니다.
//        actionBar.setDisplayShowHomeEnabled(false);            //홈 아이콘을 숨김처리합니다.
//

        //layout을 가지고 와서 actionbar에 포팅을 시킵니다.
        LayoutInflater inflater = (LayoutInflater)getSystemService(LAYOUT_INFLATER_SERVICE);
        View actionbar = inflater.inflate(R.layout.main_topbar, null);

        actionBar.setCustomView(actionbar);

        //액션바 양쪽 공백 없애기
        Toolbar parent = (Toolbar)actionbar.getParent();
        parent.setContentInsetsAbsolute(0,0);



        datas.add( new SettingListItem("공지사항",R.drawable.setting_arrow));
        datas.add( new SettingListItem("문의하기",R.drawable.setting_arrow));
        datas.add( new SettingListItem("버전정보                                                1.0.0",R.drawable.setting_arrow));
        datas.add( new SettingListItem("약관 및 정책",R.drawable.setting_arrow));
        datas.add( new SettingListItem("탈퇴하기",R.drawable.setting_arrow));

        listview= (ListView)findViewById(R.id.basicListview);
        SettingAdapter adapter= new SettingAdapter( getLayoutInflater() , datas);
        logoutBtn = (Button)findViewById(R.id.setting_logout);
        listview.setAdapter(adapter);

        intent_inquiry = new Intent(this,InquiryActivity.class);
        intent_notice = new Intent(this,NoticeActivity.class);
        intent_terms = new Intent(this,TermsActivity.class);
        intent_break = new Intent(this,BreakActivity.class);

        // sharedpreferences 설정
        logout = getSharedPreferences("loginState",MODE_PRIVATE);
        editor = logout.edit();

        AdapterView.OnItemClickListener listener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                switch(position){
                    case 0:
                        startActivity(intent_notice);
                        break;
                    case 1:
                        startActivity(intent_inquiry);
                        break;
                    case 2:
                        notice();
                        break;
                    case 3:
                        startActivity(intent_terms);
                        break;
                    case 4:
                        startActivity(intent_break);
                        break;

                }
            }
        };
        listview.setOnItemClickListener(listener);


        // 로그아웃 버튼 눌렀을시
        Button.OnClickListener logoutClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor.putBoolean("loginState",false);
            }
        };
        logoutBtn.setOnClickListener(logoutClickListener);
    }

    public void notice(){
        Toast toast = Toast.makeText(this, "아직 개발 ㄴㄴ.", Toast.LENGTH_SHORT);
        toast.show();
    }
}
