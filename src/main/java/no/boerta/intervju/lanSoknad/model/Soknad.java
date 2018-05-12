package no.boerta.intervju.lanSoknad.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel
public class Soknad {
    @ApiModelProperty(notes = "Liste med lånetakere. Forste person i lista er hovedsøker", required = true)
    private List<Person> lanetakere;

    @ApiModelProperty(notes = "Ønsket lånebeløp", required = true)
    private int lanebelop;
    @ApiModelProperty(notes = "Begrunnelse for soknad", required = true)
    private String behov;
}
