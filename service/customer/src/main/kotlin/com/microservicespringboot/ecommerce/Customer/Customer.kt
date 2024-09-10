package com.microservicespringboot.ecommerce.Customer

import jakarta.validation.constraints.NotBlank
import lombok.AllArgsConstructor
import lombok.Builder
import lombok.Getter
import lombok.NoArgsConstructor
import lombok.Setter
import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Document
data class Customer(
    @Id
     var id : ObjectId = ObjectId(),
    @field:NotBlank(message = "Customer First Name cannot be blank")
     var firstName: String? = null,
    @field:NotBlank(message = "Customer Last Name cannot be blank")
     var lastName: String? = null,
    @field:NotBlank(message = "Customer Email cannot be blank")
     var email: String? = null,
    var address: Address? = null,
)
