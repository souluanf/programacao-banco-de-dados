package dev.luanfernandes.pizzaria.controller;

import dev.luanfernandes.pizzaria.domain.entity.Cliente;
import dev.luanfernandes.pizzaria.domain.request.ClienteRequest;
import dev.luanfernandes.pizzaria.domain.response.ClienteResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import static dev.luanfernandes.pizzaria.constants.PathConstants.CLIENTE_ID;
import static dev.luanfernandes.pizzaria.constants.PathConstants.CLIENTE_V1;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.APPLICATION_PROBLEM_JSON_VALUE;

@RequestMapping(produces = APPLICATION_JSON_VALUE)
public interface ClienteController {

    @Operation(
            summary = "Criar um novo cliente",
            tags = {"cliente"},
            responses = {
                @ApiResponse(responseCode = "201", description = "Created"),
                @ApiResponse(
                        responseCode = "400",
                        description = "Bad Request",
                        content =
                                @Content(
                                        mediaType = APPLICATION_PROBLEM_JSON_VALUE,
                                        schema = @Schema(implementation = ProblemDetail.class))),
                @ApiResponse(
                        responseCode = "500",
                        description = "Internal Server Error",
                        content =
                                @Content(
                                        mediaType = APPLICATION_PROBLEM_JSON_VALUE,
                                        schema = @Schema(implementation = ProblemDetail.class)))
            })
    @PostMapping(CLIENTE_V1)
    ResponseEntity<ClienteResponse> criarCliente(@RequestBody ClienteRequest cliente);

    @Operation(
            summary = "Buscar um cliente por ID",
            tags = {"cliente"},
            responses = {
                @ApiResponse(responseCode = "200", description = "OK"),
                @ApiResponse(
                        responseCode = "404",
                        description = "Not Found",
                        content =
                                @Content(
                                        mediaType = APPLICATION_PROBLEM_JSON_VALUE,
                                        schema = @Schema(implementation = ProblemDetail.class))),
                @ApiResponse(
                        responseCode = "500",
                        description = "Internal Server Error",
                        content =
                                @Content(
                                        mediaType = APPLICATION_PROBLEM_JSON_VALUE,
                                        schema = @Schema(implementation = ProblemDetail.class)))
            })
    @GetMapping(CLIENTE_ID)
    ResponseEntity<Cliente> buscarClientePorId(@PathVariable Long clienteId);

    @Operation(
            summary = "Atualizar um cliente existente",
            tags = {"cliente"},
            responses = {
                @ApiResponse(responseCode = "200", description = "OK"),
                @ApiResponse(
                        responseCode = "400",
                        description = "Bad Request",
                        content =
                                @Content(
                                        mediaType = APPLICATION_PROBLEM_JSON_VALUE,
                                        schema = @Schema(implementation = ProblemDetail.class))),
                @ApiResponse(
                        responseCode = "404",
                        description = "Not Found",
                        content =
                                @Content(
                                        mediaType = APPLICATION_PROBLEM_JSON_VALUE,
                                        schema = @Schema(implementation = ProblemDetail.class))),
                @ApiResponse(
                        responseCode = "500",
                        description = "Internal Server Error",
                        content =
                                @Content(
                                        mediaType = APPLICATION_PROBLEM_JSON_VALUE,
                                        schema = @Schema(implementation = ProblemDetail.class)))
            })
    @PutMapping(CLIENTE_ID)
    ResponseEntity<Cliente> atualizarCliente(@PathVariable Long clienteId, @RequestBody Cliente clienteAtualizado);

    @Operation(
            summary = "Deletar um cliente por ID",
            tags = {"cliente"},
            responses = {
                @ApiResponse(responseCode = "204", description = "No Content"),
                @ApiResponse(
                        responseCode = "404",
                        description = "Not Found",
                        content =
                                @Content(
                                        mediaType = APPLICATION_PROBLEM_JSON_VALUE,
                                        schema = @Schema(implementation = ProblemDetail.class))),
                @ApiResponse(
                        responseCode = "500",
                        description = "Internal Server Error",
                        content =
                                @Content(
                                        mediaType = APPLICATION_PROBLEM_JSON_VALUE,
                                        schema = @Schema(implementation = ProblemDetail.class)))
            })
    @DeleteMapping(CLIENTE_ID)
    ResponseEntity<Void> deletarCliente(@PathVariable Long clienteId);
}
