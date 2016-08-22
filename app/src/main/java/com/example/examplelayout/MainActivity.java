package com.example.examplelayout;

import android.graphics.Color;
import android.os.Handler;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.examplelayout.fragments.SettingFragment;
import com.example.examplelayout.fragments.HomeFragment;
import com.example.examplelayout.fragments.HelpFragment;
import com.example.examplelayout.fragments.MyOrderFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //Seperti biasa, deklarasi dulu
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private boolean doubleBackToExitPressedOnce = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Inisiasi toolbar, biar ada toolbarnya + diset elevation 0 biar gak ada shadow
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        TextView judulToolbar = (TextView) toolbar.findViewById(R.id.toolbar_title);
        setSupportActionBar(toolbar);
        judulToolbar.setText(/*toolbar.getTitle()*/"Example Layout Apps");
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setElevation(0);

        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.pager);
        //Buat Nama Tabnya
        tabLayout.addTab(tabLayout.newTab().setText("HOME"));
        tabLayout.addTab(tabLayout.newTab().setText("MY ORDER"));
        tabLayout.addTab(tabLayout.newTab().setText("HELP"));
        tabLayout.addTab(tabLayout.newTab().setText("SETTING"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        //Panggil method setupViewPager buat make custom adapter
        setupViewPager(viewPager);
        //Custom adapter dipake buat tabLayout
        tabLayout.setupWithViewPager(viewPager);
        //Panggil method setupTabIcons buat ngisi kekosongan tabLayoutnya :v
        setupTabIcons();
    }

    private void setupTabIcons() {

        TextView tabOne = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabOne.setText("HOME");
        tabOne.setTextColor(Color.WHITE);
        tabOne.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_tab_home, 0, 0);
        tabLayout.getTabAt(0).setCustomView(tabOne);

        TextView tabTwo = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabTwo.setText("MY ORDER");
        tabTwo.setTextColor(Color.WHITE);
        tabTwo.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_tab_order, 0, 0);
        tabLayout.getTabAt(1).setCustomView(tabTwo);

        TextView tabThree = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabThree.setText("HELP");
        tabThree.setTextColor(Color.WHITE);
        tabThree.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_tab_help, 0, 0);
        tabLayout.getTabAt(2).setCustomView(tabThree);

        TextView tabFour = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabFour.setText("SETTING");
        tabFour.setTextColor(Color.WHITE);
        tabFour.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.ic_tab_setting, 0, 0);
        tabLayout.getTabAt(3).setCustomView(tabFour);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new HomeFragment(), "HOME");
        adapter.addFrag(new MyOrderFragment(), "MY ORDER");
        adapter.addFrag(new HelpFragment(), "HELP");
        adapter.addFrag(new SettingFragment(), "SETTING");
        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
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

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }
        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Tekan lagi untuk keluar!", Toast.LENGTH_SHORT).show();
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce = false;
            }
        }, 2000);
    }
}
