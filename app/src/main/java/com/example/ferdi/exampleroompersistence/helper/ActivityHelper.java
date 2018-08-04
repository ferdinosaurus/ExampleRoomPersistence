package com.example.ferdi.exampleroompersistence.helper;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AlertDialog;

/**
 * Created by NEXSOFT on 03/05/2018.
 */

public class ActivityHelper {

    public final static void showActivity(final Activity activityFrom, final Class<?> activityTo,boolean activityFromFinish,String key, String putExtra) {
        Intent i = new Intent(activityFrom, activityTo);
        i.putExtra(key, putExtra);
        activityFrom.startActivity(i);
        activityFrom.overridePendingTransition(0, 0);
        if(activityFromFinish){
            activityFrom.finish();
        }

    }

    public final static void showActivity(final Activity activityFrom, final Class<?> activityTo,boolean activityFromFinish) {
        Intent i = new Intent(activityFrom, activityTo);
        activityFrom.startActivity(i);
        activityFrom.overridePendingTransition(0, 0);
        if(activityFromFinish){
            activityFrom.finish();
        }

    }

    public final static void showActivity(final Activity activityFrom, final Class<?> activityTo, final int animStart, final int animEnd,boolean activityFromFinish) {
        Intent i = new Intent(activityFrom, activityTo);
        activityFrom.startActivity(i);
        activityFrom.overridePendingTransition(animStart, animEnd);
        if(activityFromFinish){
            activityFrom.finish();
        }



    }

    public final static void callService(final Activity activityFrom, final Class<?> serviceClass) {
        Intent intent = new Intent(activityFrom,serviceClass);
        activityFrom.startService(intent);
    }


    public final static void showFragment(final FragmentActivity fragmentActivity, final Fragment fragmentTo) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                android.support.v4.app.FragmentTransaction fragmentTransaction;
                FragmentManager fragmentManager = fragmentActivity.getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                //TransactionFragment trans = new TransactionFragment();
//                fragmentTransaction.replace(R.id.fragment, fragmentTo);
//                fragmentTransaction.commit();
            }
        }, 200);
    }
}


