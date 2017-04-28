package com.touchableheroes.drafts.core.obj;

/**
 * Created by asiebert on 26.04.2017.
 */

public interface GetterByEnum<K extends Enum> {

    public <V> V get( K key );

    public <V> V get(final K key, final Class<V> asType);

}
