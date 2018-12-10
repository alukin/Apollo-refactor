/*
 * Copyright © 2018 Apollo Foundation
 */

package com.apollocurrency.aplwallet.apl;

import java.sql.SQLException;

import com.apollocurrency.aplwallet.apl.core.db.BasicDb;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import com.apollocurrency.aplwallet.apl.testutil.DbManipulator;

public class DbIntegrationTest {
    private static final DbManipulator manipulator = new DbManipulator();
    protected static final BasicDb db = manipulator.getDb();
    @BeforeClass
    public static void init() throws SQLException {
        manipulator.init();
    }
    @AfterClass
    public static void shutdown() throws Exception {
        manipulator.shutdown();
    }

    @Before
    public void setUp() throws Exception {
        manipulator.populate();
    }
}