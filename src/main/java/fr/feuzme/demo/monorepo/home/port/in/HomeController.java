package fr.feuzme.demo.monorepo.home.port.in;

import fr.feuzme.demo.monorepo.configuration.ConditionalOnComponent;
import fr.feuzme.demo.monorepo.home.port.models.Home;
import fr.feuzme.demo.monorepo.home.service.HomeService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/home")
@ConditionalOnComponent("home-api")
public class HomeController {
    private final HomeService homeService;

    public HomeController(HomeService homeService) {
        this.homeService = homeService;
    }

    @GetMapping()
    Home getHomeByOwner(@PathVariable String name) {
        return homeService.getHomeByName(name);
    }

    @PostMapping
    void postHomeMessage(@RequestBody HomeDto homeDto) {
        homeService.sendHome(homeDto);
    }
}
