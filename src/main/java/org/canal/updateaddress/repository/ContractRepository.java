package org.canal.updateaddress.repository;

import org.canal.updateaddress.model.Contract;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.UUID;

public interface ContractRepository extends CrudRepository<Contract, UUID> {

    Optional<Contract> findById(UUID id);

    Contract save(Contract contract);
}
