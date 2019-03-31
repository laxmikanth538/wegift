package com.wegift.merchant.registration.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.wegift.dto.MerchantEnquiryDto;
import com.wegift.dto.SpecificMerchantEnquiryDto;
import com.wegift.service.ManageMerchantService;

@Controller
@EnableWebMvc
public class MerchantEnquiriesController {

	@Autowired
	ManageMerchantService merchantService;

	@RequestMapping("/enquiries.htm")
	public String showEnquiries(Model model, @RequestParam("status") String status,
			@RequestParam("pageNo") int pageNo) {
		int pageSize = 6;
		int size = 0;
		List<MerchantEnquiryDto> enquiries = merchantService.findMerchantEnquiries(status, pageNo, pageSize);
		size = merchantService.findCountOfEnquiries(status);
		model.addAttribute("enquiries", enquiries);
		model.addAttribute("status", status);
		model.addAttribute("size", size);
		return "enquiries";
	}

	@RequestMapping("/specific-merchant-enquiry.htm")
	public String showSpecificEnquiry(Model model, @RequestParam("orgName") String orgName) {
		SpecificMerchantEnquiryDto enquiry = merchantService.getSpecificEnquiry(orgName);
		model.addAttribute("enquiry", enquiry);
		return "specific-enquiry";
	}

	@RequestMapping("/enquiry-status-update.htm")
	public String updateEnquiryStatus(Model model, @RequestParam("update") String update,
			@RequestParam("enquiryId") int enquiryId) {
		merchantService.updateMerchantEnquiryStatus(enquiryId, update);
		if (update.equalsIgnoreCase("A")) {
			model.addAttribute("statusUpdate", "Enquiry is Approved Successfully with EnquiryId : " + enquiryId);
		} else if (update.equalsIgnoreCase("R")) {
			model.addAttribute("statusUpdate", "Enquiry Rejected with EnquiryId : " + enquiryId);
		}

		return "enquiry-status-update";
	}
}
