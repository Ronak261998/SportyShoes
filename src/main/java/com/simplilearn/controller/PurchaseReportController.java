package com.simplilearn.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.simplilearn.entity.purchases;
import com.simplilearn.repository.PurchaseReportRepository;

@Controller
public class PurchaseReportController {

	@Autowired
	private PurchaseReportRepository purchaseRepo;
	
	@GetMapping("/purchaseReport")
	public ModelAndView getPurchaseReport() {
		ModelAndView mav = new ModelAndView("PurchaseReport");
		List<purchases> report = purchaseRepo.findAll();
		mav.addObject("report", report);
		return mav;
	}

	@RequestMapping(path = {"/search"})
	 public String getReport(purchases Report, Model model, String keyword) {
	  if(keyword!=null) {
	   List<purchases> reportByKeyword = purchaseRepo.findByKeyword(keyword);
	   model.addAttribute("report", reportByKeyword);
	  }else {
	  List<purchases> report = purchaseRepo.findAll();
	  model.addAttribute("report", report);}
	  return "PurchaseReport";
	 }
}
