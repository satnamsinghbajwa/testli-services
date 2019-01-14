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
import com.testli.data.model.Membership;
import com.testli.services.MembershipService;

@RestController
@Loggable
public class MembershipController {

	@Autowired
	private MembershipService membershipService;

	@RequestMapping(value = "/memberships", method = POST, headers = { "Accept=application/json" })
	public Membership addMembership(@RequestBody Membership membership) {
		return membershipService.addMembership(membership);
	}

	@RequestMapping(value = "/memberships/{id}", method = PUT, headers = { "Accept=application/json" })
	public Membership updateMembership(@PathVariable("id") String id, @RequestBody Membership membership) {
		return membershipService.updateMembership(id, membership);
	}

	@RequestMapping(value = "/memberships/{id}", method = GET, headers = { "Accept=application/json" })
	public List<Membership> getMembership(@PathVariable("id") String id) {
		return membershipService.getMembership(id);
	}

	@RequestMapping(value = "/memberships/{id}", method = DELETE, headers = { "Accept=application/json" })
	public void deleteMembership(@PathVariable("id") String id) {
		membershipService.deleteMembership(id);
	}

}
