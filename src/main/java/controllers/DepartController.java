package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import models.Depart;

@Controller
@RequestMapping ( "/departs")
public class DepartController {
	@GetMapping("/add")
	public String add(Model model) {
		model.addAttribute("depart" , new Depart());
		return "departs/addOrEdit";
	}

	@PostMapping("/saveOrUpdate")
	public String saveOrUpdate(Depart depart) {
		return " departs/addOrEdit";
	}
	@GetMapping( "/edit/{id}")
	public String edit(@PathVariable(name = "id") Integer id ) { 
		return " departs/addOrEdit";
	}
	
	@RequestMapping( "/delete")
	public String delete(@PathVariable ( name = "id") Integer idInteger ) { 
		return "list" ; 
	}
	
	@RequestMapping("/list")
	 public String list() { 
		 return "departs/list";
	 }
	@RequestMapping("/find")
	public String find() { 
		return "departs/find";
	}
	

}
