package kr.green.boot.app;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.green.boot.service.EmployeeService;
import kr.green.boot.vo.EmployeeVO;

public class AppMain3 {
	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("bean3.xml");
		
		EmployeeService employeeService = context.getBean(EmployeeService.class);
		
		EmployeeVO vo =  employeeService.selectById(1);
		System.out.println(vo);
		System.out.println("-".repeat(80));
		
		List<EmployeeVO> list = employeeService.selectList();
		System.out.println(list);
		System.out.println("-".repeat(80));
		
		employeeService.insertEmployee(null); // 적용제외
		
		context.close();
	}
}
