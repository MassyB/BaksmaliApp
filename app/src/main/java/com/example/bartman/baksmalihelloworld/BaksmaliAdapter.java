package com.example.bartman.baksmalihelloworld;

import org.jf.baksmali.main;

import java.io.IOException;

/**
 * Created by bartman on 13/03/17.
 */

public class BaksmaliAdapter {

    public static void doBaksmali(String apkPath, String outputPath){

        try {

            main.main(new String[]{
                    "-o",
                    outputPath,
                    apkPath
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
