package org.canal.updateaddress.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.canal.updateaddress.dto.AddressDTO;
import org.canal.updateaddress.model.Address;
import org.canal.updateaddress.model.Contract;
import org.canal.updateaddress.model.Subscriber;
import org.canal.updateaddress.repository.AddressRepository;
import org.canal.updateaddress.repository.SubscriberRepository;
import org.canal.updateaddress.service.SubscriberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;

@Slf4j
@Service
public class SubscriberServiceImpl implements SubscriberService {


    @Autowired
    private SubscriberRepository subscriberRepository;

    @Autowired
    private AddressRepository addressRepository;

    /**
     * attending source repository // Async parsing data process
     *
     * @param subscriber subscriber to update
     * @param addressDTO new address to update
     */
    @Override
    public void updateAddress(Subscriber subscriber, AddressDTO addressDTO) {
        ForkJoinPool.commonPool().submit(() -> {
            log.info("Updating address subscriber with id {}, in datasource ...", subscriber.getIdSubscriber());
            List<Contract> contractList = subscriber.getContractList().stream().collect(Collectors.toList());
            Iterable<Address> addressList = addressRepository.findAllById(contractList.stream().map(contract -> contract.getAddress().getIdAddress()).collect(Collectors.toList()));
            addressList.forEach(address -> addressRepository.save(new Address(address.getIdAddress(), addressDTO.getAddress(), address.getZipCode(), address.getCity(), address.getCountry())));
            log.info("--- Address subscriber with id {}, updated successfully.", subscriber.getIdSubscriber());
        });
    }

    /**
     * Check if the addressDTO inputs are valid for update
     *
     * @param addressDTO
     * @return true if valid, false if not
     */
    @Override
    public boolean validAddressDTO(AddressDTO addressDTO) {
        if(!addressDTO.isNoEmpty()) {
            log.info("valid inputs address");
            return true && addressDTO.isValid();
        } else {
            log.error("Invalid inputs address");
            return false;
        }
    }

    /**
     * Return the Subscriber from the data source and null if unknown
     *
     * @param idSubscriber
     * @return Subscriber
     */
    @Override
    public Subscriber getSubscriber(UUID idSubscriber) {
        log.info("Getting subscriber from data source");
        Optional<Subscriber> subscriberToUpdate = subscriberRepository.findById(idSubscriber);
        if(subscriberToUpdate.isPresent()) {
            log.info("Subscriber with id {}, found", idSubscriber);
            return subscriberToUpdate.get();
        } else {
            log.error("Unknown subscriber");
            return  null;
        }
    }
}
