package org.deguet.persist;

import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.runner.RunWith;

/**
 * Created by joris on 15-04-15.
 */
public class TestRepoSQLite extends TestAbstract {


    @Override
    public CRUD<Product> getRepo() {
        return RepoSQLite.get(InstrumentationRegistry.getInstrumentation().getTargetContext(), "DataBaseTest", 2);
    }
}
