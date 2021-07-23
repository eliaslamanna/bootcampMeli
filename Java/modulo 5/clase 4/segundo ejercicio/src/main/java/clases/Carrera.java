package clases;

import java.util.List;

public class Carrera {

    private double distancia;
    private int premioEnDolares;
    private String nombre;
    private int cantidadDeVehiculosPermitidos;
    private List<Vehiculo> listaDeVehiculos;
    private SocorristaAuto socorristaAuto;
    private SocorristaMoto socorristaMoto;

    public void darDeAltaAuto(double velocidad,double aceleracion,double anguloDeGiro,String patente) {
        if(listaDeVehiculos.size() < cantidadDeVehiculosPermitidos) {
            listaDeVehiculos.add(new Auto(velocidad, anguloDeGiro, aceleracion, patente));
            System.out.println("Se agrego correctamente el auto");
        }
        else {
            System.out.println("La carrera esta llena");
        }
    }

    public void darDeAltaMoto(double velocidad,double aceleracion,double anguloDeGiro,String patente) {
        if(listaDeVehiculos.size() < cantidadDeVehiculosPermitidos) {
            listaDeVehiculos.add(new Moto(velocidad, anguloDeGiro, aceleracion, patente));
            System.out.println("Se agrego correctamente la moto");
        }
        else {
            System.out.println("La carrera esta llena");
        }
    }

    public void eliminarVehiculo(Vehiculo vehículo) {
        listaDeVehiculos.remove(vehículo);
    }

    public void eliminarVehiculoConPatente(String unaPatente){
        for(Vehiculo vehiculo : listaDeVehiculos) {
            if(vehiculo.getPatente().equals(unaPatente)) {
                listaDeVehiculos.remove(vehiculo);
            }
        }
    }

    public Vehiculo encontrarGanador() {
        double mayorDesempeño = 0;
        Vehiculo puntero = null;
        for(Vehiculo vehiculo : listaDeVehiculos) {
            double desempeñoActual = vehiculo.getVelocidad() * (vehiculo.getAceleracion() / 2) / (vehiculo.getAnguloDeGiro() * (vehiculo.getPeso() - vehiculo.getRuedas() * 100));
            if( desempeñoActual > mayorDesempeño) {
                mayorDesempeño = desempeñoActual;
                puntero = vehiculo;
            }
        }
        return puntero;
    }

    public void socorrerAuto(String patente) {
        for(Vehiculo vehiculo : listaDeVehiculos) {
            if(vehiculo.getPatente().equals(patente) && vehiculo.getRuedas() == 4) {
                socorristaAuto.socorrer( (Auto) vehiculo);
            }
        }
    }

    public void socorrerMoto(String patente) {
        for(Vehiculo vehiculo : listaDeVehiculos) {
            if(vehiculo.getPatente().equals(patente) && vehiculo.getRuedas() == 2) {
                socorristaMoto.socorrer( (Moto) vehiculo);
            }
        }
    }


}
