package no.boerta.intervju.lanSoknad.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel
public class Person {
     private Fnr fnr;
     private String navn;

     public Person(String fnr, String navn) {
          this.fnr = new Fnr(fnr);
          this.navn = navn;
     }
}
