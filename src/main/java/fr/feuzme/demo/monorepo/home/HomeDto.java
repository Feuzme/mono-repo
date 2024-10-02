package fr.feuzme.demo.monorepo.home;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class HomeDto {
    private OwnerDto owner;
    private AddressDto address;

    @Data
    @RequiredArgsConstructor
    static class OwnerDto {
        private String name;
        private String surname;
    }

    @Data
    @RequiredArgsConstructor
    static class AddressDto {
        private Integer number;
        private String street;
        private String city;
        private String zipCode;
        private String country;
    }
}


