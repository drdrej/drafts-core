package com.touchableheroes.drafts.core.tools;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by asiebert on 11.04.16.
 */
public class MarkerTool {

    public static class MarkerWrapper {

        private final GoogleMap map;

        public MarkerWrapper(GoogleMap map) {
            this.map = map;
        }

        public Marker newMarker( final String title,
                                 final LatLng position) {
            final MarkerOptions markerOpt = new MarkerOptions();

            markerOpt.draggable(false);
            markerOpt.position(position);
            markerOpt.title("Aktuelle Position");

            return map.addMarker(markerOpt);
        }
    }


    public static MarkerWrapper withMap( GoogleMap map ) {
        return new MarkerWrapper( map );
    }


}
