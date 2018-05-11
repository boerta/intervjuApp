package no.boerta.intervju.lanSoknad.model;

import lombok.Data;

import java.util.ArrayList;

@Data
public class LanSoknad {
    private ArrayList<Person> lanetakere;
    private int lanebelop;
    private String behov;

    private int soknadsnummer;
}
