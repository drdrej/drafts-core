package com.touchableheroes.drafts.core.sqlite;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by asiebert on 18.07.2017.
 */

class SimpleSqliteCmdPipe implements SqliteCmdPipe {

    private List<SqliteCmd> commands = new ArrayList<>();

    @Override
    public SqliteCmdPipe put(
            final SqliteCmd cmd) {
        this.commands.add( cmd );
        return this;
    }

    public void exec() {

    }
}
