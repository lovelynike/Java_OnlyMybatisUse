package com.hs.myapp;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	DummyDAO dao;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 * @throws Exception 
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) throws Exception {
		int result1 = dao.selectTest();
		DummyDTO result2 = dao.selectTest2(5);
		DummyDTO result3 = dao.selectTest3(2, "content");
		List<DummyDTO> result4 = dao.selectTest4();	
		
		
		model.addAttribute("result1", result1);
		model.addAttribute("result2", result2);
		model.addAttribute("result3", result3);
		model.addAttribute("result4", result4);		
		
		return "home";
	}
	
	@RequestMapping("delete")
	public String delete(String idx) {
		dao.delete(idx); //delete는 직접 만든 메서드
		return "redirect:/";
	}
	
	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public String insert(String content) {
		dao.insert(content); //insert는 직접만든 메서드
		return "redirect:/";
	}
	
}
