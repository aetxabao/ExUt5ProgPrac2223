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
        return "";
    }

    /**
     * Devuelve un array de personas con la información xml
     * @param xml Texto con formato xml (consultar)
     * @return array de personas. Tamaño mínimo 0, nunca null.
     */
    public static Persona[] getPersonas(String xml) {
        //TODO: getPersonas (20p)
        return new Persona[0];
    }

}
