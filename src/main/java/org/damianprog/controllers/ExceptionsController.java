//package org.damianprog.controllers;
//
//import org.damianprog.entities.CannotFind;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.servlet.mvc.support.RedirectAttributes;
//
//@ControllerAdvice
//public class ExceptionsController {
//
//	@ExceptionHandler(CannotFind.class)
//	public String accessForbidden(Model theModel,RedirectAttributes ra) {
//		
//		ra.addAttribute("cannotFind",true);
//		
//		return "redirect:/weather/main";
//	}
//
//}
