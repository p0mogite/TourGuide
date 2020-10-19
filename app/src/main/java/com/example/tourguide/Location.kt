package com.example.tourguide

var NO_NUMBER_PROVIDED: String = "NO_NUMBER_PROVIDED"

class Location constructor(
    var Name: String,
    var District: String,
    var imageResourceId: Int,
    var Description: String,
    var Address: String,
    var Number: String,
    var Coordinate: String
) {
    fun hasNumber(): Boolean {
        return Number != NO_NUMBER_PROVIDED
    }
}