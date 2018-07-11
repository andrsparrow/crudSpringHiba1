package edu.luba.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.luba.model.Employee;
import edu.luba.service.EmployeeService;

@Controller
public class EmployeeController {

	private EmployeeService employeeService;

	public String listemployees(Model model) {
		model.addAttribute("employee", new Employee());
		model.addAttribute("employeeList", employeeService.listEmployees());
		return "employee";
	}

	@RequestMapping(value = "/employee/add", method = RequestMethod.POST)
	public String addEmployee(@ModelAttribute("employee") Employee employee) {

		if (employee.getEmployeeId() == null || employee.getEmployeeId() == 0) {
			employeeService.addEmployee(employee);
		} else {
			employeeService.updateEmployee(employee);
		}

		return "redirect:/employess";
	}

	@RequestMapping("/employee/remove/{id}")
	public String removeemployee(@PathVariable("id") int id) {
		employeeService.removeEmployee(id);
		return "redirect:/employees";
	}

	public String editemployee(@PathVariable("id") int id, Model model) {
		model.addAttribute("employee", employeeService.getEmployee(id));
		model.addAttribute("employeeList", employeeService.listEmployees());
		return "employee";
	}

}
