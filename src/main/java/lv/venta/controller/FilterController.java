package lv.venta.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import lv.venta.model.Course;
import lv.venta.model.Grade;
import lv.venta.model.Professor;
import lv.venta.model.enums.Degree;
import lv.venta.service.IFilterService;

@Controller
@RequestMapping("/filter")
public class FilterController {
	
	@Autowired
	private IFilterService filterService;
	
	@GetMapping("/professorByDegree/{inputdegree}")
	public String filterProfessorsByDegree(@PathVariable(name = "inputdegree") Degree degree, Model model) {
		try {
			ArrayList<Professor> professors = filterService.filterProfessorsByDegree(degree);
			model.addAttribute("package", professors);
			return "show-all-professors-page";
		} catch (Exception e) {
			model.addAttribute(e);
			return "error-page";
		}
	}
	
	@GetMapping("/course/professor/{id}")
	public String getCourseByProfessorId(@PathVariable(name = "id") long id, Model model) {
		try {
			ArrayList<Course> coursesFromDB = filterService.filterCoursesByProfessorId(id);
			model.addAttribute("package", coursesFromDB);
			return "show-all-courses-page";
		} catch (Exception e) {
			model.addAttribute(e);
			return "error-page";
		}
	}
	
	@GetMapping("/grade/student/{name}/{surname}")
	public String getGradesByStudentNameAndSurname(@PathVariable(name = "name") String name, @PathVariable(name = "surname") String surname, Model model) {
		try {
			ArrayList<Grade> grades = filterService.filterGradesByStudentNameAndSurname(name, surname);
			model.addAttribute(grades);
			return "show-all-grade-page";
		} catch (Exception e) {
			model.addAttribute(e);
			return "error-page";
		}
		
	}
}
