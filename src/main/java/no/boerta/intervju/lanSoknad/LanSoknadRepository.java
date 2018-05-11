package no.boerta.intervju.lanSoknad;

import lombok.Synchronized;
import no.boerta.intervju.lanSoknad.model.LanSoknad;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class LanSoknadRepository {
    private HashMap<Integer, LanSoknad> mottatteSoknader = new HashMap<>();
    private int soknadsnummerTeller = 0;

    @Synchronized //trådsikre teller
    public int lagreSoknad(LanSoknad soknad) {
        int soknadsnummer = ++soknadsnummerTeller;

        try {
            mottatteSoknader.put(soknadsnummer, soknad);
        } catch(Exception e) {
            soknadsnummerTeller--;  //bevare state paa teller
            throw e;
        }
        return soknadsnummer;
    }

    public LanSoknad hentSoknad(int soknadsnummer) {
        if (mottatteSoknader.containsKey(soknadsnummer)) {
            return mottatteSoknader.get(soknadsnummer);
        }
        return null;
    }
}
