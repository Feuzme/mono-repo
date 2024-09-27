package fr.feuzme.demo.monorepo.home;

import org.springframework.stereotype.Service;

@Service
public class HomeService {
    private final HomeSender homeSender;

    public HomeService(HomeSender homeSender) {
        this.homeSender = homeSender;
    }

    void sendHome(HomeDto homeDto) {
        homeSender.sendHome(map(homeDto));
    }

    Home map(HomeDto homeDto) {
        if (homeDto != null) {
            return new Home(
                    new Home.Owner(
                            homeDto.getOwner().getName(),
                            homeDto.getOwner().getSurname()
                    ),
                    new Home.Address(
                            homeDto.getAddress().getNumber(),
                            homeDto.getAddress().getStreet(),
                            homeDto.getAddress().getCity(),
                            homeDto.getAddress().getZipCode(),
                            homeDto.getAddress().getCountry()
                    )
            );
        }
        return null;
    }
}
