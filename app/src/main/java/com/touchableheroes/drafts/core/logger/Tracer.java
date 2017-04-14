package com.touchableheroes.drafts.core.logger;

import android.util.Log;

/**
 * Created by asiebert on 27.11.15.
 */
public class Tracer {

    public static void method( ) {
        // TODO: Stacktrace analysieren.
        method( "<unknown>" );
    }

    /**
     * wird beim eintreten in eine methode verwendet.
     *
     * @param name
     */
    public static void method( final String name ) {
        Log.d( "METHOD", name ); // TODO Klassennamen evtl. bestimmen.
    }

    /**
     * einfaches trace/log.
     */
    public static void log( final String msg ) {
        Log.d( "LOG", msg );
    }

    /**
     * logt unerwartetes verhalten.
     */
    public static void bug( final String msg ) {
        Log.e( "BUG", msg ); // d.h. dann wenn ein unerwarteter zustand in der app kommt. quasi hidden exception.
    }
}
