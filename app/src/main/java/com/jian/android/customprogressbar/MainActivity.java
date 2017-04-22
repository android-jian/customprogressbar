package com.jian.android.customprogressbar;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private HorizontalProgressbar mProgressBar;

    private static final int MSG_UPDATE=1;

    private Handler mHandler=new Handler(){
        @Override
        public void handleMessage(Message msg) {

            int progress=mProgressBar.getProgress();
            mProgressBar.setProgress(++progress);

            if (progress>=100){
                mHandler.removeMessages(MSG_UPDATE);
            }
            mHandler.sendEmptyMessageDelayed(MSG_UPDATE,100);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mProgressBar= (HorizontalProgressbar) findViewById(R.id.custom_progress_bar);
        mHandler.sendEmptyMessage(MSG_UPDATE);
    }
}
