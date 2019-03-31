package com.wegift.member.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.wegift.bo.AddressBo;
import com.wegift.bo.CardBo;
import com.wegift.bo.MemberBo;
import com.wegift.constants.WeGiftConstants;
import com.wegift.member.command.MemberCommand;
import com.wegift.member.validator.MemberCommandValidator;
import com.wegift.service.ManageMemberService;

@Controller
@EnableWebMvc

   public class MemberRegistrationController {

	@Autowired
	private ManageMemberService manageMemberService;

	@Autowired
	private MemberCommandValidator memberCommandValidator;

	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		webDataBinder.addValidators(memberCommandValidator);
	}

	@RequestMapping(path = "/member-reg.htm", method = RequestMethod.GET)
	public String showMemberRegistrationForm(Model model, HttpServletRequest request) {

		MemberCommand membercommand = null;

		membercommand = new MemberCommand();

		WeGiftConstants.WEGIFT_SERVER_HOST = request.getRemoteAddr();
		WeGiftConstants.WEGIFT_SERVER_PORT = request.getLocalPort();
		WeGiftConstants.WEGIFT_CONTEXT_ROOT = request.getContextPath();

		model.addAttribute("member", membercommand);
		
		 /*Authentication auth = SecurityContextHolder.getContext()
                 .getAuthentication();*/
		
		return "member-reg";
	}

	@RequestMapping(path = "/member-reg.htm", method = RequestMethod.POST)
	public String registrationMember(Model model, @Valid @ModelAttribute("member") MemberCommand memberCommand,
			BindingResult errors) {

		if (errors.hasErrors()) {
			return "member-reg";
		}

		MemberBo memberBo = null;
		AddressBo addressBo = null;
		CardBo cardbo = null;

		memberBo = new MemberBo();
		memberBo.setFirstName(memberCommand.getFirstName());
		memberBo.setLastName(memberCommand.getLastName());
		memberBo.setGender(memberCommand.getGender());
		memberBo.setDob(memberCommand.getDob());
		memberBo.setMobile(memberCommand.getMobile());
		memberBo.setEmail(memberCommand.getEmail());

		addressBo = new AddressBo();
		addressBo.setAddressLine1(memberCommand.getAddressLine1());
		addressBo.setAddressLine2(memberCommand.getAddressLine2());
		addressBo.setCity(memberCommand.getCity());
		addressBo.setState(memberCommand.getState());
		addressBo.setZip(Integer.parseInt(memberCommand.getZip()));
		addressBo.setCountry(memberCommand.getCountry());

		memberBo.setAddressBo(addressBo);
		memberBo.setCardBo(cardbo);

		int memberId = manageMemberService.saveMember(memberBo);

		model.addAttribute("memberId", memberId);
		model.addAttribute("email", memberBo.getEmail());

		return "member-reg-success";
	}

	@ModelAttribute("cities")
	public List<String> getCities(Model model) {
		List<String> cities = null;
		cities = manageMemberService.getCities();
		return cities;
	}

	@ModelAttribute("states")
	public List<String> getStates() {
		List<String> states = null;
		states = manageMemberService.getStates();
		return states;
	}
}
