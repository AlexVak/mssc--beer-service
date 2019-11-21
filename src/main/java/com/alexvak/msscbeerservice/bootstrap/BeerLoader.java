package com.alexvak.msscbeerservice.bootstrap;

import com.alexvak.msscbeerservice.domain.Beer;
import com.alexvak.msscbeerservice.repositories.BeerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;

import java.math.BigDecimal;
import java.util.UUID;

@Slf4j
//@Component
public class BeerLoader implements CommandLineRunner {

    public static final String BEER_1_UPC = "0631234200036";
    public static final String BEER_2_UPC = "0631234300019";
    public static final String BEER_3_UPC = "0083783375213";
    public static final UUID BEER_1_UUID = UUID.fromString("0a818933-087d-47f2-ad83-2f986ed087eb");

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
                    .upc(BEER_1_UPC)
                    .build());

            beerRepository.save(Beer.builder()
                    .beerName("Gines")
                    .beerStyle("Dark")
                    .minOnHand(12)
                    .quantityToBrew(200)
                    .price(new BigDecimal("14.25"))
                    .upc(BEER_2_UPC)
                    .build());

            beerRepository.save(Beer.builder()
                    .beerName("Gines2")
                    .beerStyle("Dark2")
                    .minOnHand(12)
                    .quantityToBrew(200)
                    .price(new BigDecimal("14.25"))
                    .upc(BEER_3_UPC)
                    .build());
        }
    }
}
