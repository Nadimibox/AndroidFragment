package com.nadimibox.androidfragment.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import com.nadimibox.androidfragment.LiteFragment;

public abstract class AppCompatToolbarFragment extends LiteFragment {

    Toolbar toolbar;
    boolean hasOptionsMenu;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    public abstract Toolbar getToolbar(View rootView);

    @Override
    public final View onCreateRootView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  onCreateToolbarRootView(inflater , container , savedInstanceState);
        toolbar  = getToolbar(view);
        if (toolbar != null) {
            invalidateToolbarMenu();
        }
        return view;
    }

    public abstract View onCreateToolbarRootView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState);

    private void invalidateToolbarMenu(){
        toolbar.getMenu().clear();
        if(hasOptionsMenu){
            ((AppCompatActivity) requireActivity()).setSupportActionBar(toolbar);
        }
    }

    @Override
    public void setHasOptionsMenu(boolean hasMenu) {
        super.setHasOptionsMenu(hasMenu);
        hasOptionsMenu=hasMenu;
        invalidateOptionsMenu();
    }

    public void invalidateOptionsMenu(){
        if(toolbar!=null){
            invalidateToolbarMenu();
        }else if(getActivity()!=null){
            requireActivity().invalidateOptionsMenu();
        }
    }




    public void setTitle(String title){
        if (toolbar == null)return;
        this.toolbar.setTitle(title);
    }

    public void setTitle(@StringRes int title){
        if (toolbar == null)return;
        this.toolbar.setTitle(title);
    }

    public void setSubtitle(String subTitle){
        if (toolbar == null)return;
        this.toolbar.setSubtitle(subTitle);
    }

    public void setSubtitle(@StringRes int subTitle){
        if (toolbar == null)return;
        this.toolbar.setSubtitle(subTitle);
    }

    /**
     * Navigation icon like back button
     * @param icon: Icon res
     */
    public void setNavigationIcon(@DrawableRes int icon){
        if (toolbar == null)return;
        toolbar.setNavigationIcon(ContextCompat.getDrawable(requireContext() , icon));
    }

    public void setNavigationIconClickListener(View.OnClickListener onClickListener){
        if (toolbar == null)return;
        toolbar.setNavigationOnClickListener(onClickListener);
    }

    /**
     * Remove navigation icon like back butoon
     */
    public void removeNavigationIcon(){
        if (toolbar == null)return;
        toolbar.setNavigationIcon(null);
        toolbar.setOnClickListener(null);
    }

    public void setElevation(float elevation){
        if (toolbar == null)return;
        toolbar.setElevation(elevation);
    }

}
