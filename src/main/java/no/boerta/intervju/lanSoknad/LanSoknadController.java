package no.boerta.intervju.lanSoknad;

import no.boerta.intervju.lanSoknad.model.Soknad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController(value = "/lan")
public class LanSoknadController {

	private LanSoknadService service;

	@Autowired
	public LanSoknadController(LanSoknadService service) {
		this.service = service;
	}

	@RequestMapping("/lan")
	public String lan() {
		return "Endepunkt for innsending av lånesøknad og henting av søknadsstatus";
	}

	@RequestMapping(
			value="/lan/soknad",
			method = RequestMethod.POST,
			consumes = "application/json"
			)
	public String soknad(@RequestBody Soknad soknad) {
		return service.sendInn(soknad);
	}

	@RequestMapping(
			value="/lan/status",
			method = RequestMethod.GET
	)
	public String status(@RequestBody String soknadsnummer) {
		return service.status(soknadsnummer);
	}

}
