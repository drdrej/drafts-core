package com.touchableheroes.drafts.core.core;

import com.touchableheroes.drafts.core.obj.Structure;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by asiebert on 28.04.2017.
 */

public class StructureTest {

    @Test
    public void testInit() {
        final Structure<ExampleEnum> obj = new Structure<>(ExampleEnum.class);

        // empty values
        Object val = obj.get(ExampleEnum.ENTRY_INT);
        assertNull( val );
    }

    @Test
    public void testModify() {
        final Structure<ExampleEnum> obj = new Structure<>(ExampleEnum.class);

        final Object originalVal = (Integer) 2;
        obj.modify(ExampleEnum.ENTRY_INT, originalVal);

        final Object val = obj.get(ExampleEnum.ENTRY_INT);
        assertNotNull( val );
        assertEquals( val, originalVal );
    }

}
