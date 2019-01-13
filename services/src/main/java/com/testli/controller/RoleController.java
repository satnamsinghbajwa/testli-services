package com.testli.controller;

import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.testli.aop.Loggable;
import com.testli.data.model.Role;
import com.testli.services.RoleService;

@RestController
@Loggable
public class RoleController {

	@Autowired
	private RoleService roleService;

	@RequestMapping(value = "/roles", method = POST, headers = { "Accept=application/json" })
	public Role addRole(@RequestBody Role role) {
		return roleService.addRole(role);
	}

	@RequestMapping(value = "/roles/{id}", method = PUT, headers = { "Accept=application/json" })
	public Role updateRole(@PathVariable("id") String id, @RequestBody Role role) {
		return roleService.updateRole(id, role);
	}

	@RequestMapping(value = "/roles/{id}", method = GET, headers = { "Accept=application/json" })
	public List<Role> getRole(@PathVariable("id") String id) {
		return roleService.getRole(id);
	}

	@RequestMapping(value = "/roles/{id}", method = DELETE, headers = { "Accept=application/json" })
	public void deleteRole(@PathVariable("id") String id) {
		roleService.deleteRole(id);
	}

}
