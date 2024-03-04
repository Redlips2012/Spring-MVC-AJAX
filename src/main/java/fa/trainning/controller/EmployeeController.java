package fa.trainning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fa.trainning.entity.Employee;
import fa.trainning.service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired 
	EmployeeService empService;
	
	@GetMapping("addEmployee")
	public String addEmp() {
		
		return "AddEmployee";
	}
	
	//save employee
	@PostMapping("insertEmployee")
	public String insertEmployee(@ModelAttribute("insertEmployee")Employee emp) {
		
		empService.addEmployee(emp);
		return "redirect:/employeeReport";
	}
	
	// to employee data
	@GetMapping("employeeReport")
	public String toEmployeeData(Model model) {
		model.addAttribute("employee", empService.getAllEmployee());
		model.addAttribute("title", "Employee Report");
		
		return "EmployeeReport";
	}

	// to edit employee
	@GetMapping("editEmployee")
	public String editEmployee(@RequestParam("id")Long id, Model model) {
		Employee emp = empService.findEmpById(id);
		model.addAttribute("employee", emp);
		model.addAttribute("title", "Edit employee");
		return "EditEmployee";
	}
	
	@PostMapping("updateEmployee")
	public String updateEmp(@ModelAttribute("updateEmployee")Employee emp) {
		empService.updateEmployee(emp);
		return "redirect:/employeeReport";
	}
	
	@GetMapping("deleteEmployee")
	public String deleteEmployee(@RequestParam("id")Long id) {
		empService.deleteEmployee(id);
		return "redirect:/employeeReport";
	}
	
}
