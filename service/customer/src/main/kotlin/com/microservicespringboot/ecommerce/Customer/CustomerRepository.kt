package com.microservicespringboot.ecommerce.Customer

import org.springframework.data.mongodb.repository.MongoRepository

interface CustomerRepository : MongoRepository<Customer, String> {

}