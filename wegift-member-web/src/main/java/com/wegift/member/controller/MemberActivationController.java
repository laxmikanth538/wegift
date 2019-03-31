package com.wegift.member.controller;

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
import org.springframework.web.bind.annotation.RequestParam;

import com.wegift.bo.OnlineUsersBo;
import com.wegift.member.command.MemberUpdateForm;
import com.wegift.member.validator.MemberActivationFormValidator;
import com.wegift.service.ManageMemberService;

@Controller
@RequestMapping("/activate-member.htm")
public class MemberActivationController {

	@Autowired
	ManageMemberService manageMemberService;

	@Autowired
	private MemberActivationFormValidator formValidator;

	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		webDataBinder.addValidators(formValidator);
	}

	@RequestMapping(method = RequestMethod.GET)
	public String showUpdateForm(Model model, @RequestParam("memberId") String memberId) {
		MemberUpdateForm updateForm = null;

		updateForm = new MemberUpdateForm();

		int onlineUserId = manageMemberService.getOnlineUserId(Integer.parseInt(memberId));

		System.out.println(onlineUserId);

		updateForm.setOnlineUserId(String.valueOf(onlineUserId));

		model.addAttribute("activateMember", updateForm);

		return "activate-member";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String activateMember(Model model, @Valid @ModelAttribute("activateMember") MemberUpdateForm updateForm,
			BindingResult errors) {
		OnlineUsersBo userBo = null;

		if (errors.hasErrors()) {
			return "activate-member";
		}

		userBo = new OnlineUsersBo();

		userBo.setUserName(updateForm.getUserName());
		userBo.setPassword(updateForm.getPassword());
		userBo.setOnlineUserId(Integer.parseInt(updateForm.getOnlineUserId()));

		manageMemberService.updateUserInfo(userBo);

		model.addAttribute("userName", updateForm.getUserName());

		return "member-activation-success";
	}

}
