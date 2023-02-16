package apiKotlinSpring.api.entities

import org.hibernate.validator.constraints.br.CPF
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table
import javax.validation.constraints.Email
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

@Entity
@Table(name = "contacts")
class Contact (
    @field:Id
    @field:GeneratedValue(strategy = GenerationType.IDENTITY)
    val id:Int,

    @field:NotNull
    @field:Size(min= 5, max = 80)
    var name:String,

    @field:NotNull
    @field:Email
    var email:String,

    @field:NotNull
    @field:Size(min= 5, max = 10)
    val senha:String,

    @field:NotNull
    @field:CPF
    var cpf:Int,

    @field:NotNull
    private var saldo:Double
)