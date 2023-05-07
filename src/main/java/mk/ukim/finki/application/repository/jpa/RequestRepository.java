package mk.ukim.finki.application.repository.jpa;

import mk.ukim.finki.application.model.requests.AbstractRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestRepository extends JpaRepository<AbstractRequest, Long>  {


}
