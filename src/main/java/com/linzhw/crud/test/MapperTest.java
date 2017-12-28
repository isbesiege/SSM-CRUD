package com.linzhw.crud.test;

import java.util.UUID;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.linzhw.crud.bean.Department;
import com.linzhw.crud.bean.Employee; 
import com.linzhw.crud.dao.DepartmentMapper;
import com.linzhw.crud.dao.EmployeeMapper;
 
/**
 * 测试dao层的工作
 * 推荐：Spring的项目就可以使用Spring的单元测试，可以自动注入我们需要的组件
 * 		1、导入SpringTest模块
 * 		2、@ContextConfiguration指定Spring配置文件的位置
 * 		3、直接autowired要使用的组件即可
 * @author linzhw
 * @creationTime 2017年12月19日下午8:04:40
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class MapperTest {
	
	@Autowired
	DepartmentMapper departmentMapper;
	
	@Autowired
	EmployeeMapper emploveeMapper;
	
	@Autowired
	SqlSession sqlSession;
	
	/**
	 * 测试DepartmentMapper
	 */
	@Test
	public void testCRUD(){
		/*//1、创建SpringIOC容器
		ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
		//2、从容器中获取mapper
		DepartmentMapper bean = ioc.getBean(DepartmentMapper.class);*/
		
		System.out.println(departmentMapper);
		
		//1、插入几个部门
//		departmentMapper.insertSelective(new Department(null, "研发部"));
//		departmentMapper.insertSelective(new Department(null, "事业部"));
	
		//2、生成员工数据，测试员工插入
		//employeeMapper.insertSelective(new Employee(null, "session", "F", "session@163.com", 2));
		
		//System.out.println("插入成功");

		//3、批量插入多个员工；批量，使用可以执行批量操作的sqlSession

		/*for () {
			employeeMapper.insertSelective(new Employee(null, "Jerry1", "F", "Jerry1@163.com", 2));
			
		}*/
		EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
		for(int i=0;i<10;i++){
			String uid = UUID.randomUUID().toString().substring(0, 5)+i;
			mapper.insertSelective(new Employee(null, uid, "M", uid+"@github.com", 4));
		}
		System.out.println("批量新增完成");
	}
}
