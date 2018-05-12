package no.boerta.intervju.lanSoknad.model;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.*;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;

@JsonComponent
public class PersonSerializer {

    public static class Serializer extends JsonSerializer<Person> {

        @Override
        public void serialize(Person person, JsonGenerator jgen, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
            jgen.writeStartObject();
            jgen.writeStringField("fnr", person.getFnr().toString());
            jgen.writeStringField("navn", person.getNavn());
            jgen.writeEndObject();
        }
    }

    public static class Deserializer extends JsonDeserializer<Person> {

        @Override
        public Person deserialize(JsonParser jp, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            JsonNode personNode = jp.getCodec().readTree(jp);
            Person person = new Person(personNode.get("fnr").textValue(), personNode.get("navn").textValue());

            return person;
        }
    }

}
