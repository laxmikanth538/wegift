package com.wegift.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.wegift.bo.UserCredBo;
import com.wegift.dao.MerchantDao;
import com.wegift.dto.UserDetailsImpl;

@Service
@EnableTransactionManagement(proxyTargetClass = true)
public class MerchantUserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	MerchantDao merchantdao;

	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserCredBo usercred = null;
		UserDetailsImpl userdetailsimpl = null;

		usercred = merchantdao.findUserByUsername(username);
		if(usercred != null)
			userdetailsimpl = new UserDetailsImpl(usercred.getUsername(), usercred.getPassword(), usercred.getRole());
		else
			throw new UsernameNotFoundException("user not found");
		return userdetailsimpl;
	}
	
	
}
