package com.touchableheroes.drafts.core.sqlite;

/**
 * Created by asiebert on 20.07.2017.
 */

public enum ColumnType {

    TEXT,
    NUMERIC,
    INTEGER,
    REAL,
    BLOB,
    NONE;
/*
    affinities:
    https://www.sqlite.org/datatype3.html
    */
    public static ColumnType varchar() {
        return null;
    }



}
