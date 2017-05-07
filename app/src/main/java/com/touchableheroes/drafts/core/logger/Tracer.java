package com.touchableheroes.drafts.core.logger;

import android.util.Log;

/**
 * Created by asiebert on 27.11.15.
 */
public class Tracer {

    private static Tracer SINGLETON = new Tracer();

    /**
     * IF Code is running setDevMode (in dev mode)
     */
    private boolean defensive;

    public synchronized static void setDevMode(final boolean devMode) {
        SINGLETON.defensive = devMode;
    }

    public synchronized static boolean isDevMode() {
        return SINGLETON.defensive;
    }

    public static void method( ) {
        // TODO: Stacktrace analysieren.
        method( "<unknown>" );
    }

    /**
     * wird beim eintreten in eine methode verwendet.
     *
     * @param msg
     */
    public static void method( final String msg ) {
        Log.d( "METHOD", msg ); // TODO Klassennamen evtl. bestimmen.
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
    @Deprecated
    public static void bug( final String msg ) {
        Log.e( "TODO", msg ); // d.h. dann wenn ein unerwarteter zustand in der app kommt. quasi hidden exception.
    }

    public static void prove( final Fact fnc ) {
        try {
            fnc.check();
        } catch( final Throwable x) {
            final String errMsg = "Couldn't exec. Fact not proved [fact=" + fnc.getClass().getSimpleName() + "]";
            if( isDevMode() ) {
                throw error( errMsg, x );
            } else {
                skip( errMsg, x );
            }
        }
    }

    private static void skip(final String errMsg,
                             final Throwable x) {
        Log.e( "BROKEN", "Catched a probem, but tries to run without break. Check cause: " + errMsg, x );
    }

    private static RuntimeException error(final String errMsg,
                                   final Throwable cause) {
        return new IllegalStateException( errMsg, cause );
    }

}
