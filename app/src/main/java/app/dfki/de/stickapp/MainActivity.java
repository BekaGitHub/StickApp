package app.dfki.de.stickapp;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import app.dfki.de.stickapp.data.ColorData;
import app.dfki.de.stickapp.fragments.ColorFragment;
import app.dfki.de.stickapp.tablayoutadapter.ViewPagerAdapter;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    public TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), this);

        for(int i = 0; i< ColorData.COLORITEMS.length; i++)
        {
            ColorFragment colorFragment = new ColorFragment();
            Bundle bundle = new Bundle();
            bundle.putString("prefix", "Color" + ColorData.COLORITEMS[i] + "-");
            colorFragment.setArguments(bundle);
            viewPagerAdapter.addFragments(colorFragment, ColorData.COLORITEMS[i]);
        }

        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_color) {

        } else if (id == R.id.nav_emotion) {

        } else if (id == R.id.nav_gesture) {

        } else if (id == R.id.nav_head) {

        } else if (id == R.id.nav_environment) {

        } else if (id == R.id.nav_idle_section) {

        }else if (id == R.id.nav_posture) {

        }else if (id == R.id.nav_background) {

        }else if (id == R.id.nav_rotation) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
