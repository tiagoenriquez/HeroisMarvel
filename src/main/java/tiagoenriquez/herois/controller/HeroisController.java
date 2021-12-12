package tiagoenriquez.herois.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import tiagoenriquez.herois.documents.Herois;
import tiagoenriquez.herois.repository.HeroisRepository;
import tiagoenriquez.herois.service.HeroisService;

import static tiagoenriquez.herois.constants.HeroisConstant.HEROES_ENDPOINT_LOCAL;

@RestController
@Slf4j
public class HeroisController {

    private final HeroisService heroisService;
    private final HeroisRepository heroisRepository;

    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(HeroisController.class);

    public HeroisController(HeroisService heroisService, HeroisRepository heroisRepository) {
        this.heroisService = heroisService;
        this.heroisRepository = heroisRepository;
    }

    @GetMapping(HEROES_ENDPOINT_LOCAL)
    @ResponseStatus(HttpStatus.OK)
    public Flux<Herois> getAllItems() {
        log.info("requerendo a lista de todos os herois");
        return heroisService.findAll();
    }

    @GetMapping(HEROES_ENDPOINT_LOCAL + "/{id}")
    public Mono<ResponseEntity<Herois>> findByIdHero(@PathVariable String id) {
        log.info("Requerendo o heroi com o id " + id);
        return heroisService.findByIdHero(id)
                .map((item) -> new ResponseEntity<>(item, HttpStatus.OK))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping(HEROES_ENDPOINT_LOCAL)
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Herois> createHeroi(@RequestBody Herois heroi) {
        log.info("Um novo heroi inserido no sistema");
        return heroisService.save(heroi);
    }

    /*@PatchMapping(HEROES_ENDPOINT_LOCAL + "/id")
    public Mono<Herois> updateHerois(@PathVariable String id, @RequestBody Herois herois) {
        log.info("Alterando as informações de um heroi");

    }*/

    @DeleteMapping(HEROES_ENDPOINT_LOCAL + "/{id}")
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public Mono<HttpStatus> deleteHeroi(@PathVariable String id) {
        heroisService.deleteByIdHeroi(id);
        log.info("Deletando o heroi com o id " + id);
        return Mono.just(HttpStatus.NOT_FOUND);
    }

}
