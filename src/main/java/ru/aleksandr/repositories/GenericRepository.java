package ru.aleksandr.repositories;

import java.util.List;
import java.util.Map;

public interface GenericRepository<T, KEY> {
    List<T> getAll();
    T getByKey(KEY key);
    void save(T t);
    void update(T t);
    void deleteByKey(KEY key);
}
