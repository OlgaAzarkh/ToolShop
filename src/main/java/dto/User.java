package dto;

import lombok.*;


import java.time.LocalDate;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String street;
    private String postalCode;
    private String city;
    private String state;
    private CountryCode country;
    private String phone;
    private String email;
    private String password;
}
