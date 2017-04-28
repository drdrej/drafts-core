package com.touchableheroes.drafts.core.tools;

/**
 * Created by asiebert on 28.04.2017.
 */

public class StringTool {

    public static boolean isEmpty( final String val ) {
        if( val == null )
            return true;

        if( val.trim().length() < 1 )
            return true;

        return false;
    }
}
