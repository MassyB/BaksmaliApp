package com.example.bartman.baksmalihelloworld;

import android.util.Log;

import org.jf.baksmali.main;
import org.jf.dexlib2.DexFileFactory;

import java.io.File;
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
        catch (DexFileFactory.DexFileNotFound dexFileNotFound){
            Log.i("odex call",apkPath);
            doBaksmali(getOdexPath(apkPath),outputPath);


        }

    }
    static String getOdexPath(String apkPath){
        String odexPath = apkPath.substring(0,apkPath.length()-3).concat("odex");

        boolean fileExists =  new File(odexPath).isFile();
        if (fileExists){
            return odexPath;
        }
        else {
            String dir = new File(odexPath).getParent();
            String filename = new File(odexPath).getName();
            String odexOATPath;
            odexOATPath = dir.concat("/oat/x86/"+filename);
            Log.i("paths-filename",filename);
            return odexOATPath;
        }
    }
}


