package com.promise.gadsbooks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Thread splashScreenStarter = new Thread() {
            public void run() {
                int i = 0;
                try {
                    int waitingTime = 0;
                    while (waitingTime < 1500) {
                        sleep(150);
                        waitingTime = waitingTime + 100;

                    }
                    Intent intent = new Intent(MainActivity.this, AuthActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);

                } catch (InterruptedException e) {
                    e.printStackTrace();

                } finally {
                    finish();

                }
            }

        };
        splashScreenStarter.start();
    }
}