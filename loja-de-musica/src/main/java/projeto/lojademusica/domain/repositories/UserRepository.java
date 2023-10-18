package projeto.lojademusica.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import projeto.lojademusica.domain.entities.User;

public interface UserRepository extends JpaRepository<User, String> {

    UserDetails findByLogin(String login);

}