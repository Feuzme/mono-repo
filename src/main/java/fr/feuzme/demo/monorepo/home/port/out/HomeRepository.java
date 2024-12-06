package fr.feuzme.demo.monorepo.home.port.out;

import fr.feuzme.demo.monorepo.home.models.Home;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories
public interface HomeRepository extends MongoRepository<Home, String> {
    Home findByOwnerName(String name);
}
