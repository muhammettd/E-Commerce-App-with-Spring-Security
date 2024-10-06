package com.app.eticaret.model

import jakarta.persistence.*

@Entity
data class Product(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id:Long? = null,
    val name:String? = null,
    val price:Double? = null,
    val category:String? = null

) {
    constructor() : this(null, null, null, null)
}




