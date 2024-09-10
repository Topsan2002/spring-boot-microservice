package com.microservicespringboot.ecommerce.Customer

import jakarta.validation.Valid
import lombok.RequiredArgsConstructor
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/customer")
@RequiredArgsConstructor
class CustomerController {
    @Autowired
    lateinit var customerService: CustomerService
    @PostMapping("")
    fun create(@RequestBody  customer: Customer): ResponseEntity<String> {
        return ResponseEntity.ok(customerService.createCustomer(customer) )
    }

    @PutMapping("")
    fun updateCustomer(@RequestBody @Valid customer: Customer): ResponseEntity<Customer> {
        return  ResponseEntity.ok(customerService.updateCustomer(customer))
    }
    @GetMapping("")
    fun getAllCustomers(): ResponseEntity<List<Customer>> {
        return ResponseEntity.ok(customerService.findAllCustomers())
    }
    @GetMapping("/{id}")
    fun getCustomer(@PathVariable id: String): ResponseEntity<Customer> {
        return ResponseEntity.ok(customerService.findCustomerById(id))
    }
    @DeleteMapping("/{id}")
    fun deleteCustomer(@PathVariable id: String): ResponseEntity<String> {
        return ResponseEntity.ok(customerService.deleteCustomer(id))
    }
}