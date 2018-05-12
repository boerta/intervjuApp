package no.boerta.intervju.lanSoknad;

import io.swagger.annotations.Api;
import no.boerta.intervju.lanSoknad.model.Soknad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController(value = "/lan")
@Api(value = "LanSoknad", description = "Endepunkt for innsending av lånesøknad og henting av søknadsstatus")
public class LanSoknadController {

	private LanSoknadService service;

	@Autowired
	public LanSoknadController(LanSoknadService service) {
		this.service = service;
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
	public String status(@RequestParam String soknadsnummer) {
		return service.status(soknadsnummer);
	}

}
