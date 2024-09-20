package fr.feuzme.demo.monorepo.home;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;

@Service
public class HomeService {
    private final HomeSender homeSender;
    private final HomeMapper mapper;

    public HomeService(HomeSender homeSender, HomeMapper mapper) {
        this.homeSender = homeSender;
        this.mapper = mapper;
    }

    void sendHome(HomeDto homeDto) {
        homeSender.sendHome(mapper.toHome(homeDto));
    }

    @Mapper(componentModel = "spring")
    interface HomeMapper {
        Home toHome(HomeDto homeDto);

        Home.Owner toOwner(HomeDto.OwnerDto ownerDto);

        Home.Address toAddress(HomeDto.AddressDto addressDto);
    }
}
