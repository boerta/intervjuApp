package no.boerta.intervju.lanSoknad;

import no.boerta.intervju.lanSoknad.model.LanSoknad;
import no.boerta.intervju.lanSoknad.model.SoknadsRespons;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class LanSoknadController {

	private LanSoknadService service;

	@Autowired
	public LanSoknadController(LanSoknadService service) {
		this.service = service;
	}

	@SuppressWarnings("static-method")
	@RequestMapping("/lan")
	public String lan() {
		return "Endepunkt for innsending av lånesøknad og henting av søknadsstatus";
	}

	@RequestMapping(
			value="/lan/soknad",
			method = RequestMethod.POST,
			consumes = "application/json",
			produces = "application/json"
			)
	public SoknadsRespons soknad(@RequestParam() LanSoknad soknad) {
		return service.sendInn(soknad);
	}

	@RequestMapping(
			value="/lan/status",
			method = RequestMethod.GET
	)
	public String status(String fnr) {
		return service.status(fnr);
	}

}
