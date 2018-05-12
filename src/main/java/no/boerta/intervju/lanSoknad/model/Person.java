package no.boerta.intervju.lanSoknad.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

@Data
@JsonSerialize(using = PersonSerializer.class)
@JsonDeserialize(using = PersonDeserializer.class)
public class Person {
     private Fnr fnr;
     private String navn;

     public Person(String fnr, String navn) {
          this.fnr = new Fnr(fnr);
          this.navn = navn;
     }
}
