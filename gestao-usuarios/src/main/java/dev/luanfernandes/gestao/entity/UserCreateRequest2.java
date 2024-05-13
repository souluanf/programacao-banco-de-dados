package dev.luanfernandes.gestao.entity;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UserCreateRequest2(@NotNull Long id, @NotBlank String name, @Email String email) {
}

