package com.touchableheroes.drafts.core.sqlite;

/**
 * Created by asiebert on 23.07.2017.
 *
 * https://sqlite.org/syntax/expr.html
 */

class ExpressionBuilder {
    /**
     * remove!.
     *
     * @return
     */
    @Deprecated
    public static ExpressionBuilder expression() {
        return null;
    }

    public static ExpressionBuilder value( String literal) {
        return null;
    }

    /**
     * rewrite!.
     *
     * @return
     */
    @Deprecated
    public ExpressionBuilder bindParameter() {
        return null;
    }

    public ExpressionBuilder and(
            final ExpressionBuilder first,
            final ExpressionBuilder... expressions) {
        return null;
    }

    public static FunctionBuilder function(String expression) {
        return null;
    }

    public static FunctionBuilder function(String expression, boolean distinct) {
        return null;
    }

    public static ExpressionBuilder column(String s) {
        return null;
    }

    public static CastExpressionBuilder cast(ExpressionBuilder expr) {
        return null;
    }

    public class CastExpressionBuilder {
        /**
         * klaeren welche typenames...
         */
        @Deprecated
        public ExpressionBuilder as() {
            return null;
        }
    }

    public class FunctionBuilder {

        public ExpressionBuilder withExpression(ExpressionBuilder... expression) {
            return null;
        }
    }

    /**
     * rewrite!.
     *
     * @return
     */
    @Deprecated
    public ExpressionBuilder unaryOperator() {
        return null;
    }
}
