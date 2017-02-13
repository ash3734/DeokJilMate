package com.deokjilmate.www.deokjilmate.Login;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.deokjilmate.www.deokjilmate.R;

import java.util.ArrayList;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SetSingerActivity extends AppCompatActivity {

    @BindView(R.id.SetSinger_topImage)
    ImageView toobarImage;

    @BindView(R.id.SetSinger_search)
    EditText search;

    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    RequestManager requestManager;
    ArrayList<SetSingerItemData> setSingerItemDatas;//추천목록
    ArrayList<SetSingerItemData> allSingerList;//전체목록
    SetSingerAdapter setSingerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_singer);
        ButterKnife.bind(this);

        Glide.with(this).load(R.drawable.toolbar).into(toobarImage);

        requestManager = Glide.with(this);


        setSingerItemDatas = new ArrayList<SetSingerItemData>();
        allSingerList = new ArrayList<SetSingerItemData>();
        setSingerItemDatas.add(new SetSingerItemData(R.drawable.meta, "aaaa", R.drawable.meta));
        setSingerItemDatas.add(new SetSingerItemData(R.drawable.meta, "bbbb", R.drawable.meta));

        recyclerView = (RecyclerView) findViewById(R.id.SetSinger_list);
        recyclerView.setHasFixedSize(true);
        //recyclerView.get
        linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayout.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        setSingerAdapter = new SetSingerAdapter(requestManager, setSingerItemDatas, allSingerList);
        recyclerView.setAdapter(setSingerAdapter);
    }

    @OnClick(R.id.SetSinger_search)
    public void Search()
    {
        search.addTextChangedListener(new TextWatcher()
        {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String text = search.getText().toString().toLowerCase(Locale.getDefault());
                if(text.length() == 0) {
                }
                setSingerAdapter.filter(text);
            }
            public void afterTextChanged(Editable s) {
            }
        });
    }
}