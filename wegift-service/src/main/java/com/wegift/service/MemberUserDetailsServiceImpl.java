package com.wegift.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.wegift.bo.UserCredBo;
import com.wegift.dao.MemberDao;
import com.wegift.dto.UserDetailsImpl;

@Service
@EnableTransactionManagement(proxyTargetClass = true)
public class MemberUserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	MemberDao memberdao;

	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserCredBo usercred = null;
		UserDetailsImpl userdetailsimpl = null;

		usercred = memberdao.findUserByUsername(username);
		userdetailsimpl = new UserDetailsImpl(usercred.getUsername(), usercred.getPassword(), usercred.getRole());
		return userdetailsimpl;
	}
}
