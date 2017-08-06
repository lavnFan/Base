package com.ivanfanwu.base.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.ivanfanwu.base.R;
import com.ivanfanwu.base.ui.login.LoginActivity;
import com.ivanfanwu.base.util.LogUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";
    @BindView(R.id.hello_tv)
    TextView mTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.hello_tv)
    void goLogin(){
        LogUtil.i(TAG,"goLogin");
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}
