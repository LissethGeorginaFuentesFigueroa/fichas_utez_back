package utez.edu.mx.fichas_utez_backend.Modules.Registration.Model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRegistrationFormRepository extends JpaRepository<UserRegistrationForm, Long> {
}

