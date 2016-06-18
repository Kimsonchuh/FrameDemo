package com.kimson.framedemo.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;

import com.kimson.framedemo.R;
import com.kimson.framedemo.ui.base.BaseActivity;
import com.kimson.framedemo.ui.fragment.TabOneFragment;
import com.kimson.framedemo.ui.fragment.TabThreeFragment;
import com.kimson.framedemo.ui.fragment.TabTwoFragment;
import com.kimson.library.bind.ViewById;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhujianheng on 6/18/16.
 */
public class TabActivity extends BaseActivity {

    @ViewById(R.id.tabanim_toolbar)
    private Toolbar mToolbar;
    @ViewById(R.id.tabanim_tabs)
    private TabLayout mTabLayout;
    @ViewById(R.id.tabanim_viewpager)
    private ViewPager mViewPager;
    private ViewPagerAdapter mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);
        setSupportActionBar(mToolbar);
        setUpViewPager(mViewPager);
        mTabLayout.setupWithViewPager(mViewPager);
    }


    private void setUpViewPager(ViewPager viewPager) {
        mAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        mAdapter.addFrag(TabOneFragment.newInstance("ONE"), "ONE");
        mAdapter.addFrag(TabTwoFragment.newInstance("TWO"), "TWO");
        mAdapter.addFrag(TabThreeFragment.newInstance("THREE"), "THREE");
        viewPager.setAdapter(mAdapter);
    }


    private class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFrag(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }

}
