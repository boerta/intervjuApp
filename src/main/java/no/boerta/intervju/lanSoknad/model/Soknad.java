package no.boerta.intervju.lanSoknad.model;

import lombok.Data;

import java.util.List;

@Data
public class Soknad {
    private List<Person> lanetakere;
    private int lanebelop;
    private String behov;
}
