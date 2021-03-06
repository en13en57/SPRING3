package kr.green.boot.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import kr.green.boot.vo.EmployeeVO;
import lombok.extern.log4j.Log4j;

@Log4j
@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

	@Override
	public List<EmployeeVO> selectList() {
		log.debug("selectList 호출");
		List<EmployeeVO> list = new ArrayList<>();
		list.add(new EmployeeVO(1,"한사람"));
		list.add(new EmployeeVO(2,"두사람"));
		list.add(new EmployeeVO(3,"세사람"));
		list.add(new EmployeeVO(4,"네사람"));
		list.add(new EmployeeVO(5,"오사람"));
		return list;
	}

	@Override
	public EmployeeVO selectById(int employeeId) {
		log.debug("selectById 호출");
		return new EmployeeVO(employeeId,"뉴사람");
	}

	@Override
	public EmployeeVO selectByName(String employeeName) {
		log.debug("selectByName 호출");
		return new EmployeeVO(6, employeeName);
	}

	@Override
	public void insertEmployee(EmployeeVO employeeVO) {
		log.debug("insertEmployee 호출");
	}

	@Override
	public void updateEmployee(EmployeeVO employeeVO) {
		log.debug("updateEmployee 호출");
		
	}

	@Override
	public void deleteEmployee(EmployeeVO employeeVO) {
		log.debug("deleteEmployee 호출");
		
	}

	@Override
	public void deleteEmployee(int employeeId) throws Exception {
		throw new Exception("지정한 사번의 사원이 존재하지 않습니다.");
		
	}

}
