package no.boerta.intervju.lanApp;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LanAppController {

	@RequestMapping("/status")
	@SuppressWarnings("static-method")
	public String status() {

		return "OK";
	}

}
