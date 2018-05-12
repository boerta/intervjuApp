package no.boerta.intervju.lanSoknad;

import no.boerta.intervju.lanSoknad.model.Soknad;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.UUID;

@Service
public class LanSoknadRepository {
    private HashMap<String, Soknad> mottatteSoknader = new HashMap<>();
    private static String NAMESPACE = "lanSoknad";

    public String lagreSoknad(Soknad soknad) {
        String soknadsnummer = lagSoknadsnummer();

        mottatteSoknader.put(soknadsnummer, soknad);

        return soknadsnummer;
    }

    public Soknad hentSoknad(String soknadsnummer) {
        return mottatteSoknader.get(soknadsnummer);
    }

    private String lagSoknadsnummer() {
        UUID uuid = UUID.nameUUIDFromBytes(NAMESPACE.getBytes());
        return uuid.toString();
    }
}
