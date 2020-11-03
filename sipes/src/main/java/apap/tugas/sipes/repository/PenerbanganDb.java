package apap.tugas.sipes.repository;

import apap.tugas.sipes.model.PenerbanganModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PenerbanganDb extends JpaRepository<PenerbanganModel, Long> {
}
