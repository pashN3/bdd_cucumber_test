package pash.practice.com.bddcucumberpash.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonDeserialize
public class Address {
    String street;
    String suite;
    String city;
    String zipcode;

    Geo geo;
}
