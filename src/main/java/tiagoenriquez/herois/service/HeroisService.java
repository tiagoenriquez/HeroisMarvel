package tiagoenriquez.herois.service;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import tiagoenriquez.herois.documents.Herois;
import tiagoenriquez.herois.repository.HeroisRepository;

@Service
public class HeroisService {

    private final HeroisRepository heroisRepository;

    public HeroisService(HeroisRepository heroisRepository) {
        this.heroisRepository = heroisRepository;
    }

    public Flux<Herois> findAll() {
        return Flux.fromIterable(this.heroisRepository.findAll());
    }

    public Mono<Herois> findByIdHero(String id) {
        return Mono.justOrEmpty(this.heroisRepository.findById(id));
    }

    public Mono<Herois> save(Herois herois) {
        return  Mono.justOrEmpty(this.heroisRepository.save(herois));
    }

    public Mono<Boolean> deleteByIdHeroi(String id) {
        heroisRepository.deleteById(id);
        return Mono.just(true);
    }

}
