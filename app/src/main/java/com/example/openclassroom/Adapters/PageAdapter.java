package com.example.openclassroom.Adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.openclassroom.Controllers.Fragments.PageFragment;

public class PageAdapter extends FragmentPagerAdapter {
    //permet de faire le lien entre le ViewPager et le fragmant donc se page
    private int[] colors;

    public PageAdapter(@NonNull FragmentManager fm, int[] color) {
        super(fm);
        this.colors = color;
    }

    @Override
    public int getCount() {
        return 6;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return (PageFragment.newInstance(position,this.colors[position]));
    }


}
