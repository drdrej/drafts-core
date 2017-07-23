package com.touchableheroes.drafts.core.sqlite;

/**
 * Created by asiebert on 17.07.2017.
 */

interface CreateTableBuilder {

    CreateTableBuilder ifNotExist();

    SqliteCmd asCommand();

    CreateTableBuilder withCollumns(ColumnDefBuider... fields);

    CreateTableBuilder withConstraints(CreateQueryConstraintBuilder.PrimaryKeyBuilder constraint);

    CreateTableBuilder withoutRowId();

    CreateTableBuilder as(SelectQueryBuilder select);

    CreateTableBuilder withConstraints(CreateQueryConstraintBuilder... constraints);
}
