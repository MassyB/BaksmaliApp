package com.example.bartman.baksmalihelloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //chose anyother application location
        String apkPath= "/data/app/com.example.bartman.helloworldapp-1.apk";

        //the output directory for baksmali
        String baksmaliOutputPath = getDir("baksmali_output",MODE_PRIVATE).getAbsolutePath();

        BaksmaliAdapter.doBaksmali(apkPath,baksmaliOutputPath);
    }
}
