package com.changjiang.system.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.changjiang.common.utils.R;
import com.changjiang.system.domain.UserOnline;

@RequestMapping("/sys/online")
@Controller
public class SessionController {

	@GetMapping()
	public String online() {
		return "system/online/online";
	}



	@RequestMapping("/sys/online/forceLogout/{sessionId}")
	public R forceLogout(@PathVariable("sessionId") String sessionId, RedirectAttributes redirectAttributes) {
		return R.error();
	}
}
