package com.testli.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.testli.aop.Loggable;
import com.testli.data.model.Benefit;
import com.testli.data.repo.BenefitRepository;

@Service
@Loggable
public class BenefitService {

	@Autowired
	private BenefitRepository benefitRepository;

	public Benefit addBenefit(Benefit benefit) {
		return benefitRepository.insert(benefit);
	}

	public Benefit updateBenefit(String id, Benefit benefit) {
		benefit.setId(id);
		return benefitRepository.save(benefit);
	}

	public List<Benefit> getBenefit(String ids) {
		List<Benefit> benefits = new ArrayList<>();
		if (ids != null) {
			List<String> items = Stream.of(ids.split("\\s*,\\s*")).map(element -> new String(element))
					.collect(Collectors.toList());
			Iterable<Benefit> findAllById = benefitRepository.findAllById(items);
			for (Benefit benefit : findAllById) {
				benefits.add(benefit);
			}
		}
		return benefits;
	}

	public void deleteBenefit(String id) {
		benefitRepository.deleteById(id);
	}

}
