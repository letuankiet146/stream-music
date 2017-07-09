package com.tuankiet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tuankiet.model.TestMysqlObject;
import com.tuankiet.services.CrudTestMysql;

@Controller
@RequestMapping("/test")
public class TestMysqlController {
	@Autowired
	CrudTestMysql crudMethod;
	
	@RequestMapping("/save")
	public @ResponseBody String save(@RequestParam String name, @RequestParam String email){
		crudMethod.save(new TestMysqlObject(name, email));
		return "save is good";
	}
	
	@RequestMapping("/findAll")
	public @ResponseBody Iterable<TestMysqlObject> findAll(){
		return crudMethod.findAll();
	}
}
