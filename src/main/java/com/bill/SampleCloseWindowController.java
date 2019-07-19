package com.bill;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class SampleCloseWindowController {
	
	/**
	 * 打开主窗口
	 */
	@GetMapping("/")
	public ModelAndView home(HttpSession session) {
		return new ModelAndView("main");
	}
	
	/**
	 * 打开子窗口
	 */
	@GetMapping("/sub")
	public ModelAndView sub(HttpSession session) {
		session.setAttribute("closeFlag", "0");
		return new ModelAndView("sub");
	}
	
	/**
	 * ajax设置closeFlag
	 */
	@PostMapping("/ajaxSetCloseFlag")
	public void ajaxSetCloseFlag(HttpSession session) {
		System.out.println("ajaxSetCloseFlag()");
		session.setAttribute("closeFlag", "1");
	}
	
	/**
	 * ajax读取closeFlag
	 */
	@PostMapping("/ajaxGetCloseFlag")
	public String ajaxGetCloseFlag(HttpSession session) {
		System.out.println("ajaxGetCloseFlag()");
		String mainCloseFlag = (String) session.getAttribute("closeFlag");
		
		return mainCloseFlag;
	}
}
