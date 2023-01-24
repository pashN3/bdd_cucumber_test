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
public class User {
    int id;
    String name;
    String username;
    String email;
    Address address;

    String phone;
    String website;

    Company company;
}
