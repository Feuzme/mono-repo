package fr.feuzme.demo.monorepo.home;

public record Home(
        Owner owner,
        Address address
) {

    record Address(
            Integer number,
            String street,
            String city,
            String postalCode,
            String country
    ) {
    }

    record Owner(
            String name,
            String surname
    ) {
    }
}
