package com.microservicespringboot.ecommerce.Customer

import lombok.*
import org.springframework.validation.annotation.Validated

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Validated
class Address {
    private var street: String? = null
    private var houseNumber: String? = null
    private var zipCode: String? = null
}
