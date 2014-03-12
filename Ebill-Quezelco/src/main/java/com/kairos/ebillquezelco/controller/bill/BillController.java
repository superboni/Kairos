package com.kairos.ebillquezelco.controller.bill;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kairos.ebillquezelco.domain.bill.Bill;
import com.kairos.ebillquezelco.service.bill.BillService;

@Controller
public class BillController {

	@Autowired
	private BillService billService;
	
	private static final Logger logger = LoggerFactory.getLogger(BillController.class);
	private static final String BILL_ATTR = "bill";
	
	@RequestMapping(value="/bill/add", method=RequestMethod.GET)
	public String showInputBillPage(Model model) {
		logger.info("Displaying Add User Page");
		model.addAttribute(BILL_ATTR, new Bill());
		return "billing/inputBill";
	}
	
	@RequestMapping(value="/bill/add", method=RequestMethod.POST)
	public String addBill(@Valid @ModelAttribute(BILL_ATTR) Bill bill, 
									Errors error, Model model) {
		
		billService.create(bill);
		return "billing/inputBill";
	}
}
