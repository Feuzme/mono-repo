package fr.feuzme.demo.monorepo.home;

import lombok.RequiredArgsConstructor;
import lombok.Value;

@Value
@RequiredArgsConstructor
public class HomeDto {
    OwnerDto owner;
    AddressDto address;

    @Value
    @RequiredArgsConstructor
    class OwnerDto {
        String name;
        String surname;
    }

    @Value
    @RequiredArgsConstructor
    class AddressDto {
        Integer number;
        String street;
        String city;
        String zipCode;
        String country;
    }
}
