package com.trj.audio.audiolearn.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.trj.audio.audiolearn.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        startActivity(RecordActivity.getCallingIntent(this));
    }
}
