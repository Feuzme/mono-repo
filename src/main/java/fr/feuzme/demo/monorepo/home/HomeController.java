package fr.feuzme.demo.monorepo.home;

import fr.feuzme.demo.monorepo.configuration.ConditionalOnComponent;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/home")
@ConditionalOnComponent("home-component")
public class HomeController {
    private final HomeService homeService;

    public HomeController(HomeService homeService) {
        this.homeService = homeService;
    }

    @GetMapping()
    Home getFooHome() {
        return new Home(
                new Home.Owner("Abitebol", "Georges"),
                new Home.Address(55, "monde", "DeMerde", "'59000", "France")
        );
    }

    @PostMapping
    void postHomeMessage(@RequestBody HomeDto homeDto) {
        homeService.sendHome(homeDto);
    }
}
