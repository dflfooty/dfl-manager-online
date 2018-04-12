package net.dflmngr.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import net.dflmngr.model.web.RoundFixtures;
import net.dflmngr.services.FixtureService;

@Controller
public class FixtureController {
	
	private final String FIXTURES_VIEW = "fixtures";
	
	private final FixtureService fixtureService;

	@Autowired
	public FixtureController(FixtureService fixtureRespository) {
		this.fixtureService = fixtureRespository;
	}
	
    @ModelAttribute("module")
    public String module() {
        return "fixtures";
    }
	
	@RequestMapping(value = "/fixtures", method = RequestMethod.GET, produces = "text/html")
	public String fixtures(Model model) {		
		List<RoundFixtures> fixtures = fixtureService.getFixtures();
		model.addAttribute("fixtures", fixtures);
		
		return FIXTURES_VIEW;
	}
}
