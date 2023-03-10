package com.masanz.prog.ut5.exam;

import java.util.Arrays;

/**
 * @author Nombre Apellido
 */
public class Grupo {

    public final int MAX = 25;

    private String nombre;
    private Persona[] personas;
    private int tam;

    /**
     * Inicializa e instancia los atributos.
     * @param nombre del grupo
     */
    public Grupo(String nombre) {
        //TODO: Grupo constructor (6p)
    }


    public String getNombre() {
        return nombre;
    }

    public Persona[] getPersonas() {
        return Arrays.copyOf(personas,tam);
    }

    public Persona[] getArrayCompletoPersonas() {
        return personas;
    }

    public int getTam() {
        return tam;
    }

    public void setPersonasTam(Persona[] personas, int tam) {
        this.personas = personas;
        this.tam = tam;
    }

    /**
     * Devuelve la representación textual del grupo
     * @return texto con el siguiente formato:
     * Se imprime el nombre del grupo y en las siguientes líneas
     * de forma enumerada los nombres y puntuación entre paréntesis.
     * No se imprimen los valores nulos del array de personas. Ej.
     * Grupo: DAW1
     * 1. Aia (12)
     * 2. Aiala (10)
     * 3. Aide (33)
     * 4. Aiert (55)
     */
    public String toString() {
        //TODO: toString (8p)
        return "";
    }

    /**
     * Inserta de forma alfabética ascendente las personas en base a su nombre.
     * Se suponen que todas las personas insertadas anteriormente están ordenadas.
     * Realizar la inserción buscando la posición que le correspondería.
     * No se permite insertar al final y ordenar.
     * @param p Persona a insertar cuyo nombre no está. No hace falta comprobarlo en este método.
     */
    public void insercionDirectaOrdenadaPorNombre(Persona p) {
        //TODO: insercionDirectaOrdenadaPorNombre (8p)
//        //NO VALIDO
//        if (tam<MAX) {
//            personas[tam++] = p;
//        }
    }

    /**
     * Obtiene la posición de una persona en el array de personas.
     * @param nombre de la persona buscado.
     * @return -1 si no está o un índice entre 0 y tam-1 si está.
     */
    public int getPosicionDicotomica(String nombre) {
        //TODO: getPosicionDicotomica (8p)
        return -1;
    }

    /**
     * Devuelve una matriz con los nombres de personas que tiene las columnas indicadas.
     * La forma de completar la matriz es de izquierda (0) a derecha (cols-1) y
     * de arriba (0) a abajo (filas-1) con los nombres del array de personas y con
     * las cadenas vacías necesarias para completar la matriz si es necesario y evitar los null.
     * @param cols número de columnas de la matriz devuelta. Ej. 4
     * @return matriz con los nombres del grupo y cadenas vacías necesarias. Ej.
     * {
     * {"Aia", "Aiala", "Aide", "Aiert"},
     * {"Aimar", "Ainara", "Aingeru", "Ainhize"},
     * {"Ainhoa", "Aiora", "Aitor", "Aitzol"},
     * {"Aiur", "Aizo", "", ""}
     * }
     */
    public String[][] getNombresCols(int cols) {
        //TODO: getNombresCols (12p)
        return new String[0][0];
    }

    /**
     * Imprime los nombres de las personas en las columnas indicadas.
     * La forma de impresión mostraría las primeras posiciones en la última fila escrita.
     * Si se obtiene la matriz de nombres en las mismas columnas, método anterior,
     * primero se imprimiría la última fila.
     * Ver ejemplo de impresión según los valores de la matriz del ejemplo anterior.
     * En las celdas vacías no se debe escribir null.
     * @param cols número de columnas. Ej. 4
     * Aiur      Aizo
     * Ainhoa    Aiora     Aitor     Aitzol
     * Aimar     Ainara    Aingeru   Ainhize
     * Aia       Aiala     Aide      Aiert
     */
    public void printCols(int cols) {
        //TODO: printCols (12p)
    }


    /**
     * Devuelve un array de 0, n o tam personas.
     * Si la persona no existe el array devuelto será de longitud 0, no null.
     * Si hay menos personas que las n solicitadas se devolverá el array de personas sin valores null.
     * Si hay más personas que n, se devolverán las n personas más próximas.
     * Si n/2 es menor que 0 se devolverán n personas a partir de la posición 0.
     * Si la posición del nombre buscado es pos y pos+n/2 es mayor o igual que tam-1 se devolverá las últimas n personas.
     * Sino, hay n/2 personas alrededor de la posición pos y se deben devolver n personas.
     * @param nombre de la persona cerca de la cual se quieren devolver n personas
     * @param n número de las personas que se quiere devolver.
     * @return array con las personas próximas a nombre.
     */
    public Persona[] getCercanos(String nombre, int n) {
        //TODO: getCercanos (20p)
        return new Persona[0];
    }

}
