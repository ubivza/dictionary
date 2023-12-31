package ru.aleksandr.repositories;

import java.util.List;
import java.util.Map;

public interface GenericRepository<T, KEY> {
    Map<T, T> getAll();
    T getByKey(KEY key);
    boolean save(T t);
    boolean update(T t);
    boolean deleteByKey(KEY key);
}
