/*
Crear un programa para xestionar unha lista de alumnos coas suas notas.
Cada alumno vai ter un nome tipo String e  unha nota tipo Int. Se pide:

•	Crear a lista.
•	Visualizar toda a lista cos distintos métodos
•	Ver a nota dun determinado alumno .
•	Dar de alta un alumno.
•	Dar de baixa un alumno.
•	Consultar se un alumno está na lista.
•	Ordenar a lista por nome utilizando o método sort.

 */

package boletin19;

import java.util.ArrayList;

public class BOLETIN19 {

    public static void main(String[] args) {
    ArrayList<Alumno>alumnos=new ArrayList<Alumno>();
    Alumno.introAlumno(alumnos);
    Alumno.verFor(alumnos);
    Alumno.verForeach(alumnos);
    Alumno.verIterator(alumnos);
    Alumno.verNota(alumnos);
    Alumno.introAlumno(alumnos);
    Alumno.verFor(alumnos);
    Alumno.borraAlumno(alumnos);

    Alumno.verFor(alumnos);
    Alumno.consultaAlumno(alumnos);
    Alumno.ordear(alumnos);
    Alumno.verFor(alumnos);
    }
    
}
