package ejercicio1;

public class Main {
    public static void main(String[] args) {
        Persona persona1 = new Persona("luis", 91);
        Persona persona2 = new Persona("maria", 72);
        Persona persona3 = new Persona("rodolfo", 99);
        Persona persona4 = new Persona("sofia", 100);

        Precedable<Persona> []personas =new Precedable[4];
        personas[0] = persona1;
        personas[1] = persona2;
        personas[2] = persona3;
        personas[3] = persona4;

        SortUtil.ordenar(personas);
        for (int i = 0; i < personas.length; i++) {
            System.out.println(personas[i].toString());
        }

        Celular celular1 = new Celular(1119283746, "luis");
        Celular celular2 = new Celular(1149319087, "maria");
        Celular celular3 = new Celular(1111023824, "rodolfo");
        Celular celular4 = new Celular(1134567819, "sofia");

        Precedable<Celular> []celulares =new Precedable[4];
        celulares[0] = celular1;
        celulares[1] = celular2;
        celulares[2] = celular3;
        celulares[3] = celular4;

        SortUtil.ordenar(celulares);
        for (int i = 0; i < celulares.length; i++) {
            System.out.println(celulares[i].toString());
        }
    }
}
