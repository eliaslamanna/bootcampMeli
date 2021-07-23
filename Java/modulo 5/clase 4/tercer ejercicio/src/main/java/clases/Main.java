package clases;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        MarteGroupSA marteGroupSA = new MarteGroupSA();

        FuegoArtificial individual1 = new FuegoArtificialIndividual();
        FuegoArtificial individual2 = new FuegoArtificialIndividual();
        FuegoArtificial individual3 = new FuegoArtificialIndividual();
        FuegoArtificial individual4 = new FuegoArtificialIndividual();

        ArrayList<FuegoArtificial> fuegosArtificiales = new ArrayList<>();
        fuegosArtificiales.add(individual1);
        fuegosArtificiales.add(individual2);
        fuegosArtificiales.add(individual3);
        fuegosArtificiales.add(individual4);

        FuegoArtificial pack1 = new FuegoArtificialPack(fuegosArtificiales);

        marteGroupSA.agregarFuegoArtificial(pack1);
        marteGroupSA.agregarFuegoArtificial(individual1);
        marteGroupSA.agregarFuegoArtificial(individual2);

        marteGroupSA.explotarCohetes();

        System.out.println("-----------------------------");

        Invitado invitadoMeli1 = new InvitadoMeli();
        Invitado invitadoMeli2 = new InvitadoMeli();
        Invitado invitadoMeli3 = new InvitadoMeli();
        Invitado invitadoStandar1 = new InvitadoStandar();
        Invitado invitadoStandar2 = new InvitadoStandar();
        Invitado invitadoStandar3 = new InvitadoStandar();

        marteGroupSA.agregarInvitado(invitadoMeli1);
        marteGroupSA.agregarInvitado(invitadoMeli3);
        marteGroupSA.agregarInvitado(invitadoStandar1);
        marteGroupSA.agregarInvitado(invitadoStandar2);
        marteGroupSA.agregarInvitado(invitadoMeli2);
        marteGroupSA.agregarInvitado(invitadoStandar3);

        marteGroupSA.repartirTorta();

    }

}
