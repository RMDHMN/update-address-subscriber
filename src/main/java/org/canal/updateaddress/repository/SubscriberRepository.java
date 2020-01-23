package org.canal.updateaddress.repository;

import org.canal.updateaddress.model.Subscriber;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SubscriberRepository extends CrudRepository<Subscriber, UUID> {

    List<Subscriber> findAll();

    Optional<Subscriber> findById(final UUID id);

    Subscriber save(Subscriber subscriber);
}
