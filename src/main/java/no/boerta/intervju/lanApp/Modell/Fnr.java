package no.boerta.intervju.lanApp.Modell;

import lombok.Getter;
import lombok.ToString;

@ToString
public class Fnr {
    @Getter
    private String fnr;

    private Fnr(){}

    public Fnr(String fnr) {
        //valider gyldig fnr her
        this.fnr = fnr;
    }
}
