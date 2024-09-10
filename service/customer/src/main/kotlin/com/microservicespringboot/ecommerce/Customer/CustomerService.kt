package com.microservicespringboot.ecommerce.Customer

import lombok.RequiredArgsConstructor
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service


@Service
@RequiredArgsConstructor
class CustomerService {
    @Autowired
    lateinit var customerRepository: CustomerRepository
    fun createCustomer(requestData: Customer): String? {
        var customer = customerRepository.save(requestData)
        return customer.toString()
    }
    fun updateCustomer(requestData: Customer): Customer? {
        var customerData = customerRepository.findById(requestData.id.toString())
            .orElseThrow { NoSuchElementException("Customer not found with id: " + requestData.id) }
        customerData.firstName = requestData.firstName
        customerData.lastName = requestData.lastName
        customerData.email = requestData.email
        customerData.address = requestData.address
        return customerRepository.save(customerData)
    }
    fun findAllCustomers(): List<Customer> = customerRepository.findAll()
    fun findCustomerById(id:String): Customer? {
        return customerRepository.findByIdOrNull(id)
    }
    fun deleteCustomer(id: String): String {
        val customer = customerRepository.findById(id)
        customerRepository.deleteById(id)
        return customer.toString()
    }
}