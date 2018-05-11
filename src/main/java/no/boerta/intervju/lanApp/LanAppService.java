package no.boerta.intervju.lanApp;

import no.boerta.intervju.lanApp.model.Fnr;
import no.boerta.intervju.lanApp.model.LanSoknad;
import no.boerta.intervju.lanApp.model.SoknadsRespons;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class LanAppService {
    private HashMap<Fnr, LanSoknad> mottatteSoknader = new HashMap<>();


    public SoknadsRespons sendInn(LanSoknad soknad) {
        Fnr hovedsoker = soknad.getLanetakere().get(0).getFnr();
        mottatteSoknader.put(hovedsoker, soknad);

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
