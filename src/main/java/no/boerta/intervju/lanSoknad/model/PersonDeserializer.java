package no.boerta.intervju.lanSoknad.model;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;

public class PersonDeserializer extends StdDeserializer<Person> {

    public PersonDeserializer() {
        this(null);
    }

    protected PersonDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public Person deserialize(JsonParser jp, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        JsonNode personNode = jp.getCodec().readTree(jp);
        Person person = new Person(personNode.get("fnr").textValue(), personNode.get("navn").textValue());

        return person;
    }
}
