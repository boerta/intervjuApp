package no.boerta.intervju.lanSoknad;

import lombok.Synchronized;
import no.boerta.intervju.lanSoknad.model.LanSoknad;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.UUID;

@Service
public class LanSoknadRepository {
    private HashMap<String, LanSoknad> mottatteSoknader = new HashMap<>();
    private String namespace = "lanSoknad";

    public String lagreSoknad(LanSoknad soknad) {
        UUID uuid = UUID.nameUUIDFromBytes(namespace.getBytes());
        String soknadsnummer = uuid.toString();

        mottatteSoknader.put(soknadsnummer, soknad);

        return soknadsnummer;
    }

    public LanSoknad hentSoknad(int soknadsnummer) {
        if (mottatteSoknader.containsKey(soknadsnummer)) {
            return mottatteSoknader.get(soknadsnummer);
        }
        return null;
    }
}
