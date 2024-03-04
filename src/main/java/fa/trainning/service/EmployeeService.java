package fa.trainning.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fa.trainning.entity.Employee;
import fa.trainning.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository repository;
	
	
	// add employee
	@Transactional
	public void addEmployee(Employee emp) {
		repository.addEmployee(emp);
	}
	
	// get all employee
	@Transactional
	public List<Employee> getAllEmployee(){
		return repository.getAllEmp();
	}
	
	// find employee by id
	@Transactional
	public Employee findEmpById(Long id) {
		return repository.getEmpById(id);
	}
	
	// update employee
	@Transactional
	public void updateEmployee(Employee emp) {
		repository.updateEmployee(emp);
	}
	
	// delete employee
	@Transactional
	public void deleteEmployee(Long id) {
		Employee emp = findEmpById(id);
		if (emp != null) {
			repository.deleteEmployee(emp);
		}
	}
}
