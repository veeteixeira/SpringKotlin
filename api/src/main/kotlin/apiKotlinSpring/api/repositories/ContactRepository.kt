package apiKotlinSpring.api.repositories

import apiKotlinSpring.api.entities.Contact
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ContactRepository: JpaRepository<Contact, Int> {
}