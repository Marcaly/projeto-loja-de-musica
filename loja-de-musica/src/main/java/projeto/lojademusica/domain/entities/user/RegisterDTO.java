package projeto.lojademusica.domain.entities.user;

public record RegisterDTO(String login, String password, UserRoles role) {
}
