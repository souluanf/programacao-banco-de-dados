package dev.luanfernandes.pizzaria.domain.mapper;

import dev.luanfernandes.pizzaria.domain.entity.Cliente;
import dev.luanfernandes.pizzaria.domain.request.ClienteRequest;
import dev.luanfernandes.pizzaria.domain.response.ClienteResponse;
import org.mapstruct.Mapper;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface ClienteMapper {
    Cliente map(ClienteRequest source);

    ClienteResponse map(Cliente source);
}