package com.SpringBootKotlinDemo

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Hotel(val name: String, val classification: Int, val nbRooms: Int ) {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 0
    var nbFreeRooms: Int = this.nbRooms

    fun checkIn(nbGuests: Int) {
        if (this.nbFreeRooms >= nbGuests) {
            this.nbFreeRooms -=nbGuests
        }
    }

    fun checkOut(nbGuests: Int){
        this.nbFreeRooms += nbGuests
    }
}