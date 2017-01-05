package app.dfki.de.stickapp.util;

import android.support.v4.app.Fragment;

import java.util.ArrayList;
import java.util.List;

import app.dfki.de.stickapp.fragments.ColorBodyFragment;
import app.dfki.de.stickapp.fragments.ColorBrowFragment;
import app.dfki.de.stickapp.fragments.ColorEyeFragment;
import app.dfki.de.stickapp.fragments.ColorHairFragment;
import app.dfki.de.stickapp.fragments.ColorHeadFragment;
import app.dfki.de.stickapp.fragments.ColorLimpsFragment;
import app.dfki.de.stickapp.fragments.ColorLipsFragment;
import app.dfki.de.stickapp.fragments.ColorNoseFragment;
import app.dfki.de.stickapp.fragments.ColorShoesFragment;

/**
 * Created by EmpaT on 04.01.2017.
 */

public class Utility {

    public static int currentFragmentPosition = 0;
    public static List<Fragment> fragments = new ArrayList<>();

    public static void fillFragmentList()
    {
        fragments.add(new ColorHeadFragment());
        fragments.add(new ColorHairFragment());
        fragments.add(new ColorBodyFragment());
        fragments.add(new ColorLimpsFragment());
        fragments.add(new ColorShoesFragment());
        fragments.add(new ColorLipsFragment());
        fragments.add(new ColorEyeFragment());
        fragments.add(new ColorBrowFragment());
        fragments.add(new ColorNoseFragment());
    }

    public static Fragment getNextFragment()
    {
        if(currentFragmentPosition == fragments.size()-1)
        {
            currentFragmentPosition = 0;
            return fragments.get(currentFragmentPosition);
        }
        else
        {
            currentFragmentPosition++;
            return fragments.get(currentFragmentPosition);
        }
    }

    public static Fragment getPreviousFragment()
    {
        if(currentFragmentPosition == 0)
        {
            currentFragmentPosition = fragments.size()-1;
            return fragments.get(currentFragmentPosition);
        }
        else
        {
            currentFragmentPosition--;
            return fragments.get(currentFragmentPosition);
        }
    }



}
