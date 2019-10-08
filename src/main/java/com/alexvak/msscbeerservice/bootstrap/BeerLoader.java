package com.alexvak.msscbeerservice.bootstrap;

import com.alexvak.msscbeerservice.domain.Beer;
import com.alexvak.msscbeerservice.repositories.BeerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Slf4j
@Component
public class BeerLoader implements CommandLineRunner {

    private final BeerRepository beerRepository;

    public BeerLoader(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadBeerObjects();
    }

    private void loadBeerObjects() {
        if (beerRepository.count() == 0) {

            beerRepository.save(Beer.builder()
                    .beerName("Dunkel")
                    .beerStyle("Dark")
                    .minOnHand(10)
                    .quantityToBrew(100)
                    .price(new BigDecimal("9.25"))
                    .utc(114235272135L)
                    .build());

            beerRepository.save(Beer.builder()
                    .beerName("Gines")
                    .beerStyle("Dark")
                    .minOnHand(12)
                    .quantityToBrew(200)
                    .price(new BigDecimal("14.25"))
                    .utc(1142352767335L)
                    .build());
        }
    }
}
