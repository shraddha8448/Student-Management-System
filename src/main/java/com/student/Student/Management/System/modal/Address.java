package com.student.Student.Management.System.modal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    @NotEmpty(message = "Street should not be empty")
    private String street;

    @NotEmpty(message = "city should not be empty")
    private String city;

    @NotEmpty(message = "state should not be empty")
    private String state;

    @NotEmpty(message = "postal code should not be empty")
    private String postalCode;

}
