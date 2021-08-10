package com.SpringBootKotlinDemo

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/hotels")
class HotelController(val hotelRepository: HotelRepository) {

    fun all(): MutableIterable<Hotel> { return this.hotelRepository.findAll() }

    @GetMapping("/{name}")
    fun byName(@PathVariable(value = "name") name: String) : List<Hotel> {
        val hotelsByName = this.hotelRepository.findByName(name)
        return hotelsByName
    }

    @PostMapping("/chekin")
    fun chekIn(@RequestBody checkInRequest: CheckInRequest) {
        val hotel = this.hotelRepository.findByName(checkInRequest.hotelName).get(0)
        hotel.checkIn((checkInRequest.nbGuests))
        this.hotelRepository.save(hotel)
    }
}