package kr.ac.hansung.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.ac.hansung.dao.EnrolmentDAO;
import kr.ac.hansung.model.Subject;
import kr.ac.hansung.service.SubjectService;

@Controller
public class SubjectController {

	@Autowired
	private SubjectService subjectService;
	@Autowired
	private EnrolmentDAO enrolmentService;

	@RequestMapping("/subject_by_semester")
	public String showSubjectBySemester(Model model) {
		List<Subject> subjects = subjectService.getSubjectsBySemester();
		model.addAttribute("subjects", subjects);

		return "subject_by_semester";
	}

	@RequestMapping("/enrolment")
	public String doEnrolment(Model model) {
		model.addAttribute("subject", new Subject());
		return "enrolment";
	}

	@RequestMapping("/show_by_enrolment")
	public String showEnrolment(@RequestParam("year") String year,@RequestParam(value = "semester") String semester, Model model) {

		List<Subject> subjects = enrolmentService.getSubjects(Integer.parseInt(year), Integer.parseInt(semester));

		model.addAttribute("subjects", subjects);
		return "show_by_enrolment";
	}

	@RequestMapping("/createsubject")
	public String doCreateSubject(Model model, @Valid Subject subject, BindingResult result) {

		if (result.hasErrors()) {
			System.out.println("===Form data does not validated");
			List<ObjectError> errors = result.getAllErrors();
			for (ObjectError error : errors) {
				System.out.println(error.getDefaultMessage());
			}
			return "enrolment";
		}

		enrolmentService.insert(subject);
		model.addAttribute("success", new Subject());
		return "home";
	}

	@RequestMapping("/subjectInfo")
	public String showSubjects(Model model, @RequestParam(value = "year") String year,
			@RequestParam(value = "semester") String semester) {

		List<Subject> subjects = subjectService.getSubjects(Integer.parseInt(year), Integer.parseInt(semester));
		model.addAttribute("subjects", subjects);

		return "subjectInfo";
	}
}
