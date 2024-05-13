package dev.luanfernandes.gestao.repository;

import dev.luanfernandes.gestao.entity.User;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@Tag(name = "Users")
@RepositoryRestResource(path = "users")
public interface UserRepository extends JpaRepository<User, Long> {
}