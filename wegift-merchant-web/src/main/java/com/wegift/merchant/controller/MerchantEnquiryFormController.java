package com.wegift.merchant.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wegift.bo.MerchantEnquiryBo;
import com.wegift.merchant.enquiry.form.MerchantEnquiryForm;
import com.wegift.merchant.enquiry.validator.MerchantEnquiryFormValidator;
import com.wegift.service.ManageMerchantService;

@Controller
@RequestMapping("/merchant-enquiry.htm")
public class MerchantEnquiryFormController {

	@Autowired
	private MerchantEnquiryFormValidator merchantEnquiryFormValidator;
	@Autowired
	private ManageMerchantService merchantManagementService;

	  @InitBinder 
	  public void initBinder(WebDataBinder webDataBinder) {
		  webDataBinder.addValidators(merchantEnquiryFormValidator); 
	  }
	 

	@RequestMapping(method = RequestMethod.GET)
	public String showMerchantEnquiryForm(Model model) {
		MerchantEnquiryForm enquiryForm = null;
		enquiryForm = new MerchantEnquiryForm();
		model.addAttribute("enquiryForm", enquiryForm);
		return "merchant-enquiry";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String doEnquire(Model model,@Valid @ModelAttribute("enquiryForm") MerchantEnquiryForm enquiryForm,
			BindingResult errors) {
		MerchantEnquiryBo enquiryBo = null;
		if (errors.hasErrors()) {
			return "merchant-enquiry";
		}
		enquiryBo = new MerchantEnquiryBo();
		enquiryBo.setOrganizationName(enquiryForm.getOrgName());
		enquiryBo.setBusinessType(enquiryForm.getBusinessType());
		enquiryBo.setYearOfEstd(enquiryForm.getYearOfEstd());
		enquiryBo.setMerchantLocation(enquiryForm.getMerchantLocation());
		enquiryBo.setContactPerson(enquiryForm.getContactPerson());
		enquiryBo.setContactNo(enquiryForm.getContactNo());
		enquiryBo.setContactEmail(enquiryForm.getContactEmail());
		enquiryBo.setDescription(enquiryForm.getDescription());

		int enqRefNo = merchantManagementService.doMerchantEnquiry(enquiryBo);
		model.addAttribute("enqRefNo", enqRefNo);
		System.out.println(enqRefNo);
		return "enquiry-success";
	}
}
