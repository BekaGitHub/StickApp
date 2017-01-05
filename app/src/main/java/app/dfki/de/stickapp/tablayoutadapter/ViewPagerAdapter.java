package app.dfki.de.stickapp.tablayoutadapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by EmpaT on 03.01.2017.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter{

    List<Fragment> fragments = new ArrayList<>();
    List<String> tabTitels = new ArrayList<>();

    public ViewPagerAdapter(FragmentManager fm, List<Fragment> fragments, List<String> tabs) {

        super(fm);
        this.fragments = fragments;
        this.tabTitels = tabs;
    }

    @Override
    public Fragment getItem(int position) {

        return this.fragments.get(position);
    }

    @Override
    public int getCount() {

        return fragments.size();
    }

    public void addFragments(Fragment fragment, String tabTitel)
    {
        this.fragments.add(fragment);
        this.tabTitels.add(tabTitel);
    }

    @Override
    public CharSequence getPageTitle(int position) {

        return tabTitels.get(position);

    }
}
