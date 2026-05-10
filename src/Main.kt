import model.Patient
import model.Appointment
import service.AppointmentService

fun main() {

    val service = AppointmentService()

    while (true) {

        println("\n=== Dental Appointment System ===")
        println("1. Add Patient")
        println("2. Book Appointment")
        println("3. View Appointments")
        println("4. Search Patient")
        println("5. Cancel Appointment")
        println("6. Exit")

        print("Choose option: ")

        when (readLine()?.toInt()) {

            1 -> {
                print("Enter Patient ID: ")
                val id = readLine()!!.toInt()

                print("Enter Patient Name: ")
                val name = readLine()!!

                print("Enter Patient Age: ")
                val age = readLine()!!.toInt()

                service.addPatient(
                    Patient(id, name, age)
                )
            }

            2 -> {
                print("Enter Patient ID: ")
                val patientId = readLine()!!.toInt()

                print("Enter Doctor Name: ")
                val doctor = readLine()!!

                print("Enter Appointment Date: ")
                val date = readLine()!!

                service.bookAppointment(
                    Appointment(patientId, doctor, date)
                )
            }

            3 -> {
                service.viewAppointments()
            }

            4 -> {
                print("Enter Patient ID: ")
                val id = readLine()!!.toInt()

                service.searchPatient(id)
            }

            5 -> {
                print("Enter Patient ID: ")
                val patientId = readLine()!!.toInt()

                service.cancelAppointment(patientId)
            }

            6 -> {
                println("Exiting...")
                break
            }

            else -> {
                println("Invalid option")
            }
        }
    }
}