package com.example.viewpager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {

    ViewPager2 viewPager2;
    MyViewPagerAdapter myAdapter;
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.tabLayout);

        myAdapter = new MyViewPagerAdapter(
                getSupportFragmentManager(),
                getLifecycle()
        );

        myAdapter.addFragment(new FragmentOne());
        myAdapter.addFragment(new FragmentTwo());
        myAdapter.addFragment(new FragmentThree());

        //Set the orientation in ViewPager2
        viewPager2 = findViewById(R.id.viewPager2);
        viewPager2.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);

        //connecting the adapter with viewpager2
        viewPager2.setAdapter(myAdapter);

        //Connecting TabLayout with ViewPager
        new TabLayoutMediator(
                tabLayout,
                viewPager2,
                (tab, position) -> {
                    tab.setText("Fragment " + (position+1));
                }
        ).attach();
    }
}