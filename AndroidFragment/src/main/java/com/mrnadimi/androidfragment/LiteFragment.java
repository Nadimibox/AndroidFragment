package com.mrnadimi.androidfragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.CallSuper;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

/**
 * Developer: Mohamad Nadimi
 * Company: Saghe
 * Website: https://www.mrnadimi.com
 * Created on 29 July 2021
 * <p>
 * Description: ...
 */
public abstract class LiteFragment extends Fragment {

    private ViewGroup rootView;

    private boolean resumed;
    private boolean hidden;
    private boolean viewCreated = false;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public final View onCreateView(@NonNull LayoutInflater inflater, @Nullable  ViewGroup container, @Nullable  Bundle savedInstanceState) {
        this.rootView = (ViewGroup) onCreateRootView(inflater , container , savedInstanceState);
        /*this.rootView .setFocusableInTouchMode(true);
        this.rootView .requestFocus();
        this.rootView .setOnKeyListener( new View.OnKeyListener()
        {
            @Override
            public boolean onKey( View v, int keyCode, KeyEvent event )
            {

                if( event.getAction()!=KeyEvent.ACTION_DOWN &&  keyCode == KeyEvent.KEYCODE_BACK )
                {
                    try {
                        return onBackPressed();
                    }catch (Exception ex){
                        ex.printStackTrace();
                    }
                    return false;
                }
                return false;
            }
        } );*/
        OnBackPressedCallback callback = new OnBackPressedCallback(true /* enabled by default */) {
            @Override
            public void handleOnBackPressed() {
                // Handle the back button event
                boolean callActivitiesBack = !onBackPressed();
                if (callActivitiesBack){
                    //Important: https://stackoverflow.com/a/57897677/6098741
                    setEnabled(false);
                    requireActivity().onBackPressed();
                }
            }
        };
        requireActivity().getOnBackPressedDispatcher().addCallback(getViewLifecycleOwner(), callback);
        init(rootView);
        viewCreated = true;
        return this.rootView;
    }


    public abstract View onCreateRootView(@NonNull LayoutInflater inflater, @Nullable  ViewGroup container, @Nullable  Bundle savedInstanceState);


    public abstract void init(ViewGroup rootView);

    public View getRootView() {
        return rootView;
    }


    @Override
    public final void onHiddenChanged(boolean hidden){
        super.onHiddenChanged(hidden);
        if(hidden!=this.hidden && resumed){
            this.hidden=hidden;
            if(hidden)
                onHidden();
            else
                onShown();
        }
    }


    @Override
    public void onResume(){
        super.onResume();
        resumed=true;
        if(!hidden)
            onShown();
    }

    @Override
    public void onPause(){
        super.onPause();
        resumed=false;
        if(!hidden)
            onHidden();
    }

    @CallSuper
    public void onShown(){
    }

    @CallSuper
    public void onHidden(){
    }

    /**
     *
     * @return if true back button will not work
     * if false back button is do action and worked
     */
    public boolean onBackPressed(){
        Log.e("BackPressed" ," "+getClass().getName());
        return false;
    }

    public FragmentActivity getFragmentActivity(){
        return requireActivity();
    }

    public FragmentManager getSupportFragmentManager(){
        return getFragmentActivity().getSupportFragmentManager();
    }

    public boolean isViewCreated(){
        return viewCreated;
    }
}
