package net.dflmngr.controllers.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.dflmngr.model.web.Ladder;
import net.dflmngr.services.LadderService;

@RestController
public class LadderRestController {

	private final LadderService ladderService;
	
	@Autowired
	public LadderRestController(LadderService ladderService) {
		this.ladderService = ladderService;
	}
	
	@RequestMapping(value = "/ladder", method = RequestMethod.GET, produces = "application/json")
	public List<Ladder> ladder() {
		List<Ladder> ladder = ladderService.getLadder();
		return ladder;
	}
}
