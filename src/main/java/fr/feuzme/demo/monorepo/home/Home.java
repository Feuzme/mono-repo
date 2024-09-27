package fr.feuzme.demo.monorepo.home;

import lombok.AllArgsConstructor;
import lombok.Value;
import org.springframework.data.mongodb.core.mapping.Document;

@Value
@AllArgsConstructor
@Document("home")
public class Home {

    Owner owner;
    Address address;

    @Value
    @AllArgsConstructor
    static class Owner {
        String name;
        String surname;
    }

    @Value
    @AllArgsConstructor
    static class Address {
        Integer number;
        String street;
        String city;
        String zipCode;
        String country;

    }

}
