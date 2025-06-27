package com.nadimibox.androidfragment.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import com.nadimibox.androidfragment.LiteFragment;

/**
 * Developer: Mohamad Nadimi
 * Company: Saghe
 * Website: https://www.mrnadimi.com
 * Created on 31 October 2021
 * <p>
 * Description: ...
 */
public abstract class ToolbarFragment extends LiteFragment {

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
            toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem item) {
                    return onOptionsItemSelected(item);
                }
            });
        }
        return view;
    }

    public abstract View onCreateToolbarRootView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState);

    private void invalidateToolbarMenu(){
        toolbar.getMenu().clear();
        if(hasOptionsMenu){
            onCreateOptionsMenu(toolbar.getMenu(), new MenuInflater(requireActivity()));
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
     * Remove navigation icon like back button
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