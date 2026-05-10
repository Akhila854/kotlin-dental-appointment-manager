package service

import model.Appointment
import model.Patient

class AppointmentService {

    private val patients = mutableListOf<Patient>()
    private val appointments = mutableListOf<Appointment>()

    fun addPatient(patient: Patient) {
        patients.add(patient)
        println("Patient added successfully")
    }

    fun bookAppointment(appointment: Appointment) {
        appointments.add(appointment)
        println("Appointment booked successfully")
    }

    fun viewAppointments() {

        if (appointments.isEmpty()) {
            println("No appointments found")
        } else {
            appointments.forEach {
                println(it)
            }
        }
    }

    fun searchPatient(id: Int) {

        val patient = patients.find { it.id == id }

        if (patient != null) {
            println(patient)
        } else {
            println("Patient not found")
        }
    }

    fun cancelAppointment(patientId: Int) {

        val removed = appointments.removeIf {
            it.patientId == patientId
        }

        if (removed) {
            println("Appointment cancelled")
        } else {
            println("Appointment not found")
        }
    }
}