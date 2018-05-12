package no.boerta.intervju.lanSoknad;

import no.boerta.intervju.lanSoknad.model.Soknad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LanSoknadService {
    LanSoknadRepository repo;

    @Autowired
    public LanSoknadService(LanSoknadRepository repo) {
        this.repo = repo;
    }

    public String sendInn(Soknad soknad) {
        String soknadsnummer = repo.lagreSoknad(soknad);
        System.out.println("Mottatt ny søknad: " + soknadsnummer);
        return soknadsnummer;
    }

    public String status(String soknadsnummer) {
        Soknad soknad = repo.hentSoknad(soknadsnummer);
        if(soknad == null) {
            System.out.println("Ukjent soknad: " + soknadsnummer);
            return "Ukjent";
        }
        System.out.println("Etterspurt soknad: " + soknadsnummer + " er mottatt.");
        return "Mottatt søknad";
    }
}
