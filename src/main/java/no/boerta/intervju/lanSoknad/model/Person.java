package no.boerta.intervju.lanSoknad.model;

import lombok.Data;

@Data
public class Person {
     private Fnr fnr;
     private String navn;

     public Person(String fnr, String navn) {
          this.fnr = new Fnr(fnr);
          this.navn = navn;
     }
}
