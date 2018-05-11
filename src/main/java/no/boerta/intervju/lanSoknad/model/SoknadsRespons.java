package no.boerta.intervju.lanSoknad.model;


import lombok.Getter;

public class SoknadsRespons {
    @Getter
    private String fnr;

    public SoknadsRespons(Fnr fnr) {
        this.fnr = fnr.toString();
    }
}
