package clases;

import java.util.ArrayList;

public class FuegoArtificialPack implements FuegoArtificial{

    private ArrayList<FuegoArtificial> fuegoArtificiales = new ArrayList<>();

    public FuegoArtificialPack(ArrayList<FuegoArtificial> fuegoArtificiales) {
        this.fuegoArtificiales = fuegoArtificiales;
    }

    @Override
    public void hacerRuido() {
        for(FuegoArtificial fuegoArtificial : fuegoArtificiales) {
            fuegoArtificial.hacerRuido();
        }
    }


}
