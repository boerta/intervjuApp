package no.boerta.intervju.lanSoknad;

import no.boerta.intervju.lanSoknad.model.Soknad;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.UUID;

@Service
public class LanSoknadRepository {
    private HashMap<String, Soknad> mottatteSoknader = new HashMap<>();

    public String lagreSoknad(Soknad soknad) {
        String soknadsnummer = lagSoknadsnummer();

        mottatteSoknader.put(soknadsnummer, soknad);

        return soknadsnummer;
    }

    public Soknad hentSoknad(String soknadsnummer) {
        return mottatteSoknader.get(soknadsnummer);
    }

    private String lagSoknadsnummer() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }
}
