package com.touchableheroes.drafts.core.obj;

import java.io.Serializable;
import java.util.EnumSet;

/**
 * Created by asiebert on 26.04.2017
 * .
 */

public class Structure<K extends Enum>
        implements GetterByEnum<K>,
                   Serializable {

    private final Object[] values;

    public Structure( final Class<K> keyType,
                      final Object... values ) {
        final EnumSet fields = (EnumSet) EnumSet.allOf(keyType);

        final int maxSize = fields.size();
        this.values = new Object[maxSize];

        if( values.length > 0 ) {
            System.arraycopy(values, 0, this.values, 0, maxSize);
        }
    }

    public void modify( final K key, final Object value) {
        values[ key.ordinal() ] = value;
    }

    @Override
    public <V> V get(final K key) {
        return (V) values[ key.ordinal() ];
    }

    @Override
    public <V> V get(final K key, final Class<V> asType) {
        throw new UnsupportedOperationException();
    }

}
