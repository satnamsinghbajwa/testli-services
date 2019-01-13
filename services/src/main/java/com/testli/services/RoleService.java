package com.testli.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.testli.aop.Loggable;
import com.testli.data.model.Role;
import com.testli.data.repo.RoleRepository;

@Service
@Loggable
public class RoleService {

	@Autowired
	private RoleRepository roleRepository;

	public Role addRole(Role role) {
		return roleRepository.insert(role);
	}

	public Role updateRole(String id, Role role) {
		role.setId(id);
		return roleRepository.save(role);
	}

	public List<Role> getRole(String ids) {
		List<Role> roles = new ArrayList<>();
		if (ids != null) {
			List<String> items = Stream.of(ids.split("\\s*,\\s*")).map(element -> new String(element))
					.collect(Collectors.toList());
			Iterable<Role> findAllById = roleRepository.findAllById(items);
			for (Role role : findAllById) {
				roles.add(role);
			}
		}
		return roles;
	}

	public Role deleteRole(String id) {
		Optional<Role> optionalRole = roleRepository.findById(id);
		if (optionalRole.isPresent()) {
			Role role = optionalRole.get();
			roleRepository.delete(role);
			return role;
		}
		return null;
	}

}
