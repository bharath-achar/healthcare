export class Appointment {
    constructor(
        appointmentId: string,
        appointmentDate: string,
        status: string,
        public pk?: string
    ) { }
}