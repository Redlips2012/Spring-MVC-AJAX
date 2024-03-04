package fa.trainning.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fa.trainning.entity.Student;
import fa.trainning.repository.StudentRepository;

@Service
public class StudentService {
	
	
	@Autowired
	StudentRepository repository;

	@Transactional
	public void saveStudent(Student student) {
		repository.saveStudent(student);
	}
	@Transactional
	public List<Student> getAllStudent(){
		return repository.getAllStudent();
	}
	@Transactional
	public Student findStudentById(long id) {
		return repository.getStudentById(id);
	}
	@Transactional
	public void updateStudent(Student student) {
		repository.updateStudent(student);
	}
	@Transactional
	public void deleteStudent(long id) {
		Student st = findStudentById(id);
		if (st !=null) {
			repository.deleteStudent(st);
		}
	}
}
