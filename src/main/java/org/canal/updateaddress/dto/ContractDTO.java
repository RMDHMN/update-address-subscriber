package org.canal.updateaddress.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.UUID;

@FieldDefaults(level= AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ContractDTO {

    UUID idContract;
    String name;
    String description;
    AddressDTO address;
}
