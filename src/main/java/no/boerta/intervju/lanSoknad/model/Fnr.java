package no.boerta.intervju.lanSoknad.model;

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

    public String toString() {
        return fnr;
    }
}
