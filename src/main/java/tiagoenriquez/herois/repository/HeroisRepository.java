package tiagoenriquez.herois.repository;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import tiagoenriquez.herois.documents.Herois;

@EnableScan
public interface HeroisRepository extends CrudRepository<Herois, String> {
}
