package net.dflmngr.controllers.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.dflmngr.model.web.Results;
import net.dflmngr.services.ResultService;

@RestController
public class ResultsRestController {

	private final ResultService resultService;
	
	@Autowired
	public ResultsRestController(ResultService resultService) {
		this.resultService = resultService;
	}
	
	@RequestMapping(value = "/results/{round}/{game}", method = RequestMethod.GET, produces = "application/json")
	public Results getResults(@PathVariable int round, @PathVariable int game) {
		Results results = resultService.getResults(round, game);
		return results;
	}	
}
