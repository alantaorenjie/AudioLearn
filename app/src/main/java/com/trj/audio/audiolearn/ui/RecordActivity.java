package com.trj.audio.audiolearn.ui;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;

import com.tbruyelle.rxpermissions2.RxPermissions;
import com.trj.audio.audiolearn.R;

import butterknife.ButterKnife;
import butterknife.OnTouch;

/**
 * @author TRJ
 * @date 2018/12/26
 * Description:
 */
public class RecordActivity extends AppCompatActivity {


    public static final String TAG = "RecordActivity";


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);

        ButterKnife.bind(this);

        new RxPermissions(this).request(Manifest.permission.RECORD_AUDIO).subscribe();
    }


    @OnTouch(R.id.record_btn)
    boolean onTouchBtn(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.i(TAG, "down");
                break;
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:
                Log.i(TAG, "up");
                break;
        }
        return false;
    }


    public static Intent getCallingIntent(Context context) {
        return new Intent(context, RecordActivity.class);
    }
}
