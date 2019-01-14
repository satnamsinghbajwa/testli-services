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
import com.testli.data.model.Benefit;
import com.testli.services.BenefitService;

@RestController
@Loggable
public class BenefitController {

	@Autowired
	private BenefitService benefitService;

	@RequestMapping(value = "/benefits", method = POST, headers = { "Accept=application/json" })
	public Benefit addBenefit(@RequestBody Benefit benefit) {
		return benefitService.addBenefit(benefit);
	}

	@RequestMapping(value = "/benefits/{id}", method = PUT, headers = { "Accept=application/json" })
	public Benefit updateBenefit(@PathVariable("id") String id, @RequestBody Benefit benefit) {
		return benefitService.updateBenefit(id, benefit);
	}

	@RequestMapping(value = "/benefits/{id}", method = GET, headers = { "Accept=application/json" })
	public List<Benefit> getBenefit(@PathVariable("id") String id) {
		return benefitService.getBenefit(id);
	}

	@RequestMapping(value = "/benefits/{id}", method = DELETE, headers = { "Accept=application/json" })
	public void deleteBenefit(@PathVariable("id") String id) {
		benefitService.deleteBenefit(id);
	}

}
