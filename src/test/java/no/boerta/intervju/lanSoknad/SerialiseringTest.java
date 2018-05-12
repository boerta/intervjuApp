package no.boerta.intervju.lanSoknad;

import com.fasterxml.jackson.databind.ObjectMapper;
import no.boerta.intervju.lanSoknad.model.Person;
import no.boerta.intervju.lanSoknad.model.Soknad;
import org.junit.Test;

import java.util.Arrays;

public class SerialiseringTest {
    @Test
    public void testSerialize() throws Exception {
        Soknad soknad = new Soknad();

        Person p1 = new Person("01056000069", "Kari Nordmann");
        Person p2 = new Person("01056000301", "Ola Nordmann");
        soknad.setLanetakere(Arrays.asList(p1, p2));

        soknad.setLanebelop(2450000);
        soknad.setBehov("Vi skal låne penger til........");

        String json = new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(soknad);
        System.out.println(json);
    }
}
