package clases;

import java.util.ArrayList;

public class MarteGroupSA {

    private ArrayList<FuegoArtificial> fuegosArtificiales = new ArrayList<>();
    private ArrayList<Invitado> invitados = new ArrayList<>();

    public void repartirTorta() {
        invitados.stream().forEach(invitado -> {
            invitado.comerTorta();
        });
    }

    public void explotarCohetes() {
        fuegosArtificiales.stream().forEach(fuegoArtificial -> {
            fuegoArtificial.hacerRuido();
        });
    }

    public void agregarInvitado(Invitado invitado) {
        invitados.add(invitado);
    }

    public void agregarFuegoArtificial(FuegoArtificial fuegoArtificial) {
        fuegosArtificiales.add(fuegoArtificial);
    }
}
