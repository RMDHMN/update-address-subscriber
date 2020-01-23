package org.canal.updateaddress.controller.impl;

import lombok.extern.slf4j.Slf4j;
import org.canal.updateaddress.controller.SubscriberWebService;
import org.canal.updateaddress.dto.AddressDTO;
import org.canal.updateaddress.dto.SubscriberDTO;
import org.canal.updateaddress.factory.SubscriberMapper;
import org.canal.updateaddress.model.Subscriber;
import org.canal.updateaddress.repository.SubscriberRepository;
import org.canal.updateaddress.service.SubscriberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.List;
import java.util.UUID;

@Slf4j
@Component
public class SubscriberWebServiceImpl implements SubscriberWebService {

    @Autowired
    private SubscriberRepository subscriberRepository;

    @Autowired
    private SubscriberService subscriberService;

    /**
     *
     * Asynchronous method to update the address subscriber using <mouvement> to trace the behaviours in different threads
     *
     * @param idSubscriber the id subscriber to update
     * @param newAddressDto the new address to set
     *
     * @return UUID The subscriber id
     *
     * @throws InterruptedException if the subscriber doesn't exist or the address pattern is incorrect
     */
    @Override
    public DeferredResult<ResponseEntity<SubscriberDTO>> updateAddressSubscriber(UUID idSubscriber, AddressDTO newAddressDto) throws InterruptedException {
        log.info("REST query : updateAddressSubscriber for {} id subscriber", idSubscriber);

        DeferredResult<ResponseEntity<SubscriberDTO>> output = new DeferredResult<>();
        Subscriber subscriberToUpdate = subscriberService.getSubscriber(idSubscriber);

        if(subscriberToUpdate != null && subscriberService.validAddressDTO(newAddressDto) ) {
            output.setResult(ResponseEntity.ok(SubscriberMapper.INSTANCE.subscriberToSubscriberDTO(subscriberToUpdate)));
            //Async parsing data process
            subscriberService.updateAddress(subscriberToUpdate, newAddressDto);
            log.info("Request updateAddressSubscriber for subscriber id {}, sent to the server", idSubscriber);
            log.info("Response to updateAddressSubscriber for subscriber id {}, sent to the client", idSubscriber);
            return output;

        } else {
            log.error("Unknown subscriber or inputs address invalid");
            throw new InterruptedException();
        }
    }

    /*
    TODO : to remove after test
     */
    @Override
    public List<Subscriber> getAllSubscribers() {
        log.info("REST query : getAllSubscribers");
        return subscriberRepository.findAll();
    }
}
