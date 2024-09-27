package fr.feuzme.demo.monorepo.home;

import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
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
        String postalCode;
        String country;

    }

}
