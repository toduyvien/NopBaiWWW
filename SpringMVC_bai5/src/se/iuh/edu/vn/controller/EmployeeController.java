package se.iuh.edu.vn.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

import se.iuh.edu.vn.beans.Employee;
import se.iuh.edu.vn.dao.EmployeeDAO;

@Controller
public class EmployeeController {
	@Autowired
	EmployeeDAO dao;
	
	@RequestMapping("/empform")
	public ModelAndView showForm() {
		return new ModelAndView("empform","command",new Employee());//template
	}
	@RequestMapping(value= "/save",method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("emp") Employee emp) {
		dao.save(emp);
		return new ModelAndView("redirect:/viewemp");//template
	}
	@RequestMapping("/viewemp")
	public ModelAndView viewemp() {
		return new ModelAndView("viewemp","list",dao.getAll());
	}
	@RequestMapping("/")
	public ModelAndView view() {
		return new ModelAndView("index");
	}
	@RequestMapping(value= "/editemp/{id}")
	public ModelAndView edit(@PathVariable("id") int id) {
		Employee emp = dao.getEmployeeByID(id);
		return new ModelAndView("empeditform","command",emp);//template
	}
	@RequestMapping(value= "/editsave",method = RequestMethod.POST)
	public ModelAndView editsave(@ModelAttribute("emp") Employee emp) {
		dao.update(emp);
		return new ModelAndView("redirect:/viewemp");//template
	}
	@RequestMapping(value= "/deleteemp/{id}")
	public ModelAndView delete(@PathVariable("id") int id) {
		dao.delete(id);
		return new ModelAndView("redirect:/viewemp");//template
	}
}
