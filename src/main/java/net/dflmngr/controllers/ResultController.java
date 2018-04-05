package net.dflmngr.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import net.dflmngr.model.web.Results;
import net.dflmngr.services.ResultService;

@Controller
public class ResultController {
	
	private final String RESULTS_VIEW = "results";

	private final ResultService resultService;
	
	@Autowired
	public ResultController(ResultService resultService) {
		this.resultService = resultService;
	}
	
    @ModelAttribute("module")
    public String module() {
        return "results";
    }
	
	@RequestMapping(value = "/results/{round}/{game}", method = RequestMethod.GET, produces = "text/html")
	public String results(@PathVariable int round, @PathVariable int game, Model model) {
		Results results = resultService.getResults(round, game);
		model.addAttribute("results", results);
		return RESULTS_VIEW;
	}	
}
