package com.changjiang.system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.changjiang.common.annotation.Log;
import com.changjiang.common.controller.BaseController;
import com.changjiang.common.utils.R;
import com.changjiang.system.domain.RoleDO;
import com.changjiang.system.service.RoleTestService;

@RequestMapping("/sys/role")
@Controller
public class RoleTestController extends BaseController {
	String prefix = "system/role";
	@Autowired
	RoleTestService roleTestService;

	  
	@GetMapping()
	String role() {
		return prefix + "/role";
	}

	@GetMapping("/list")
	@ResponseBody()
	List<RoleDO> list() {
		List<RoleDO> roles = roleTestService.list();
		return roles;
	}

	@Log("添加角色")
	@GetMapping("/add")
	String add() {
		return prefix + "/add";
	}

	@Log("编辑角色")
	@GetMapping("/edit/{id}")
	String edit(@PathVariable("id") Long id, Model model) {
		RoleDO roleDO = roleTestService.get(id);
		model.addAttribute("role", roleDO);
		return prefix + "/edit";
	}

	@Log("保存角色")
	@PostMapping("/save")
	@ResponseBody()
	R save(RoleDO role) {
  
		if (roleTestService.save(role) > 0) {
			return R.ok();
		} else {
			return R.error(1, "保存失败");
		}
	}

	@Log("更新角色")
	@PostMapping("/update")
	@ResponseBody()
	R update(RoleDO role) {
  
		if (roleTestService.update(role) > 0) {
			return R.ok();
		} else {
			return R.error(1, "保存失败");
		}
	}

	@Log("删除角色")
	@PostMapping("/remove")
	@ResponseBody()
	R save(Long id) {
  
		if (roleTestService.remove(id) > 0) {
			return R.ok();
		} else {
			return R.error(1, "删除失败");
		}
	}
	
	@Log("批量删除角色")
	@PostMapping("/batchRemove")
	@ResponseBody
	R batchRemove(@RequestParam("ids[]") Long[] ids) {
  
		int r = roleTestService.batchremove(ids);
		if (r > 0) {
			return R.ok();
		}
		return R.error();
	}
}
