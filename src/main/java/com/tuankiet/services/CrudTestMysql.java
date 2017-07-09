package com.tuankiet.services;

import org.springframework.data.repository.CrudRepository;

import com.tuankiet.model.TestMysqlObject;

public interface CrudTestMysql extends CrudRepository<TestMysqlObject, Long> {

}
