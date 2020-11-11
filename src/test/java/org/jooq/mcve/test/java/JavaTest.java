package org.jooq.mcve.test.java;

import org.jooq.DSLContext;
import org.jooq.impl.DSL;
import org.jooq.mcve.java.tables.records.TestRecord;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;

import static org.jooq.mcve.java.Tables.TEST;
import static org.junit.Assert.assertEquals;

public class JavaTest {

    Connection connection;
    DSLContext ctx;

    @Before
    public void setup() throws Exception {
        connection = DriverManager.getConnection("jdbc:h2:~/mcve", "sa", "");
        ctx = DSL.using(connection);
    }

    @After
    public void after() throws Exception {
        ctx = null;
        connection.close();
        connection = null;
    }

    @Test
    public void mcveTest() {
        TestRecord result =
        ctx.insertInto(TEST)
           .columns(TEST.VALUE)
           .values(42)
           .returning(TEST.ID)
           .fetchOne();

        result.refresh();
        assertEquals(42, (int) result.getValue());
    }
}
