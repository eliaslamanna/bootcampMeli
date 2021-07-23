package ejercicio2;

public class FigurasUtils {

    public static double areaPromedio (FiguraGeometrica arr[]) {
        double sumaAreas = 0;
        for(int i = 0; i < arr.length; i ++) {
            sumaAreas += arr[i].area();
        }
        return sumaAreas/arr.length;
    }

}
