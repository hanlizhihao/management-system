package com.changjiang.common.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import com.changjiang.system.domain.UserDO;
import org.apache.shiro.web.subject.WebSubject;

import java.lang.reflect.Field;
import java.util.stream.Stream;

@Slf4j
public class ShiroUtils {
	public static Subject getSubject() {
		return SecurityUtils.getSubject();
	}
	public static UserDO getUser() {
		UserDO userDO = new UserDO();
		WebSubject webSubject = (WebSubject) getSubject();
		Class<?> principalClass = webSubject.getPrincipal().getClass();
		Class<? extends UserDO> userDOClass = userDO.getClass();
		Object principal = webSubject.getPrincipal();
		Field[] allField = userDOClass.getDeclaredFields();

		Stream.of(allField).parallel().forEach(field -> {
			if (!field.getName().equals("serialVersionUID")) {
				field.setAccessible(true);
				String fieldName = field.getName();
				try {
					Field fieldPrincipal = principalClass.getDeclaredField(fieldName);
					fieldPrincipal.setAccessible(true);
					field.set(userDO, fieldPrincipal.get(principal));
				} catch (IllegalAccessException | NoSuchFieldException e) {
					log.error("ShiroUtils获取当前登录用户",e);
				}
			}
		});
		return userDO;
	}
	public static Long getUserId() {
		return getUser().getUserId();
	}
	public static void logout() {
		getSubject().logout();
	}
}
