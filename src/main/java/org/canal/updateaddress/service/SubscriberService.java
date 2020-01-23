package org.canal.updateaddress.service;

import org.canal.updateaddress.dto.AddressDTO;
import org.canal.updateaddress.model.Subscriber;

import java.util.UUID;

public interface SubscriberService {

    /**
     * attending source repository
     *
     * @param subscriber subscriber to update
     * @param addressDTO new address to update
     */
    void updateAddress(Subscriber subscriber, AddressDTO addressDTO);

    /**
     * Check if the addressDTO inputs are valid for update
     *
     * @param addressDTO
     * @return true if valid, false if not
     */
    boolean validAddressDTO(AddressDTO addressDTO);

    /**
     * Return the Subscriber from the data source and null if unknown
     *
     * @param idSubscriber
     * @return Subscriber
     */
    Subscriber getSubscriber(UUID idSubscriber);
}
