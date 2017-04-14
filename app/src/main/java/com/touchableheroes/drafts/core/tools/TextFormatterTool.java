package com.touchableheroes.drafts.core.tools;

import android.location.Location;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by asiebert on 12.04.16.
 */
public class TextFormatterTool {

    public static class KM {

        public static String format(final long km) {
            return km + " km";
        }
    }

    public static class GPS {

        public static String format(final double lng, final double lat ) {
            return lng + " long / " + lat + " lat";
        }

        public static String format(Location location) {
            return format(location.getLongitude(), location.getLatitude());

        }
    }

    public static class DATE_TIME {

        public static String format(final Date date) {
            if( date == null )
                return "";

            final SimpleDateFormat formatter = new SimpleDateFormat( "dd.MM.yyyy HH:mm" );
            return formatter.format(date);
        }
    }
}
