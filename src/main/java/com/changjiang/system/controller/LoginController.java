package com.changjiang.system.controller;

import com.changjiang.common.annotation.Log;
import com.changjiang.common.controller.BaseController;
import com.changjiang.common.domain.Tree;
import com.changjiang.common.utils.MD5Utils;
import com.changjiang.common.utils.R;
import com.changjiang.system.domain.MenuDO;
import com.changjiang.system.service.MenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@Slf4j
public class LoginController extends BaseController {

	@Autowired
	MenuService menuService;

	@GetMapping({ "/", "" })
	String welcome(Model model) {
		return "redirect:/blog";
	}

	@Log("请求访问主页")
	@GetMapping("/index")
	String index(Model model) {
		List<Tree<MenuDO>> menus = menuService.listMenuTree(1L);
		model.addAttribute("menus", menus);
		model.addAttribute("name", "");
		log.info("主页");
		return "index_v1";
	}

	@RequestMapping("/login")
	String login(String error) {
		return "login";
	}

	@GetMapping("/main")
	String main() {
		return "main";
	}

}
