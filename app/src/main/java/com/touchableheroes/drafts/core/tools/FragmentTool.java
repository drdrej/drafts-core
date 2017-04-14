package com.touchableheroes.drafts.core.tools;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.touchableheroes.drafts.blackbox.R;

/**
 * Created by asiebert on 14.04.16.
 */
public class FragmentTool {

    public static class FragmentWrapper {

        private final Fragment src;

        public FragmentWrapper(final Fragment frgmt) {
            this.src = frgmt;
        }

        public FragmentWrapper bindGMap(final OnMapReadyCallback syncListener) {
            final FragmentManager mgr = this.src.getChildFragmentManager();
            final SupportMapFragment fm = (SupportMapFragment) mgr.findFragmentById(R.id.frgmt_map);

            this.src.getActivity().getSupportFragmentManager()
                    .findFragmentById(R.id.frgmt_map);

            fm.getMapAsync(syncListener);

            return this;
        }
    }

    public static FragmentWrapper withFragment(final Fragment frgmt) {
        return new FragmentWrapper(frgmt);
    }
}
