package no.boerta.intervju.lanSoknad;

import no.boerta.intervju.lanSoknad.model.Fnr;
import no.boerta.intervju.lanSoknad.model.LanSoknad;
import no.boerta.intervju.lanSoknad.model.SoknadsRespons;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class LanSoknadService {
    private HashMap<Fnr, LanSoknad> mottatteSoknader = new HashMap<>();


    public SoknadsRespons sendInn(LanSoknad soknad) {
        Fnr hovedsoker = soknad.getLanetakere().get(0).getFnr();
        mottatteSoknader.put(hovedsoker, soknad);
        System.out.println("Mottatt søknad: " + hovedsoker);
        return new SoknadsRespons(hovedsoker);
    }

    public String status(String fnr) {
        Fnr hovedsoker = new Fnr(fnr);
        if (mottatteSoknader.containsKey(hovedsoker)) {
            return "Mottatt";
        }
        return "Ukjent";
    }
}
