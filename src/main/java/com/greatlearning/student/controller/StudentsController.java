 package com.greatlearning.student.controller;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greatlearning.student.entity.Student;
import com.greatlearning.student.service.StudentService;

@Controller
@RequestMapping("/students")
public class StudentsController {

	@Autowired
	private StudentService studentService;

	// add mapping for "/list"

	@RequestMapping("/list")
	public String listStudents(Model model) {

		// get Books from db
		List<Student> students = studentService.findAll();

		// add to the spring model
		model.addAttribute("Students", students);

		return "list-students";
	}

	@RequestMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {

		// create model attribute to bind form data
		Student student = new Student();

		model.addAttribute("Student", student);

		return "student-form";
	}

	@RequestMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("studentId") int id, Model model) {

		// get the Book from the service
		Student student = studentService.findById(id);
		// populate countries
		LinkedHashMap<String, String> countries = new LinkedHashMap<>();

		countries.put("Australia", "Australia");
		countries.put("Canada", "Canada");
		countries.put("India", "India");
		countries.put("USA", "USA");
		countries.put("Russia", "Russia");
		countries.put("New Zealand", "New Zealand");
		
		student.setCountries(countries);
		
		LinkedHashMap<String, String> departments = new LinkedHashMap<>();

		departments.put("M.Tech", "M.Tech");
		departments.put("B.Tech", "B.Tech");
		departments.put("M.Com",   "M.Com");
		departments.put("B.Com", "B.Com");
		departments.put("MBA", "MBA");
		departments.put("B.Arch", "B.Arch");
		
		student.setDepartments(departments);

		// set Book as a model attribute to pre-populate the form
		model.addAttribute("Student", student);

		// send over to our form
		return "student-form";
	}

	@PostMapping("/save")
	public String saveStudent(@RequestParam("id") int id, @RequestParam("name") String name,
			@RequestParam("department") String department, @RequestParam("country") String country) {

		System.out.println(id);
		Student student;
		if (id != 0) {
			student = studentService.findById(id);
			student.setName(name);
			student.setDepartment(department);
			student.setCountry(country);
		} else
			student = new Student(name,department,country);
		// save the Book
		studentService.save(student);

		// use a redirect to prevent duplicate submissions
		return "redirect:/students/list";

	}

	@RequestMapping("/delete")
	public String delete(@RequestParam("studentId") int id) {

		// delete the Book
		studentService.deleteById(id);

		// redirect to /Books/list
		return "redirect:/students/list";

	}

	@RequestMapping("/search")
	public String search(@RequestParam("name") String name, @RequestParam("department") String department, Model model) {

		// check names, if both are empty then just give list of all Books

		if (name.trim().isEmpty() && department.trim().isEmpty()) {
			return "redirect:/students/list";
		} else {
			// else, search by first name and last name
			List<Student> students = studentService.searchBy(name, department);

			// add to the spring model
			model.addAttribute("Students", students);

			// send to list-Books
			return "list-students";
		}

	}
}
