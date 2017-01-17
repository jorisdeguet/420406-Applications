package org.deguet.persist;

import java.util.List;

/**
 * Created by joris on 15-03-20.
 */
public interface CRUD<T> {

    long save(T o);

    T getById(Long p);

    List<T> getAll();

    void deleteOne(Long o);

    void deleteAll();
}
