package com.touchableheroes.drafts.core.tools;

import com.touchableheroes.drafts.core.logger.Tracer;

import java.lang.annotation.Annotation;
import java.util.EnumSet;

/**
 * Created by asiebert on 26.02.16.
 */
public class EnumTool {

    public static int id(final Enum enumX) {
        return enumX.ordinal();
    }


    public static class EnumWrapper {

        private final Enum src;

        private EnumWrapper(final Enum enumX) {
            this.src = enumX;
        }

        public <A extends Annotation> A annotation(final Class<A> key) {
            Tracer.method();

            final String fieldName = src.name();
            try {
                return src.getClass().getField(fieldName).getAnnotation(key);
            } catch (final Throwable x) {
                Tracer.bug("missing @annotation: " + key);
                return null;
            }
        }

        public EnumTypeWrapper onType() {
            return new EnumTypeWrapper((Class<Enum>) src.getClass()); // Class<Enum> type
        }

        public Enum[] values() {
            return (Enum[]) EnumSet.allOf(src.getDeclaringClass()).toArray();
        }

        public String fqn() {
            return this.src.getClass().getName();
        }
    }

    public static class EnumTypeWrapper {

        private final Class<Enum> type;

        private EnumTypeWrapper(Class<Enum> aClass) {
            this.type = aClass;
        }

        public <A extends Annotation> A annotation(final Class<A> key) {
            return type.getAnnotation(key);
        }

        public Enum[] values() {
            return (Enum[]) EnumSet.allOf(type).toArray();
        }
    }

    public static EnumWrapper withEnum(final Enum enumX) {
        return new EnumWrapper(enumX);
    }

    public static EnumTypeWrapper withEnum(final Class<? extends Enum> enumType) {
        return new EnumTypeWrapper((Class<Enum>) enumType);
    }

}
