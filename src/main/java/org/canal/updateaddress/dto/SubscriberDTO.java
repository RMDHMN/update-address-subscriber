package org.canal.updateaddress.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;
import java.util.UUID;

@FieldDefaults(level= AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SubscriberDTO {

    UUID idSubscriber;
    String firstName;
    String lastName;
}
