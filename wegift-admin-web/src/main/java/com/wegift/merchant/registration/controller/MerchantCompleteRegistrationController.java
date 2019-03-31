package com.wegift.merchant.registration.controller;

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

import com.wegift.admin.validator.UpdateFormValidator;
import com.wegift.bo.OnlineUsersBo;
import com.wegift.command.MerchantUpdateForm;
import com.wegift.constants.WeGiftConstants;
import com.wegift.service.ManageMerchantService;
import com.wegift.util.MerchantRegUniqueForUpdate;

@Controller
@RequestMapping("/edit-mechant-form-for-complete-registration.htm")
public class MerchantCompleteRegistrationController {

	@Autowired
	ManageMerchantService manageService;

	@InitBinder
	public void initBinding(WebDataBinder binder) {
		binder.addValidators(new UpdateFormValidator());
	}

	@RequestMapping(method = RequestMethod.GET)
	public String showUpdateForm(Model model, @RequestParam("merchantUniqueReference") String merchantUniqueId)
			throws Exception {
		MerchantUpdateForm updateForm = null;
		MerchantRegUniqueForUpdate uniquePerformer = null;
		int merchantId = 0;

		updateForm = new MerchantUpdateForm();

		uniquePerformer = MerchantRegUniqueForUpdate.getInstance();

		if (uniquePerformer != null) {

			manageService.refresh();
			System.out.println("called");
			merchantId = uniquePerformer.getMerchantId(merchantUniqueId);
		}
		if (merchantId == 0) {
			return "expiry-link";
		}

		int onlineUserId = manageService.getOnlineUserId(merchantId);
		System.out.println(onlineUserId);

		if (onlineUserId == 0) {
			return "wrong-url-error-page";
		}

		System.out.println(onlineUserId);

		updateForm.setOnlineUserId(String.valueOf(onlineUserId));

		model.addAttribute("editMerchant", updateForm);

		return "edit-mechant-form-for-complete-registration";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String doCompleteOperation(Model model, @Valid @ModelAttribute("editMerchant") MerchantUpdateForm updateForm,
			BindingResult errors) {

		if (errors.hasErrors()) {
			return "edit-mechant-form-for-complete-registration";
		}

		OnlineUsersBo userBo = null;

		userBo = new OnlineUsersBo();

		userBo.setOnlineUserId(Integer.parseInt(updateForm.getOnlineUserId()));
		userBo.setUserName(updateForm.getUsername());
		userBo.setPassword(updateForm.getPassword());
		userBo.setStatus(WeGiftConstants.STATUS_ACTIVE);

		manageService.update(userBo);

		model.addAttribute("username", updateForm.getUsername());

		return "update-success";
	}

}
