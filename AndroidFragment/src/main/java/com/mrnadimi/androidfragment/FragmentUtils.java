package com.mrnadimi.androidfragment;

import android.os.Bundle;

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
        replaceFragment(fragmentActivity , android.R.id.content , fragment );
    }

    public static <T extends LiteFragment> void replaceFragment(FragmentActivity fragmentActivity , Class<T> fragmentClass){
        replaceFragment(fragmentActivity , android.R.id.content , fragmentClass );
    }


    public static void replaceFragment(FragmentActivity fragmentActivity , @IdRes int containerViewId , LiteFragment fragment){
        replaceFragment(fragmentActivity , containerViewId , fragment , null);
    }

    public static <T extends LiteFragment> void replaceFragment(FragmentActivity fragmentActivity , @IdRes int containerViewId ,  Class<T> fragmentClass){
        replaceFragment(fragmentActivity , containerViewId , fragmentClass , null);
    }

    public static void replaceFragment(FragmentActivity fragmentActivity , @IdRes int containerViewId , LiteFragment fragment , @Nullable String addToBackTag){
        replaceFragment(fragmentActivity , containerViewId , fragment , addToBackTag , null);
    }

    public static <T extends LiteFragment>  void replaceFragment(FragmentActivity fragmentActivity , @IdRes int containerViewId , Class<T> fragmentClass , @Nullable String addToBackTag){
        replaceFragment(fragmentActivity , containerViewId , fragmentClass , addToBackTag , null);
    }

    public static void replaceFragment(FragmentActivity fragmentActivity , @IdRes int containerViewId , LiteFragment fragment
            , @Nullable String addToBackTag , @Nullable String fragmentTag){
        FragmentTransaction transaction = fragmentActivity.getSupportFragmentManager().beginTransaction();
        transaction.replace(containerViewId, fragment , fragmentTag);
        transaction.addToBackStack(addToBackTag);
        transaction.commit();
    }

    public static <T extends LiteFragment>   void replaceFragment(FragmentActivity fragmentActivity , @IdRes int containerViewId , Class<T> fragmentClass
            , @Nullable String addToBackTag , @Nullable String fragmentTag){
        replaceFragment(fragmentActivity , containerViewId , fragmentClass , addToBackTag , fragmentTag , null);
    }

    public static <T extends LiteFragment>   void replaceFragment(FragmentActivity fragmentActivity , @IdRes int containerViewId , Class<T> fragmentClass
            , @Nullable String addToBackTag , @Nullable String fragmentTag , @Nullable Bundle bundle){
        FragmentTransaction transaction = fragmentActivity.getSupportFragmentManager().beginTransaction();
        transaction.replace(containerViewId, fragmentClass, bundle , fragmentTag);
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
        addFragment(fragmentActivity , android.R.id.content , fragment );
    }

    public static <T extends LiteFragment> void addFragment(FragmentActivity fragmentActivity , Class<T> fragmentClass){
        addFragment(fragmentActivity , android.R.id.content , fragmentClass );
    }

    public static void addFragment(FragmentActivity fragmentActivity , @IdRes int containerViewId , LiteFragment fragment){
        addFragment(fragmentActivity , containerViewId , fragment , null );
    }

    public static <T extends LiteFragment> void addFragment(FragmentActivity fragmentActivity , @IdRes int containerViewId , Class<T> fragmentClass){
        addFragment(fragmentActivity , containerViewId , fragmentClass , null );
    }


    public static void addFragment(FragmentActivity fragmentActivity , @IdRes int containerViewId , LiteFragment fragment , @Nullable String addToBackTag){
        addFragment(fragmentActivity , containerViewId , fragment , addToBackTag , null);
    }

    public static <T extends LiteFragment>  void addFragment(FragmentActivity fragmentActivity , @IdRes int containerViewId ,  Class<T> fragmentClass , @Nullable String addToBackTag){
        addFragment(fragmentActivity , containerViewId , fragmentClass , addToBackTag , null);
    }

    public static void addFragment(FragmentActivity fragmentActivity , @IdRes int containerViewId , LiteFragment fragment , @Nullable String addToBackTag , @Nullable String fragmentTag){
        FragmentTransaction transaction = fragmentActivity.getSupportFragmentManager().beginTransaction();
        transaction.add(containerViewId, fragment , fragmentTag);
        transaction.addToBackStack(addToBackTag);
        transaction.commit();
    }

    public static<T extends LiteFragment>  void addFragment(FragmentActivity fragmentActivity , @IdRes int containerViewId , Class<T> fragmentClass , @Nullable String addToBackTag , @Nullable String fragmentTag){
        addFragment(fragmentActivity , containerViewId , fragmentClass , addToBackTag , fragmentTag , null);
    }

    public static<T extends LiteFragment>  void addFragment(FragmentActivity fragmentActivity
            , @IdRes int containerViewId , Class<T> fragmentClass , @Nullable String addToBackTag , @Nullable String fragmentTag , @Nullable Bundle bundle){
        FragmentTransaction transaction = fragmentActivity.getSupportFragmentManager().beginTransaction();
        transaction.add(containerViewId, fragmentClass , bundle , fragmentTag);
        transaction.addToBackStack(addToBackTag);
        transaction.commit();
    }

    public static void remove(FragmentActivity fragmentActivity , LiteFragment fragment){
        FragmentTransaction transaction = fragmentActivity.getSupportFragmentManager().beginTransaction();
        transaction.remove(fragment);
        transaction.commit();
    }




}
