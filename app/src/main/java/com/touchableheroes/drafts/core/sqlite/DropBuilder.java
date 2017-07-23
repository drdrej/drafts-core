package com.touchableheroes.drafts.core.sqlite;

/**
 * Created by asiebert on 17.07.2017.
 */

interface DropBuilder {


    DropBuilder table(Class<TableX> tableXClass);

    DropBuilder ifExists();

    SqliteCmd asCommand();
}
