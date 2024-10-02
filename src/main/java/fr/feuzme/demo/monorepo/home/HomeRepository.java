package fr.feuzme.demo.monorepo.home;

import org.springframework.data.mongodb.repository.MongoRepository;


public interface HomeRepository extends MongoRepository<Home, String> {
}
