package com.example.eyemobileexam.Adapter;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class SectionsPagerAdapter extends FragmentPagerAdapter {

    private final String[] tabTitles = new String[]{}; ;


    public SectionsPagerAdapter(FragmentManager fm, String[] titles) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return null;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }

    @Override
    public int getCount() {
        return tabTitles.length;
    }
}