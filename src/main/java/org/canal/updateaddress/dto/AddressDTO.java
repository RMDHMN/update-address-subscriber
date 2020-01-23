package org.canal.updateaddress.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level= AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AddressDTO {

    String address;
    String zipCode;
    String city;
    String country;

    public boolean isNoEmpty() {
        return address != null && zipCode != null && city != null && country != null && //
                             !address.isEmpty() && !zipCode.isEmpty() && !city.isEmpty() && !country.isEmpty();
    }
    public boolean isValid() {
        return true;    // && some regex validations
    }
}
