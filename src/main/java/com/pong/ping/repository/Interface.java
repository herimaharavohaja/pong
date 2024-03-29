package com.pong.ping.repository;

import java.util.List;

public interface Interface <T> {
    T findById(int toFind);

    List<T> findAll();

    List<T> saveAll(List<T> toSave);

    T save(T toSave);

}
