package com.touchableheroes.drafts.core.tools;

/**
 * Created by asiebert on 28.04.2017.
 */

public class ArrayTool {

    public static boolean isEmpty( final Object... vals ) {
        if( vals == null)
            return true;

        if( vals.length == 0 )
            return true;

        for (Object val : vals) {
            if( val != null )
                return false;
        }

        return false;
    }

}
