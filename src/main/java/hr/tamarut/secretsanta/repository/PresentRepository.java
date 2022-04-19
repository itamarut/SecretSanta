package hr.tamarut.secretsanta.repository;

import hr.tamarut.secretsanta.domain.Present;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PresentRepository extends JpaRepository<Present, Long> {
}
