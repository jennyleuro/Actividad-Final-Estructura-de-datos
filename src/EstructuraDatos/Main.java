package EstructuraDatos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {

        ArrayList<Persona> listaPersonas = new ArrayList();
        ArrayList<Persona> colaTriageUno = new ArrayList();
        ArrayList<Persona> colaTriageDos = new ArrayList();
        ArrayList<Persona> colaTriageTres = new ArrayList();
        Modulo1 modulo1 = new Modulo1();
        Modulo2 modulo2 = new Modulo2();
        Modulo3 modulo3 = new Modulo3();
        int id;

        for (int i = 0; i < 150; i++) {
            Persona nuevaPersona = new Persona();
            nuevaPersona.setId(i);
            nuevaPersona.setTriage((int) Math.round(Math.random() * (3 - 1) + 1));
            nuevaPersona.setTiempoLlegada((int) Math.round(Math.random() * (150 - 1) + 1));
            nuevaPersona.setTiempoEjecucion((int) Math.round(Math.random() * (5 - 1) + 1));
            listaPersonas.add(nuevaPersona);
        }
        Comparator<Integer> comparador = Collections.reverseOrder();

        Collections.sort(listaPersonas, new Comparator<Persona>() {
            @Override
            public int compare(Persona p1, Persona p2) {
                return new Integer(p1.getTiempoLlegada()).compareTo(new Integer(p2.getTiempoLlegada()));
            }
        });

        for (Persona persona : listaPersonas) {
            if (persona.getTriage() == 1) {
                colaTriageUno.add(persona);
            } else if (persona.getTriage() == 2) {
                colaTriageDos.add(persona);
            } else if (persona.getTriage() == 3) {
                colaTriageTres.add(persona);
            }
        }

        int time = 0, i = 0, tiempoFinalM1 = 0, tiempoFinalM2 = 0, tiempoFinalM3 = 0;

        while (!colaTriageUno.isEmpty() || !colaTriageDos.isEmpty() || !colaTriageTres.isEmpty()) {

            // Modulo 1 y 2 atienden prioridades 1 y 2, Modulo 3 cualquier prioridad.

            if (tiempoFinalM1 == time){
                modulo1.setEstado("Desocupado");
            }
            if (tiempoFinalM2 == time){
                modulo2.setEstado("Desocupado");
            }
            if (tiempoFinalM3 == time){
                modulo3.setEstado("Desocupado");
            }

            if(!colaTriageUno.isEmpty()){
                if (colaTriageUno.get(i).getTiempoLlegada() <= time) {
                    if (modulo1.getEstado().equals("Desocupado")) {
                        tiempoFinalM1 = modulo1.ocupado(time, colaTriageUno.get(i).getTiempoEjecucion());
                        id = colaTriageUno.get(i).getId();
                        for(Persona persona: listaPersonas){
                            if(persona.getId() == id){
                                persona.setTiempoFinal(tiempoFinalM1);
                                persona.setTiempoInicio(time);
                                persona.setModuloAtencion(1);
                            }
                        }
                        colaTriageUno.remove(i);
                    } else if (modulo2.getEstado().equals("Desocupado")) {
                        tiempoFinalM2 = modulo2.ocupado(time, colaTriageUno.get(i).getTiempoEjecucion());
                        id = colaTriageUno.get(i).getId();
                        for(Persona persona: listaPersonas){
                            if(persona.getId() == id){
                                persona.setTiempoFinal(tiempoFinalM2);
                                persona.setTiempoInicio(time);
                                persona.setModuloAtencion(2);
                            }
                        }
                        colaTriageUno.remove(i);
                    } else if (modulo3.getEstado().equals("Desocupado")) {
                        tiempoFinalM3 = modulo3.ocupado(time, colaTriageUno.get(i).getTiempoEjecucion());
                        id = colaTriageUno.get(i).getId();
                        for(Persona persona: listaPersonas){
                            if(persona.getId() == id){
                                persona.setTiempoFinal(tiempoFinalM3);
                                persona.setTiempoInicio(time);
                                persona.setModuloAtencion(3);
                            }
                        }
                        colaTriageUno.remove(i);
                    }
                }
            }
            if(!colaTriageDos.isEmpty()){
                if (colaTriageDos.get(i).getTiempoLlegada() <= time) {
                    if (modulo1.getEstado().equals("Desocupado")) {
                        tiempoFinalM1 = modulo1.ocupado(time, colaTriageDos.get(i).getTiempoEjecucion());
                        id = colaTriageDos.get(i).getId();
                        for(Persona persona: listaPersonas){
                            if(persona.getId() == id){
                                persona.setTiempoFinal(tiempoFinalM1);
                                persona.setTiempoInicio(time);
                                persona.setModuloAtencion(1);
                            }
                        }
                        colaTriageDos.remove(i);
                    } else if (modulo2.getEstado().equals("Desocupado")) {
                        tiempoFinalM2 = modulo2.ocupado(time, colaTriageDos.get(i).getTiempoEjecucion());
                        id = colaTriageDos.get(i).getId();
                        for(Persona persona: listaPersonas){
                            if(persona.getId() == id){
                                persona.setTiempoFinal(tiempoFinalM2);
                                persona.setTiempoInicio(time);
                                persona.setModuloAtencion(2);
                            }
                        }
                        colaTriageDos.remove(i);
                    } else if (modulo3.getEstado().equals("Desocupado")) {
                        tiempoFinalM3 = modulo3.ocupado(time, colaTriageDos.get(i).getTiempoEjecucion());
                        id = colaTriageDos.get(i).getId();
                        for(Persona persona: listaPersonas){
                            if(persona.getId() == id){
                                persona.setTiempoFinal(tiempoFinalM3);
                                persona.setTiempoInicio(time);
                                persona.setModuloAtencion(3);
                            }
                        }
                        colaTriageDos.remove(i);
                    }
                }
            }
            if(!colaTriageTres.isEmpty()){
                if (colaTriageTres.get(i).getTiempoLlegada() <= time) {
                    if (modulo3.getEstado().equals("Desocupado")) {
                        tiempoFinalM3 = modulo3.ocupado(time, colaTriageTres.get(i).getTiempoEjecucion());
                        id = colaTriageTres.get(i).getId();
                        for(Persona persona: listaPersonas){
                            if(persona.getId() == id){
                                persona.setTiempoFinal(tiempoFinalM3);
                                persona.setTiempoInicio(time);
                                persona.setModuloAtencion(3);
                            }
                        }
                        colaTriageTres.remove(i);
                    }
                }
            }
            time++;
        }

        System.out.println("\n INFORMACIÓN DE LOS PACIENTES TRATADOS: ");
        for(Persona persona: listaPersonas){
            System.out.println("Id: " + persona.getId());
            System.out.println("Triage: " + persona.getTriage());
            System.out.println("Tiempo de llegada: " + persona.getTiempoLlegada());
            System.out.println("Tiempo de inicio: " + persona.getTiempoInicio());
            System.out.println("Tiempo de ejecución: " + persona.getTiempoEjecucion());
            System.out.println("Modulo en que fue atendido: " + persona.getModuloAtencion());
            System.out.println("Tiempo final: " + persona.getTiempoFinal());
            System.out.println("Tiempo de espera en ser atendido: " + (persona.getTiempoInicio()-persona.getTiempoLlegada()+ "\n"));
        }
    }
}