package no.boerta.intervju.lanSoknad;

import no.boerta.intervju.lanSoknad.model.LanSoknad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LanSoknadService {
    LanSoknadRepository repo;

    @Autowired
    public LanSoknadService(LanSoknadRepository repo) {
        this.repo = repo;
    }

    public String sendInn(LanSoknad soknad) {
        String soknadsnummer = repo.lagreSoknad(soknad);
        System.out.println("Mottatt søknad: " + soknadsnummer);
        return soknadsnummer;
    }

    public String status(int soknadsnummer) {
        LanSoknad soknad = repo.hentSoknad(soknadsnummer);
        if(soknad == null) {
            return "Ukjent";
        }
        return "Mottatt søknad";
    }
}
