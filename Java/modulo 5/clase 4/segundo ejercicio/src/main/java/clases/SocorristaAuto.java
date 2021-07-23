package clases;

public class SocorristaAuto implements VehiculoSocorrista<Auto>{

    @Override
    public void socorrer(Auto vehiculo) {
        System.out.println("Socorriendo auto: " + vehiculo.getPatente());
    }

}
