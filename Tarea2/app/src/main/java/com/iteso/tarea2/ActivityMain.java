package com.iteso.tarea2;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.Locale;

public class ActivityMain extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    SectionsPagerAdapter mSectionsPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar); setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager()); viewPager = (ViewPager) findViewById(R.id.viewpager); viewPager.setAdapter(mSectionsPagerAdapter);
        tabLayout = (TabLayout) findViewById(R.id.tabs); tabLayout.setupWithViewPager(viewPager);
    }


    /*public static class PlaceholderFragment extends Fragment {
        private static final String ARG_SECTION_NUMBER = "section_number";
        public static PlaceholderFragment newInstance(int sectionNumber) { PlaceholderFragment fragment = new PlaceholderFragment(); Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber); fragment.setArguments(args);
            return fragment;
        }
        public PlaceholderFragment() { }
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_activity_main, container, false);
            return rootView; }
    }*/

    public class SectionsPagerAdapter extends FragmentPagerAdapter {
        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }
        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new FragmentTechnology();
                case 1:
                    return new FragmentHome();
                case 2:
                    return new FragmentElectronics();
                default:
                    return new FragmentTechnology();
            }
        }

        @Override
        public int getCount() {
            return 3;
        }
        @Override
        public CharSequence getPageTitle(int position) {
            Locale l = Locale.getDefault(); switch (position) {
                case 0: return getString(R.string.title_section1).toUpperCase(l);
                case 1: return getString(R.string.title_section2).toUpperCase(l);
                case 2: return getString(R.string.title_section3).toUpperCase(l);
            }
            return null;
        }

    }
}
