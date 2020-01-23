package org.canal.updateaddress.controller;

import org.canal.updateaddress.dto.AddressDTO;
import org.canal.updateaddress.dto.SubscriberDTO;
import org.canal.updateaddress.model.Subscriber;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
public interface SubscriberWebService {

    /**
     * Asynchronous method to update the address subscriber using <mouvement> to trace the behaviours in different threads
     *
     * @param idSubscriber the id subscriber to update
     * @param newAddressDto the new address to set
     *
     * @return UUID The subscriber id
     *
     * @throws InterruptedException if the subscriber doesn't exist or the address pattern is incorrect
     */
    @PostMapping(path = "update/addresses/{idSubscriber}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    DeferredResult<ResponseEntity<SubscriberDTO>> updateAddressSubscriber(@PathVariable final UUID idSubscriber, @RequestBody final AddressDTO newAddressDto) throws InterruptedException;

    @GetMapping(path = "all")
    List<Subscriber> getAllSubscribers();
}
