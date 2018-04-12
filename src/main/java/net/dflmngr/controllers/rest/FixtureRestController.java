package net.dflmngr.controllers.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.dflmngr.model.web.RoundFixtures;
import net.dflmngr.services.FixtureService;

@RestController
public class FixtureRestController {
	
	private final FixtureService fixtureService;

	@Autowired
	public FixtureRestController(FixtureService fixtureRespository) {
		this.fixtureService = fixtureRespository;
	}
	
    @ModelAttribute("module")
    public String module() {
        return "fixtures";
    }
	
	@RequestMapping(value = "/fixtures", method = RequestMethod.GET, produces = "application/json")
	public List<RoundFixtures> fixtures(Model model) {		
		List<RoundFixtures> fixtures = fixtureService.getFixtures();		
		return fixtures;
	}
}
