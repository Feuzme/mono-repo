package fr.feuzme.demo.monorepo.home;

import fr.feuzme.demo.monorepo.configuration.ConditionalOnComponent;
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
    Home getFooHome() {
        return null;
    }

    @PostMapping
    void postHomeMessage(@RequestBody HomeDto homeDto) {
        homeService.sendHome(homeDto);
    }
}
