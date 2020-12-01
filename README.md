# Hibernate-exercises

## Casos de uso


#### +traerPersona(long dni):Persona ✅
#### +agregarCliente(String nombre, String apellido, long dni, boolean activo):int // Excepcion por DNI existente ✅
#### +agregarEmpleado(String nombre, String apellido, long dni, int sueldoBase:int // Excepcion por DNI existente ✅
#### +validarNivelDeSatisfaccion(int nivelDeSatisfaccion):boolean // Valida que el nivel de satisfaccion este entre 1 y 5 ✅
#### +agregarLlamada(LocalDate fecha, Cliente cliente, Empleado empleado, int nivelDeSatisfaccion):int ✅
#### +traerClientes():List<Cliente> ✅
#### +traerEmpleados():List<Empleado> ✅
#### +traerLlamada(LocalDate desde, LocalDate hasta):List<Llamada>
#### +traerLlamada(LocalDate desde, LocalDate hasta, int nivelDeSatisfaccion):List<Llamada>
#### +calcularPorcentajeNivelDeSatisfaccionLlamada(LocalDate desde, LocalDate hasta, int nivelDeSatisfaccion):double
#### +traerLlamada(LocalDate desde, LocalDate hasta, Empleado empleado):List<Llamada>
#### +traerLlamada(LocalDate desde, LocalDate hasta, Empleado empleado, int nivelDeSatisfaccion):List<Llamada>
#### +calcularPorcentajeNivelDeSatisfaccionLlamada(LocalDate desde, LocalDate hasta, Empleado empleado, int nivelDeSatisfaccion):double
