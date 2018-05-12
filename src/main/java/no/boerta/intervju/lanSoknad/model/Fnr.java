package no.boerta.intervju.lanSoknad.model;

import lombok.Getter;

public class Fnr {
    @Getter
    private String fnr;

    public Fnr(String fnr) {
        //valider gyldig fnr her
        this.fnr = fnr;
    }

    public String toString() {
        return fnr;
    }
}
