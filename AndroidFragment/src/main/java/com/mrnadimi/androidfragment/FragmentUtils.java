package com.mrnadimi.androidfragment;

import androidx.annotation.IdRes;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;

/**
 * Developer: Mohamad Nadimi
 * Company: Saghe
 * Website: https://www.mrnadimi.com
 * Created on 29 July 2021
 * <p>
 * Description: ...
 */
public class FragmentUtils {


    public static void replaceFragment(FragmentActivity fragmentActivity , LiteFragment fragment){
        replaceFragment(fragmentActivity , android.R.id.content , fragment , null);
    }


    public static void replaceFragment(FragmentActivity fragmentActivity , @IdRes int containerViewId , LiteFragment fragment , @Nullable String addToBackTag){
        FragmentTransaction transaction = fragmentActivity.getSupportFragmentManager().beginTransaction();
        transaction.replace(containerViewId, fragment);
        transaction.addToBackStack(addToBackTag);
        transaction.commit();
    }

    public static void hideFragment(FragmentActivity fragmentActivity , LiteFragment fragment ){
        FragmentTransaction transaction = fragmentActivity.getSupportFragmentManager().beginTransaction();
        transaction.hide( fragment);
        transaction.commit();
    }

    public static void showFragment(FragmentActivity fragmentActivity , LiteFragment fragment ){
        FragmentTransaction transaction = fragmentActivity.getSupportFragmentManager().beginTransaction();
        transaction.show( fragment);
        transaction.commit();
    }

    public static void addFragment(FragmentActivity fragmentActivity , LiteFragment fragment){
        addFragment(fragmentActivity , android.R.id.content , fragment , null);
    }


    public static void addFragment(FragmentActivity fragmentActivity , @IdRes int containerViewId , LiteFragment fragment , @Nullable String addToBackTag){
        FragmentTransaction transaction = fragmentActivity.getSupportFragmentManager().beginTransaction();
        transaction.add(containerViewId, fragment);
        transaction.addToBackStack(addToBackTag);
        transaction.commit();
    }

    public static void remove(FragmentActivity fragmentActivity , LiteFragment fragment){
        FragmentTransaction transaction = fragmentActivity.getSupportFragmentManager().beginTransaction();
        transaction.remove(fragment);
        transaction.commit();
    }



}
