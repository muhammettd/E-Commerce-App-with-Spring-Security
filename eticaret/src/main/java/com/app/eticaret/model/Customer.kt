package com.app.eticaret.model

import jakarta.persistence.*

@Entity
@Table(name = "customer")
data class Customer(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id:Long? = null,
    var mail:String? = null,
    var firstName:String? = null,
    var lastName:String? = null,

) {
    constructor() : this(null, null, null, null)
}






