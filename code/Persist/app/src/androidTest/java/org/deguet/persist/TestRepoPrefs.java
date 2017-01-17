package org.deguet.persist;

import android.support.test.InstrumentationRegistry;

/**
 * Created by joris on 17-01-17.
 */

public class TestRepoPrefs extends TestAbstract {
    @Override
    public CRUD<Product> getRepo() {
        return RepoPrefs.get(InstrumentationRegistry.getInstrumentation().getTargetContext());
    }
}
