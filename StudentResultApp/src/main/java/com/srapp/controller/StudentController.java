package com.srapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.srapp.command.StudentCommand;
import com.srapp.dto.StudentDTO;
import com.srapp.service.StudentService;
import com.srapp.validator.StudentFormValidator;

@Controller
public class StudentController {
	@Autowired
	private StudentService service;
	@Autowired
	private StudentFormValidator validator;

	@RequestMapping(value = "/home.htm", method = RequestMethod.GET)
	public String showForm(Model model) {
		StudentCommand cmd = new StudentCommand();
		model.addAttribute("studentCommand", cmd);
		return "home";
	}

	@RequestMapping(value = "/home.htm", method = RequestMethod.POST)
	public String processForm(Model model, @ModelAttribute("studentCommand") StudentCommand cmd, BindingResult errors) {
		if (validator.supports(StudentCommand.class)) {

			validator.validate(cmd, errors);
			if (errors.hasErrors()) {
				return "home";
			}
		}
		StudentDTO dto = new StudentDTO();
		dto.setCity(cmd.getCity());
		dto.setLowerAge(cmd.getLowerAge());
		dto.setUpperAge(cmd.getUpperAge());

		List<StudentDTO> studentDTO = service.getTopScoreStudent(dto);
		model.addAttribute("student", studentDTO);
		return "result";
	}
}
