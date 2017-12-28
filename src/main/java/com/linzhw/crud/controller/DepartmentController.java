package com.linzhw.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.linzhw.crud.bean.Department;
import com.linzhw.crud.bean.Msg;
import com.linzhw.crud.service.DepartmentService;

/**
 * 处理和部门有关的请求
 * @author linzhw
 * @creationTime 2017年12月24日下午8:44:27
 */
@Controller
public class DepartmentController {
	
	@Autowired
	private DepartmentService departmentService;
	
	/**
	 * 返回所有的部门信息
	 */
	@RequestMapping("/depts")
	@ResponseBody
	public Msg getDepts(){
		//查出的所有部门信息
		List<Department> list = departmentService.getDepts();
		return Msg.success().add("depts", list);
	}
}
