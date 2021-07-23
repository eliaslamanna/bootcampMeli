package clases;

import java.nio.charset.Charset;
import java.util.Random;

public class FuegoArtificialIndividual implements FuegoArtificial{

    @Override
    public void hacerRuido() {
        byte[] array = new byte[7];
        new Random().nextBytes(array);
        String generatedString = new String(array, Charset.forName("UTF-8"));
        System.out.println(generatedString);
    }

}
