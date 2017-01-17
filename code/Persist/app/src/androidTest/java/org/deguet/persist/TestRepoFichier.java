package org.deguet.persist;

import android.support.test.InstrumentationRegistry;

/**
 * Created by joris on 17-01-17.
 */

public class TestRepoFichier extends TestAbstract {
    @Override
    public CRUD<Product> getRepo() {
        return new RepoFichier(InstrumentationRegistry.getInstrumentation().getTargetContext());
    }
}
