package org.canal.updateaddress.repository;

import org.canal.updateaddress.model.Address;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.UUID;

public interface AddressRepository extends CrudRepository<Address, UUID> {

    Optional<Address> findById(UUID id);

    Address save(Address address);

    Iterable<Address> findAllById(Iterable<UUID> idList);
}
