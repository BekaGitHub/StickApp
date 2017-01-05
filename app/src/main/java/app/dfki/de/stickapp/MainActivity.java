package app.dfki.de.stickapp;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import app.dfki.de.stickapp.fragments.ColorFragment;
import app.dfki.de.stickapp.fragments.Muster1Fragment;
import app.dfki.de.stickapp.fragments.TransparentyFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frame, new ColorFragment())
                .commit();
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_color) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frame, new ColorFragment())
                    .commit();

        } else if (id == R.id.nav_emotion) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frame, new TransparentyFragment())
                    .commit();

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
