package fa.trainning.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import fa.trainning.entity.Student;
import fa.trainning.service.StudentService;

@Controller
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	@GetMapping("studentReport")
	public String studentReport() {
		return "StudentReport";
	}
	
	@PostMapping("insertStudent")
	@ResponseBody
	public String saveStudent(@ModelAttribute("insertStudent")Student student) {
		studentService.saveStudent(student);
		
		return "saveStudent";
	}
	
	@GetMapping("getAllStudent")
	public @ResponseBody List<Student> getAllStudent(){
		
		List<Student> list = studentService.getAllStudent();
		return list;
	}
	
	@GetMapping("getOneStudent")
	@ResponseBody
	public Student getById(@RequestParam long id) {
	 	 return studentService.findStudentById(id);
	}
	
	@PostMapping("updateStudent")
	@ResponseBody
	public String updateStudent(@ModelAttribute("updateStudent") Student std) {
		studentService.updateStudent(std);
		return "updateStudent";
	}
	
	@GetMapping("deleteStudent")
	@ResponseBody
	public String deleteStudent(@RequestParam long id) {
		studentService.deleteStudent(id);
		return "deleteStudent";
	}
	

}
