package com.testli.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.testli.aop.Loggable;
import com.testli.data.model.Membership;
import com.testli.data.repo.MembershipRepository;

@Service
@Loggable
public class MembershipService {

	@Autowired
	private MembershipRepository membershipRepository;

	public Membership addMembership(Membership membership) {
		return membershipRepository.insert(membership);
	}

	public Membership updateMembership(String id, Membership membership) {
		membership.setId(id);
		return membershipRepository.save(membership);
	}

	public List<Membership> getMembership(String ids) {
		List<Membership> memberships = new ArrayList<>();
		if (ids != null) {
			List<String> items = Stream.of(ids.split("\\s*,\\s*")).map(element -> new String(element))
					.collect(Collectors.toList());
			Iterable<Membership> findAllById = membershipRepository.findAllById(items);
			for (Membership membership : findAllById) {
				memberships.add(membership);
			}
		}
		return memberships;
	}

	public void deleteMembership(String id) {
		membershipRepository.deleteById(id);
	}

}
