package fr.feuzme.demo.monorepo.home;

import lombok.AllArgsConstructor;
import lombok.Value;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Value
@AllArgsConstructor
@Document("home")
public class Home {

    Owner owner;
    Address address;
    LocalDateTime modified;

    public record Owner(String name, String surname) {
    }

    record Address(Integer number, String street, String city, String zipCode, String country) {
    }

}
