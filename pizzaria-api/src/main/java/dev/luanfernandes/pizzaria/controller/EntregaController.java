package dev.luanfernandes.pizzaria.controller;

import static dev.luanfernandes.pizzaria.constants.PathConstants.ENTREGA_CONFIRMAR;
import static dev.luanfernandes.pizzaria.constants.PathConstants.ENTREGA_VERIFICAR_PAGAMENTO;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.APPLICATION_PROBLEM_JSON_VALUE;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping(produces = APPLICATION_JSON_VALUE)
public interface EntregaController {

    @Operation(
            summary = "Confirmar recebimento",
            tags = {"entrega"},
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
                        responseCode = "422",
                        description = "Unprocessable Entity",
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
    @GetMapping(ENTREGA_CONFIRMAR)
    ResponseEntity<Void> confirmarRecebimento(@PathVariable Long entregaId, @RequestParam String codigoDeEntrega);

    @Operation(
            summary = "Verificar pagamento",
            tags = {"entrega"},
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
                        responseCode = "422",
                        description = "Unprocessable Entity",
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
    @GetMapping(ENTREGA_VERIFICAR_PAGAMENTO)
    ResponseEntity<Boolean> verificarPagamento(@PathVariable Long entregaId);
}
