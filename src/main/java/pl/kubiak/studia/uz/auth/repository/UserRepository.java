package pl.kubiak.studia.uz.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.kubiak.studia.uz.auth.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
