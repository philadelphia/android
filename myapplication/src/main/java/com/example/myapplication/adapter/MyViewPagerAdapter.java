package com.example.myapplication.adapter;


import java.util.List;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import android.view.ViewGroup;

/**
 * Created by Tao.ZT.Zhang on 2016/7/23.
 */
public class MyViewPagerAdapter extends FragmentPagerAdapter
{

        public List<Fragment>	mTabFraments;

        private String[]		mTabTitles;


    public MyViewPagerAdapter(FragmentManager fm, List<Fragment> fragments, String[] titles)
        {
            super (fm);
            mTabTitles = titles;
            mTabFraments = fragments;
        }

        @Override
        public Fragment getItem (int position)
        {
            return mTabFraments.get (position);
        }

        @Override
        public int getCount ()
        {
            return mTabFraments.size ();
        }

        @Override
        public CharSequence getPageTitle (int position)
        {
            return mTabTitles[position];
        }


    @Override
    public Object instantiateItem(ViewGroup container, int position) {



        return super.instantiateItem(container, position);
    }


    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        super.destroyItem(container, position, object);
    }


}
