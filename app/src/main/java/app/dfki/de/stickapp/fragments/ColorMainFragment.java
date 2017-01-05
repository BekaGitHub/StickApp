package app.dfki.de.stickapp.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import app.dfki.de.stickapp.R;
import app.dfki.de.stickapp.data.Data;
import app.dfki.de.stickapp.tablayoutadapter.ViewPagerAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class ColorMainFragment extends Fragment {

    ViewPagerAdapter viewPagerAdapter;
    List<Fragment> fragments;
    List<String> tabs;


    public ColorMainFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        fragments = new ArrayList<>();
        tabs = new ArrayList<>();

        ColorHeadFragment colorHeadFragment = new ColorHeadFragment();
        ColorHairFragment colorHairFragment = new ColorHairFragment();
        ColorBodyFragment colorBodyFragment = new ColorBodyFragment();
        ColorLimpsFragment colorLimpsFragment = new ColorLimpsFragment();
        ColorShoesFragment colorShoesFragment = new ColorShoesFragment();
        ColorLipsFragment colorLipsFragment = new ColorLipsFragment();
        ColorEyeFragment colorEyeFragment = new ColorEyeFragment();
        ColorBrowFragment colorBrowFragment = new ColorBrowFragment();
        ColorNoseFragment colorNoseFragment = new ColorNoseFragment();
        fragments.add(colorHeadFragment);
        fragments.add(colorHairFragment);
        fragments.add(colorBodyFragment);
        fragments.add(colorLimpsFragment);
        fragments.add(colorShoesFragment);
        fragments.add(colorLipsFragment);
        fragments.add(colorEyeFragment);
        fragments.add(colorBrowFragment);
        fragments.add(colorNoseFragment);
        tabs.add(Data.COLORITEMS[0]);
        tabs.add(Data.COLORITEMS[1]);
        tabs.add(Data.COLORITEMS[2]);
        tabs.add(Data.COLORITEMS[3]);
        tabs.add(Data.COLORITEMS[4]);
        tabs.add(Data.COLORITEMS[5]);
        tabs.add(Data.COLORITEMS[6]);
        tabs.add(Data.COLORITEMS[7]);
        tabs.add(Data.COLORITEMS[8]);

        viewPagerAdapter = new ViewPagerAdapter(getActivity().getSupportFragmentManager(), fragments, tabs);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_color_main, container, false);
        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.tabLayout);
        ViewPager viewPager = (ViewPager) view.findViewById(R.id.viewPager);

        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

        return view;
    }

}
