package org.canal.updateaddress.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.UUID;

@FieldDefaults(level= AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Contract implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    UUID idContract;
    String name;
    String description;
    Address address;
}
