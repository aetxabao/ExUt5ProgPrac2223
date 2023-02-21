package com.masanz.prog.ut5.exam;

/**
 * @author Nombre Apellido
 */
public class Parser {

    public static Grupo xml2Grupo(String xml) {
        String nombre = getGrupoNombre(xml);
        Grupo g = new Grupo(nombre);
        Persona[] personas = getPersonas(xml);
        for (Persona persona : personas) {
            g.insercionDirectaOrdenadaPorNombre(persona);
        }
        return g;
    }

    /**
     * Devuelve el nombre del grupo de un texto xml
     * @param xml Documento xml (ver formato)
     * @return nombre del grupo, ej. DAW1
     */
    public static String getGrupoNombre(String xml) {
        //TODO: getGrupoNombre (6p)
        int i = xml.indexOf("<nombre>") + "<nombre>".length();
        int j = xml.indexOf("</nombre>");
        return xml.substring(i,j);
    }

    /**
     * Devuelve un array de personas con la información xml
     * @param xml Texto con formato xml (consultar)
     * @return array de personas. Tamaño mínimo 0, nunca null.
     */
    public static Persona[] getPersonas(String xml) {
        //TODO: getPersonas (20p)
        String nombre, puntos;
        int i, j, n;
        String[] a = xml.split("<persona>");
        n = a.length - 1;
        Persona[] personas = new Persona[n];
        for (int k = 1; k < a.length; k++) {
            i = a[k].indexOf("<nombre>") + "<nombre>".length();
            j = a[k].indexOf("</nombre>");
            nombre = a[k].substring(i,j);
            i = a[k].indexOf("<puntos>") + "<puntos>".length();
            j = a[k].indexOf("</puntos>");
            puntos = a[k].substring(i,j);
            personas[k-1] = new Persona(nombre, Integer.parseInt(puntos));
        }
        return personas;
    }

}
