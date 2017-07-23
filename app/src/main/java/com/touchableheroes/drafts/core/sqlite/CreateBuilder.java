package com.touchableheroes.drafts.core.sqlite;

/**
 * Created by asiebert on 17.07.2017.
 */

interface CreateBuilder {

    enum TableType {

    }

    CreateTableBuilder table(
            String type,
            String table
    );

    CreateTableBuilder table(
            Class<? extends Enum> table
    );

}
