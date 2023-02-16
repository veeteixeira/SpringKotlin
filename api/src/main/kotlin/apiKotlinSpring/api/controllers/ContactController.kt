package apiKotlinSpring.api.controllers

import apiKotlinSpring.api.entities.Contact
import apiKotlinSpring.api.repositories.ContactRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.persistence.EntityNotFoundException

@RestController
@RequestMapping("/contacts")
class ContactController {

    @Autowired
    lateinit var repository: ContactRepository

    @GetMapping("/listar")
    fun listarTodos(): List<Contact>{
      return repository.findAll()
    }

    @PostMapping
    fun create(@RequestBody contact: Contact): Contact{
      return repository.save(contact)
    }

    @GetMapping("/{id}")
    fun show(@PathVariable("id")id: Int): Contact{
        return repository.findById(id).orElseThrow{ EntityNotFoundException()}
    }

    @PutMapping("/{id}")
    fun update(@PathVariable("id") id:Int, @RequestBody newContact: Contact){
        val contact = repository.findById(id).orElseThrow{ EntityNotFoundException()}

        contact.apply {
            this.name = newContact.name
            this.email= newContact.email
        }
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable("id") id: Int){
        val contact = repository.findById(id).orElseThrow { EntityNotFoundException() }
        repository.delete(contact)
    }
}