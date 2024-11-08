package fr.feuzme.demo.monorepo.home;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class HomeDto {
    private OwnerDto owner;
    private AddressDto address;
    private LocalDateTime modified;

    @Data
    @AllArgsConstructor
    public static class OwnerDto {
        private String name;
        private String surname;
    }

    @Data
    @AllArgsConstructor
    static class AddressDto {
        private Integer number;
        private String street;
        private String city;
        private String zipCode;
        private String country;
    }
}


