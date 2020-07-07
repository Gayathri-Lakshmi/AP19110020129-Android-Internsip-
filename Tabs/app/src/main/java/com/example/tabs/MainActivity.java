package com.example.tabs;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    ViewPager pager;
    TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );
        pager=(ViewPager) findViewById ( R.id.pager );
        tabLayout=(TabLayout)findViewById ( R.id.tab );
        pager.setAdapter( new TabAdapter(getSupportFragmentManager()));
        tabLayout.setupWithViewPager ( pager );
        setupTabIcons();
    }

    class TabAdapter extends FragmentPagerAdapter{


        public TabAdapter(@NonNull FragmentManager fm) {
            super ( fm );
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            switch(position){
                case 0:
                    return new Chats ();
                case 1:
                    return new Status ();
                case 2:
                    return new Calls ();
            }

            return null;
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            switch (position){
                case 0:
                    return "Chats";
                case 1:
                    return "Status";
                case 2:
                    return "Calls";

            }
            return super.getPageTitle ( position );
        }

    }
    private void setupTabIcons() {
        tabLayout.getTabAt(0).setIcon(R.drawable.chat);
        tabLayout.getTabAt(1).setIcon(R.drawable.status);
        tabLayout.getTabAt(2).setIcon(R.drawable.call);
    }


}