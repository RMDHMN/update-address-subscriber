package org.canal.updateaddress.factory;

import org.canal.updateaddress.dto.AddressDTO;
import org.canal.updateaddress.dto.ContractDTO;
import org.canal.updateaddress.dto.SubscriberDTO;
import org.canal.updateaddress.model.Address;
import org.canal.updateaddress.model.Contract;
import org.canal.updateaddress.model.Subscriber;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SubscriberMapper {

    SubscriberMapper INSTANCE = Mappers.getMapper(SubscriberMapper.class);

    SubscriberDTO subscriberToSubscriberDTO(Subscriber subscriber);

    ContractDTO contractToContractDTO(Contract contract);

    AddressDTO addressToAddressDTO(Address address);

    Subscriber subscriberDTOToSubscriber(SubscriberDTO subscriberDTO);

    Contract contractDTOToContract(ContractDTO contractDTO);

    Address addressDTOToAddress(AddressDTO addressDTO);
}
