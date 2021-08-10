package com.SpringBootKotlinDemo

import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class DbSeeder(val hotelRepository: HotelRepository) : CommandLineRunner {
    override fun run(vararg args: String?) {
        this.hotelRepository.deleteAll()

        val ibis = Hotel("Ibis", 3, 30)
        val intercontinental = Hotel("Intercontinental", 5, 90)
        val goldenTulip = Hotel("Golden Tulip", 4, 40)

        val hotels = mutableListOf<Hotel>()
        hotels.add(ibis)
        hotels.add(intercontinental)
        hotels.add(goldenTulip)

        this.hotelRepository.saveAll(hotels)
        println("-- Baza danych zainicializowana")
    }
}