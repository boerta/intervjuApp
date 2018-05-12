package no.boerta.intervju.lanSoknad;

import no.boerta.intervju.lanSoknad.model.LanSoknad;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.UUID;

@Service
public class LanSoknadRepository {
    private HashMap<String, LanSoknad> mottatteSoknader = new HashMap<>();
    private static String NAMESPACE = "lanSoknad";

    public String lagreSoknad(LanSoknad soknad) {
        String soknadsnummer = lagSoknadsnummer();

        mottatteSoknader.put(soknadsnummer, soknad);

        return soknadsnummer;
    }

    public LanSoknad hentSoknad(String soknadsnummer) {
        if (mottatteSoknader.containsKey(soknadsnummer)) {
            return mottatteSoknader.get(soknadsnummer);
        }
        return null;
    }

    private String lagSoknadsnummer() {
        UUID uuid = UUID.nameUUIDFromBytes(NAMESPACE.getBytes());
        return uuid.toString();
    }
}
