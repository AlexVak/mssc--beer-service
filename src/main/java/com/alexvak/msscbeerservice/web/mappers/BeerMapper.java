package com.alexvak.msscbeerservice.web.mappers;

import com.alexvak.msscbeerservice.domain.Beer;
import com.alexvak.msscbeerservice.web.model.BeerDto;
import org.mapstruct.Mapper;

@Mapper(uses = DateMapper.class)
public interface BeerMapper {

    BeerDto beerToBeerDto(Beer beer);

    Beer beerDtoToBeer(BeerDto dto);
}
