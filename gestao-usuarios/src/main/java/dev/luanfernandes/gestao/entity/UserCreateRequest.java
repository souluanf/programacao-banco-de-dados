package dev.luanfernandes.gestao.entity;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import org.springframework.validation.annotation.Validated;

@Validated
public record UserCreateRequest(
        @NotBlank @Min(1) @Max(3) String name,
        @Email String email
) {
}