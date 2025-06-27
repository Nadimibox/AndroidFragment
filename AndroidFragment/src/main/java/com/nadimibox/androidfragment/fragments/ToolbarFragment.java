package com.nadimibox.androidfragment.fragments;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.DrawableRes;
import androidx.annotation.MenuRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import com.nadimibox.androidfragment.LiteFragment;

public abstract class ToolbarFragment extends LiteFragment implements Toolbar.OnMenuItemClickListener {

    Toolbar toolbar;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }



    @Override
    public final View onCreateRootView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  onCreateToolbarRootView(inflater , container , savedInstanceState);
        toolbar  = getToolbar(view);
        if (toolbar != null) {
            toolbar.getMenu().clear();
            if (getMenuRes() != -1){
                toolbar.inflateMenu(getMenuRes());
                toolbar.setOnMenuItemClickListener(this);
            }

        }
        return view;
    }

    public abstract View onCreateToolbarRootView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState);


    public abstract Toolbar getToolbar(View rootView);

    /**
     * Override when you have menu in toolbar
     * @return the menu resource id
     */
    @MenuRes
    public int getMenuRes(){
        return -1;
    }

    /**
     *
     * @param item {@link MenuItem} that was clicked
     * @return Override when you have menu in toolbar
     */
    public boolean onMenuItemClick(MenuItem item){
        return false;
    }



    public final void setTitle(String title){
        if (toolbar == null)return;
        this.toolbar.setTitle(title);
    }

    public final void setTitle(@StringRes int title){
        if (toolbar == null)return;
        this.toolbar.setTitle(title);
    }

    public final void setSubtitle(String subTitle){
        if (toolbar == null)return;
        this.toolbar.setSubtitle(subTitle);
    }

    public final void setSubtitle(@StringRes int subTitle){
        if (toolbar == null)return;
        this.toolbar.setSubtitle(subTitle);
    }

    /**
     * Navigation icon like back button
     * @param icon: Icon res
     */
    public final void setNavigationIcon(@DrawableRes int icon){
        if (toolbar == null)return;
        toolbar.setNavigationIcon(ContextCompat.getDrawable(requireContext() , icon));
    }

    public final void setNavigationIconClickListener(View.OnClickListener onClickListener){
        if (toolbar == null)return;
        toolbar.setNavigationOnClickListener(onClickListener);
    }

    /**
     * Remove navigation icon like back butoon
     */
    public final void removeNavigationIcon(){
        if (toolbar == null)return;
        toolbar.setNavigationIcon(null);
        toolbar.setOnClickListener(null);
    }

    public final void setElevation(float elevation){
        if (toolbar == null)return;
        toolbar.setElevation(elevation);
    }

}