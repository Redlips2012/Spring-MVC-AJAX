package fa.trainning.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fa.trainning.entity.Student;

@Repository
public class StudentRepository {
	
	
	@Autowired
	SessionFactory sessionFactory;
	
	public void saveStudent(Student student) {
		Session session = sessionFactory.getCurrentSession();
		session.save(student);
	}
	
	public List<Student> getAllStudent(){
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("FROM Student", Student.class).getResultList();
	}
	
	public Student getStudentById(long id) {
		Session session = sessionFactory.getCurrentSession();
		return session.find(Student.class, id);
	}
	
	public void updateStudent(Student student) {
		Session session = sessionFactory.getCurrentSession();
		session.update(student);
	}
	
	public void deleteStudent(Student student) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(student);
	}

}
