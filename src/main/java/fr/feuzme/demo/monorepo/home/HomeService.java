package fr.feuzme.demo.monorepo.home;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;

@Service
public class HomeService {
    private final HomeSender homeSender;
    private final HomeRepository homeRepository;

    public HomeDto getHomeByOwner(HomeDto.OwnerDto ownerDto) {
        var home = homeRepository.findByOwner(new Home.Owner(ownerDto.getName(), ownerDto.getSurname()));
        return new HomeDto(
                new HomeDto.OwnerDto(
                        home.getOwner().name(),
                        home.getOwner().surname()
                ),
                new HomeDto.AddressDto(
                        home.getAddress().number(),
                        home.getAddress().street(),
                        home.getAddress().zipCode(),
                        home.getAddress().city(),
                        home.getAddress().country()
                ),
                home.getModified()
        );
    }

    public HomeService(HomeSender homeSender, HomeRepository homeRepository) {
        this.homeSender = homeSender;
        this.homeRepository = homeRepository;
    }

    void sendHome(HomeDto homeDto) {
        homeSender.sendHome(map(homeDto));
    }

    void saveHome(HomeDto homeDto) {
        homeRepository.save(map(homeDto));
    }

    public Home getHomeByName(String name) {
        return homeRepository.findByOwnerName(name);
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
                    ),
                    LocalDateTime.now(ZoneId.systemDefault())
            );
        }
        return null;
    }
}
