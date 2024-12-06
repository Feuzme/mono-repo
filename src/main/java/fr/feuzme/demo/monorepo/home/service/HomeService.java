package fr.feuzme.demo.monorepo.home.service;

import fr.feuzme.demo.monorepo.home.port.in.HomeDto;
import fr.feuzme.demo.monorepo.home.port.models.Home;
import fr.feuzme.demo.monorepo.home.port.out.HomeRepository;
import fr.feuzme.demo.monorepo.home.port.out.HomeSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;

@Service
public class HomeService {
    private final HomeSender homeSender;
    private final HomeRepository homeRepository;

    public HomeService(HomeSender homeSender, HomeRepository homeRepository) {
        this.homeSender = homeSender;
        this.homeRepository = homeRepository;
    }

    public void sendHome(HomeDto homeDto) {
        homeSender.sendHome(map(homeDto));
    }

    public void saveHome(HomeDto homeDto) {
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
