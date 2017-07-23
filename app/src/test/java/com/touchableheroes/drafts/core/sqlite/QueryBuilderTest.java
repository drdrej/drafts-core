package com.touchableheroes.drafts.core.sqlite;

import org.junit.Test;

/**
 * Created by asiebert on 17.07.2017.
 */
public class QueryBuilderTest {

    @Test
    public void createTable() {
        QueryBuilder
                .create(TableType.TEMP)
                .table("schemaname", "tablename")
                .ifNotExist()
                .withCollumns(
                        ColumnDefBuider
                                .column("columnName",
                                        ColumnType.TEXT)
                )
                .withConstraints(
                        CreateQueryConstraintBuilder
                                .constraint("constraintname")
                                .primaryKey(SortOrder.ASC)
                                .onConflict(ConflictRuleType.ROLLBACK)
                                .autoincrement()
                                .get(),

                        CreateQueryConstraintBuilder
                                .constraint("constraintname")
                                .notNull()
                                .onConflict(ConflictRuleType.ROLLBACK)
                                .get(),

                        CreateQueryConstraintBuilder
                                .constraint("constraintname")
                                .unique()
                                .onConflict(ConflictRuleType.ROLLBACK)
                                .get(),

                        CreateQueryConstraintBuilder
                                .constraint("constraintname")
                                .defaultValue(""),

                        CreateQueryConstraintBuilder
                                .constraint("constraintname")
                                .collate(""),

                        CreateQueryConstraintBuilder
                                .constraint("constraintname")
                                .check(ExpressionBuilder.expression()),

                        CreateQueryConstraintBuilder
                                .constraint("constraintname")
                                .check(ExpressionBuilder
                                        .value("string-literal")),

                        CreateQueryConstraintBuilder
                                .constraint("constraintname")
                                .check(ExpressionBuilder
                                        .value("string-literal")
                                        .and(ExpressionBuilder
                                                .value("string-literal")
                                        )
                                ),

                        CreateQueryConstraintBuilder
                                .constraint("constraintname")
                                .check(ExpressionBuilder
                                        .function("fnc name")
                                        .withExpression(ExpressionBuilder
                                                .value("string-literal")
                                        )
                                ),

                        CreateQueryConstraintBuilder
                                .constraint("constraintname")
                                .check(ExpressionBuilder
                                        .column( "schema.table.column" )
                                ),

                        CreateQueryConstraintBuilder
                                .constraint("constraintname")
                                .check(ExpressionBuilder
                                        .cast( ExpressionBuilder
                                                .expression() )
                                )
                )
                .withoutRowId()
                .as(
                        SelectQueryBuilder
                                .select())
                .asCommand();
    }


    public void testDropTable() {
        SqliteCmd cmd = QueryBuilder
                .drop()
                .table(TableX.class)
                .ifExists().asCommand();

        // assert cmd not null
    }

    @Test
    public void testExecPipe() {
        SqliteCmdPipe pipe = new SimpleSqliteCmdPipe();

        // drop.onEach(
                /*
                new Consumer<Object>() {
            public void accept(Object o) {

            }
            */
        //});

        // wie bikde ich das ab: fuer jeden x erstelle ein y. -> wie sind die params gebunden?

        pipe.put(
                QueryBuilder
                        .drop()
                        .table(TableX.class)
                        .ifExists().asCommand())

                .put(
                        QueryBuilder
                                .create(TableType.TEMP)
                                .table(TableX.class)
                                .asCommand()
                )

                .put(
                        QueryBuilder
                                .create(TableType.TEMP)
                                .table(TableX.class)
                                .ifNotExist()
                                .asCommand()
                );
    }

}