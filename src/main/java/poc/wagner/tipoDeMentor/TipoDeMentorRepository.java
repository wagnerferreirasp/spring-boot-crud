package poc.wagner.tipoDeMentor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoDeMentorRepository extends JpaRepository<TipoDeMentor, Long> {
}
