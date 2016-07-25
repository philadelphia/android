package com.example.myapplication.adapter;


import java.util.List;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
/**
 * Created by Tao.ZT.Zhang on 2016/7/23.
 */
public class MyViewPagerAdapter extends FragmentPagerAdapter
{
        FragmentManager			fm;

        public List<Fragment>	mTabFraments;

        private String[]		mTabTitles;

        public MyViewPagerAdapter(FragmentManager fm)
        {
            super (fm);
            this.fm = fm;
        }

        public MyViewPagerAdapter(FragmentManager fm, List<Fragment> fragments, String[] titles)
        {
            super (fm);
            this.fm = fm;
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


}
