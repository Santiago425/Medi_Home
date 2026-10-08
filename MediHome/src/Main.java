import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        Paciente paciente = new Paciente();
        paciente.setIdentificacion("1085123456");
        paciente.setNombre("Maria Lopez");
        paciente.setCorreoElectronico("maria.lopez@correo.com");
        paciente.setTelefono("3001234567");
        paciente.setDireccion("Calle 18 # 25-40, Pasto");

        ProfesionalSalud profesional = new ProfesionalSalud();
        profesional.setIdentificacion("98765432");
        profesional.setNombre("Carlos Ruiz");
        profesional.setCorreoElectronico("carlos.ruiz@medihome.com");
        profesional.setNumeroRegistroProfesional("RP-4521");
        profesional.setEspecialidad("Medicina general");

        ServicioDomiciliario servicio = new ServicioDomiciliario();
        servicio.setCodigo("SD-001");
        servicio.setFechaProgramada(LocalDateTime.of(2026, 10, 8, 9, 0));
        servicio.setDireccionAtencion("Calle 18 # 25-40, Pasto");
        servicio.setMotivo("Control de presion arterial");
        servicio.setEstado("Programado");
        servicio.setPaciente(paciente);
        servicio.setProfesionalSalud(profesional);

        AtencionMedica atencion = new AtencionMedica();
        atencion.setFechaHoraInicio(LocalDateTime.of(2026, 10, 8, 9, 10));
        atencion.setFechaHoraFin(LocalDateTime.of(2026, 10, 8, 9, 45));
        atencion.setObservaciones("Paciente estable, presion levemente elevada");
        atencion.setRecomendaciones("Reducir el consumo de sal y control en 15 dias");

        MedicionSignosVitales medicion = new MedicionSignosVitales();
        medicion.setFechaHora(LocalDateTime.of(2026, 10, 8, 9, 15));
        medicion.setTemperatura(36.7);
        medicion.setFrecuenciaCardiaca(78);
        medicion.setPresionSistolica(135);
        medicion.setPresionDiastolica(88);
        medicion.setSaturacionOxigeno(96);

        atencion.getMediciones().add(medicion);
        servicio.setAtencionMedica(atencion);
        servicio.setEstado("Finalizado");

        paciente.notificar("Su servicio " + servicio.getCodigo() + " fue finalizado");
        profesional.notificar("Atencion del servicio " + servicio.getCodigo() + " registrada");

        System.out.println();
        System.out.println("===== REPORTE DE ATENCION =====");
        System.out.println("Servicio: " + servicio.getCodigo());
        System.out.println("Estado: " + servicio.getEstado());
        System.out.println("Fecha programada: " + servicio.getFechaProgramada());
        System.out.println("Direccion de atencion: " + servicio.getDireccionAtencion());
        System.out.println("Motivo: " + servicio.getMotivo());
        System.out.println();
        System.out.println("Paciente: " + servicio.getPaciente().getNombre());
        System.out.println("Identificacion: " + servicio.getPaciente().getIdentificacion());
        System.out.println("Telefono: " + servicio.getPaciente().getTelefono());
        System.out.println();
        System.out.println("Profesional: " + servicio.getProfesionalSalud().getNombre());
        System.out.println("Registro profesional: " + servicio.getProfesionalSalud().getNumeroRegistroProfesional());
        System.out.println("Especialidad: " + servicio.getProfesionalSalud().getEspecialidad());
        System.out.println();
        System.out.println("Inicio de la atencion: " + servicio.getAtencionMedica().getFechaHoraInicio());
        System.out.println("Fin de la atencion: " + servicio.getAtencionMedica().getFechaHoraFin());
        System.out.println("Observaciones: " + servicio.getAtencionMedica().getObservaciones());
        System.out.println("Recomendaciones: " + servicio.getAtencionMedica().getRecomendaciones());
        System.out.println();
        System.out.println("Signos vitales:");
        for (MedicionSignosVitales m : servicio.getAtencionMedica().getMediciones()) {
            System.out.println("Fecha y hora: " + m.getFechaHora());
            System.out.println("Temperatura: " + m.getTemperatura() + " C");
            System.out.println("Frecuencia cardiaca: " + m.getFrecuenciaCardiaca() + " lpm");
            System.out.println("Presion arterial: " + m.getPresionSistolica() + "/" + m.getPresionDiastolica() + " mmHg");
            System.out.println("Saturacion de oxigeno: " + m.getSaturacionOxigeno() + " %");
        }
    }
}
