package no.boerta.intervju.lanApp;

import no.boerta.intervju.lanApp.model.LanSoknad;
import no.boerta.intervju.lanApp.model.SoknadsRespons;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class LanAppController {

	private LanAppService service;

	@Autowired
	public LanAppController(LanAppService service) {
		this.service = service;
	}

	@RequestMapping("/lanApp/ping")
	@SuppressWarnings("static-method")
	public String ping() {
		return "pong";
	}

	@RequestMapping(
			value="/lanApp/sendInn",
			method = RequestMethod.POST,
			consumes = "application/json",
			produces = "application/json"
			)
	public SoknadsRespons sendInn(@RequestParam() LanSoknad soknad) {
		return service.sendInn(soknad);
	}

	@RequestMapping(
			value="/lanApp/status"
	)
	public String status(String fnr) {
		return service.status(fnr);
	}

}
