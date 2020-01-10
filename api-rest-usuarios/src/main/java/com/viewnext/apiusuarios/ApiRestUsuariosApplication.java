package com.viewnext.apiusuarios;

import java.security.Principal;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
public class ApiRestUsuariosApplication {

	@RequestMapping("user")
	public Map<String, Object> user(Principal user){
		Map<String, Object>map = new LinkedHashMap<String, Object>();
		map.put("name", user.getName());
		map.put("roles", AuthorityUtils.authorityListToSet(((Authentication) user).getAuthorities()));
		return map;
	}
	public static void main(String[] args) {
		SpringApplication.run(ApiRestUsuariosApplication.class, args);
		System.out.println("SPRING ARRANCADO");
	}

}
