package com.touchableheroes.drafts.core.sqlite;

import java.math.BigDecimal;

/**
 * Created by asiebert on 20.07.2017.
 */

public class CreateQueryConstraintBuilder {

    public static CreateQueryConstraintBuilder constraint(String constraintname) {
        return null;
    }

    public CreateQueryConstraintBuilder.PrimaryKeyBuilder primaryKey(SortOrder asc) {
        return null;
    }

    public UniqueBuilder unique() {
        return null;
    }
    public NotNullBuilder notNull() {
        return null;
    }

    public CreateQueryConstraintBuilder defaultValue(BigDecimal number) {
        return null;
    }

    public CreateQueryConstraintBuilder defaultValue(String number) {
        return null;
    }

    public CreateQueryConstraintBuilder defaultValue(ExpressionBuilder number) {
        return null;
    }

    public CreateQueryConstraintBuilder collate(String s) {
        return null;
    }

    public CreateQueryConstraintBuilder check(ExpressionBuilder expressionBuilder) {
        return null;
    }

    public class UniqueBuilder
            implements ConstraintBuilder {
        public UniqueBuilder onConflict(ConflictRuleType clause) {
            return null;
        }

        public CreateQueryConstraintBuilder get() {
            return null;
        }
    }
    public class NotNullBuilder
            implements ConstraintBuilder {
        public NotNullBuilder onConflict(ConflictRuleType clause) {
            return null;
        }

        public CreateQueryConstraintBuilder get() {
            return null;
        }
    }

    public class PrimaryKeyBuilder
         implements ConstraintBuilder{

        public PrimaryKeyBuilder onConflict(ConflictRuleType clause) {
            return null;
        }

        public PrimaryKeyBuilder autoincrement() {
            return this;
        }

        public CreateQueryConstraintBuilder get() {
            return null;
        }
    }


}
