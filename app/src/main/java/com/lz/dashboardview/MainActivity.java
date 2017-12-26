package com.lz.dashboardview;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private DashboardView dashboardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dashboardView = findViewById(R.id.dashboardView);
        initData();
    }

    private void initData(){

        new Thread(){
            @Override
            public void run() {
                for (int i = 0; i <101 ; i++) {
                    try{
                        sleep(50);
                    }catch (Exception e){

                    }
                    mHandler.obtainMessage(0,i,0).sendToTarget();
                }
            }
        }.start();
    }

    private Handler mHandler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            int num=msg.arg1;
            dashboardView.setPercent(num);
        }
    };

}
