package com.wegift.merchant.registration.controller;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.wegift.admin.validator.MerchantCommandValidator;
import com.wegift.bo.AddressBo;
import com.wegift.bo.MerchantBo;
import com.wegift.command.MerchantCommand;
import com.wegift.constants.WeGiftConstants;
import com.wegift.service.ManageMerchantService;

@Controller
@EnableWebMvc
public class MerchantRegistrationController {

	@Autowired
	ManageMerchantService service;

	@Autowired
	MessageSource ms;
	
	@Autowired
	MerchantCommandValidator merchantCommandValidator;

	@RequestMapping(path = "/merchant-reg.htm", method = RequestMethod.GET)
	public String renderSource(Model model, HttpServletRequest request) {

		MerchantCommand merchant = null;

		merchant = new MerchantCommand();

		model.addAttribute("merchant", merchant);

		WeGiftConstants.WEGIFT_SERVER_HOST = request.getRemoteHost();
		WeGiftConstants.WEGIFT_SERVER_PORT = request.getLocalPort();
		WeGiftConstants.WEGIFT_CONTEXT_ROOT = request.getContextPath();

		return "merchant-reg";

	}

	@RequestMapping(path = "/merchant-reg.htm", method = RequestMethod.POST)
	public String doRegister(Model model, @ModelAttribute("merchant") MerchantCommand merchant, BindingResult errors)
			throws IOException {

		if (merchantCommandValidator.supports(merchant.getClass()) == true) {
			merchantCommandValidator.validate(merchant, errors);
			if (errors.hasErrors()) {
				return "merchant-reg";
			}
		}

		MerchantBo merchantBo = null;
		AddressBo addressBo = null;
		Set<AddressBo> addresses = null;

		merchantBo = new MerchantBo();

		merchantBo.setFirstName(merchant.getFirstName());
		merchantBo.setLastName(merchant.getLastName());
		merchantBo.setPrimaryContactNo(merchant.getPrimaryContactNo());
		merchantBo.setAlternateContactNo(merchant.getAlternateContactNo());
		merchantBo.setPrimaryEmailAddress(merchant.getPrimaryEmailAddress());
		merchantBo.setAlternateEmailAddress(merchant.getAlternateEmailAddress());
		merchantBo.setDescription(merchant.getDescription());
		merchantBo.setMerchantLogoFileBytes(merchant.getMerchantLogo().getBytes());
		merchantBo.setMerchantLogoFileName(merchant.getMerchantLogo().getOriginalFilename());
		merchantBo.setMerchantLogoFileType(merchant.getMerchantLogo().getContentType());

		addressBo = new AddressBo();
		addressBo.setAddressLine1(merchant.getAddressLine1());
		addressBo.setAddressLine2(merchant.getAddressLine2());
		addressBo.setCity(merchant.getCity());
		addressBo.setState(merchant.getState());
		addressBo.setZip(merchant.getZip());
		addressBo.setCountry(merchant.getCountry());

		addresses = new HashSet<AddressBo>();

		addresses.add(addressBo);

		merchantBo.setAddresses(addresses);

		int merchantId = service.saveMerchant(merchantBo);

		model.addAttribute("merchantId", merchantId);
		model.addAttribute("primaryEmailAddress", merchant.getPrimaryEmailAddress());

		return "merchant-reg-success";
	}

	@ModelAttribute("cities")
	public List<String> getCities(Model model) {
		List<String> citites = null;

		citites = service.getCities();
		return citites;
	}

	@ModelAttribute("states")
	public List<String> getStates() {
		return service.getStates();
	}

	@RequestMapping("/checkMail.htm")
	@ResponseBody
	public String checkMail(@RequestParam String primaryEmailAddress) {
		System.out.println("check mail method from controller with Email : " + primaryEmailAddress);
		boolean availability = service.mailCheckInMerchantDB(primaryEmailAddress);
		if (availability == true) {
			return "Mail Already existed";
		}
		return null;
	}
}
