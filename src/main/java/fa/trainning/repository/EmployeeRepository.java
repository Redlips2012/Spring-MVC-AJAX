package fa.trainning.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fa.trainning.entity.Employee;

@Repository
public class EmployeeRepository {
	
	@Autowired
	SessionFactory sessionFactory;
	
	// add employee
	public void addEmployee(Employee emp) {
		Session session = sessionFactory.getCurrentSession();
		session.save(emp);
	}
	
	// get all employee
	public List<Employee> getAllEmp(){
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("FROM Employee", Employee.class).getResultList();
	}
	
	
	// get employee by id
	public Employee getEmpById(Long id) {
		Session session = sessionFactory.getCurrentSession();
		return session.find(Employee.class, id);
	}
	
	//update employee
	
	public void updateEmployee(Employee emp) {
		Session session = sessionFactory.getCurrentSession();
		session.update(emp);
	}
	
	// delete employee
	public void deleteEmployee(Employee emp) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(emp);
	}
	

}
