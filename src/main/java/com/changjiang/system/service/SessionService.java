package com.changjiang.system.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.changjiang.system.domain.UserOnline;

@Service
public interface SessionService {
	List<UserOnline> list();
}
