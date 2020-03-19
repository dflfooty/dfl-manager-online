package net.dflmngr.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import net.dflmngr.model.web.Ladder;
import net.dflmngr.services.LadderService;

@Controller
public class LadderController {

	private final String LADDER_VIEW = "ladder";

	private final LadderService ladderService;

	@Autowired
	public LadderController(LadderService ladderService) {
		this.ladderService = ladderService;
	}

    @ModelAttribute("module")
    public String module() {
        return "ladder";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET, produces = "text/html")
    public String ladder(Model model) {
    	List<Ladder> ladder = ladderService.getLadder();

		int round = 1;

		if(!ladder.isEmpty()) {
			model.addAttribute("ladder", ladder);
			round = ladder.get(0).getRound();
		}

    	model.addAttribute("currentRound", round);

    	List<Ladder> liveLadder = ladderService.getLiveLadder();
    	model.addAttribute("liveLadder", liveLadder);

    	return LADDER_VIEW;
    }
}
