package clases;

public class StringUtil
{
    // Retorna una cadena compuesta por n caracteres c
    // Ejemplo: replicate('x',5) ==> 'xxxxx'
    public static String replicate(char c,int n)
    {
        String str = "";
        for(int i = 0; i < n; i ++) {
            str += String.valueOf(c);
        }
        return str;
    }

    // Retorna una cadena de longitud n, compuesta por s
    // y precedida de tantos caracteres c como sea necesario
    // para completar la longitud mencionada
    // Ejemplo lpad("5",3,'0') ==> "005"
    public static String lpad(String s, int n, char c)
    {
        String relleno = replicate(c, n - s.length());
        return relleno + s;
    }

    // Retorna un String[] conteniendo los elementos de arr
    // representados como cadenas de caracteres
    public static String[] toStringArray(int arr[])
    {
        String[] cadenaConvertida = new String[arr.length];
        for(int i = 0; i < arr.length; i ++) {
            cadenaConvertida[i] = String.valueOf(arr[i]);
        }
        return cadenaConvertida;
    }

    // Retorna un int[] conteniendo los elementos de arr
    // representados como cadenas de enteros
    public static int[] toIntArray(String arr[])
    {
        int[] cadenaConvertida = new int[arr.length];
        for(int i = 0; i < arr.length; i ++) {
            cadenaConvertida[i] = Integer.valueOf(arr[i]);
        }
        return cadenaConvertida;
    }

    // Retorna la longitud del elemento con mayor cantidad
    // de caracteres del array arr
    public static int maxLength(String arr[])
    {
        int mayor = 0;
        for(int i = 0; i < arr.length; i ++) {
            if(arr[i].length() > mayor) {
                mayor = arr[i].length();
            }
        }
        return mayor;
    }

    // Completa los elemento del arr agregando caracteres c
    // a la izquierda, dejando a todos con la longitud del mayor
    public static void lNormalize(String arr[], char c)
    {
        int mayorLargo = maxLength(arr);
        for(int i = 0; i < arr.length; i ++) {
            arr[i] = lpad(arr[i], mayorLargo, c);
        }
    }
}
