package com.masanz.prog.ut5.exam;

public class Demo {

    public static void main(String[] args) {
        String xml = "<grupo>\n" +
                "    <nombre>DAW1</nombre>\n" +
                "    <personas>\n" +
                "        <persona>\n" +
                "            <nombre>Aiert</nombre>\n" +
                "            <puntos>55</puntos>\n" +
                "        </persona>\n" +
                "        <persona>\n" +
                "            <nombre>Aimar</nombre>\n" +
                "            <puntos>65</puntos>\n" +
                "        </persona>\n" +
                "        <persona>\n" +
                "            <nombre>Aiora</nombre>\n" +
                "            <puntos>85</puntos>\n" +
                "        </persona>\n" +
                "        <persona>\n" +
                "            <nombre>Aitor</nombre>\n" +
                "            <puntos>35</puntos>\n" +
                "        </persona>\n" +
                "        <persona>\n" +
                "            <nombre>Aitzol</nombre>\n" +
                "            <puntos>60</puntos>\n" +
                "        </persona>\n" +
                "        <persona>\n" +
                "            <nombre>Aingeru</nombre>\n" +
                "            <puntos>37</puntos>\n" +
                "        </persona>\n" +
                "        <persona>\n" +
                "            <nombre>Ainara</nombre>\n" +
                "            <puntos>99</puntos>\n" +
                "        </persona>\n" +
                "        <persona>\n" +
                "            <nombre>Aiur</nombre>\n" +
                "            <puntos>25</puntos>\n" +
                "        </persona>\n" +
                "        <persona>\n" +
                "            <nombre>Aide</nombre>\n" +
                "            <puntos>33</puntos>\n" +
                "        </persona>\n" +
                "        <persona>\n" +
                "            <nombre>Ainhoa</nombre>\n" +
                "            <puntos>91</puntos>\n" +
                "        </persona>\n" +
                "        <persona>\n" +
                "            <nombre>Aiala</nombre>\n" +
                "            <puntos>10</puntos>\n" +
                "        </persona>\n" +
                "        <persona>\n" +
                "            <nombre>Ainhize</nombre>\n" +
                "            <puntos>82</puntos>\n" +
                "        </persona>\n" +
                "        <persona>\n" +
                "            <nombre>Aia</nombre>\n" +
                "            <puntos>12</puntos>\n" +
                "        </persona>\n" +
                "        <persona>\n" +
                "            <nombre>Aizo</nombre>\n" +
                "            <puntos>97</puntos>\n" +
                "        </persona>\n" +
                "    </personas>\n" +
                "</grupo>";
        Grupo g = Parser.xml2Grupo(xml);
        System.out.println(g);
        System.out.println("-".repeat(60));
        int pos;
        String nombre;
        nombre = "Aia";
        pos = g.getPosicionDicotomica(nombre);
        System.out.println("Posición en el array de " + nombre + ": " + pos);
        nombre = "Aizo";
        pos = g.getPosicionDicotomica(nombre);
        System.out.println("Posición en el array de " + nombre + ": " + pos);
        nombre = "Aiala";
        pos = g.getPosicionDicotomica(nombre);
        System.out.println("Posición en el array de " + nombre + ": " + pos);
        nombre = "Aimar";
        pos = g.getPosicionDicotomica(nombre);
        System.out.println("Posición en el array de " + nombre + ": " + pos);
        nombre = "Ainara";
        pos = g.getPosicionDicotomica(nombre);
        System.out.println("Posición en el array de " + nombre + ": " + pos);
        nombre = "Aingeru";
        pos = g.getPosicionDicotomica(nombre);
        System.out.println("Posición en el array de " + nombre + ": " + pos);
        nombre = "Aiur";
        pos = g.getPosicionDicotomica(nombre);
        System.out.println("Posición en el array de " + nombre + ": " + pos);
        System.out.println("-".repeat(60));
        g.printCols(1);
        System.out.println("-".repeat(60));
        g.printCols(2);
        System.out.println("-".repeat(60));
        g.printCols(3);
        System.out.println("-".repeat(60));
        g.printCols(4);
        System.out.println("-".repeat(60));
        g.printCols(5);
        System.out.println("-".repeat(60));
        g.printCols(6);
        System.out.println("-".repeat(60));
        Persona[] a;
        int n = 5;
        nombre = "Aia";
        a = g.getCercanos(nombre, n);
        for (Persona p : a) System.out.printf("%-10s",p.getNombre());
        System.out.println();
        System.out.println("-".repeat(60));
        nombre = "Aiala";
        a = g.getCercanos(nombre, n);
        for (Persona p : a) System.out.printf("%-10s",p.getNombre());
        System.out.println();
        System.out.println("-".repeat(60));
        nombre = "Aitzol";
        a = g.getCercanos(nombre, n);
        for (Persona p : a) System.out.printf("%-10s",p.getNombre());
        System.out.println();
        System.out.println("-".repeat(60));
        nombre = "Aizo";
        a = g.getCercanos(nombre, n);
        for (Persona p : a) System.out.printf("%-10s",p.getNombre());
        System.out.println();
        System.out.println("-".repeat(60));
        nombre = "Aide";
        a = g.getCercanos(nombre, n);
        for (Persona p : a) System.out.printf("%-10s",p.getNombre());
        System.out.println();
        System.out.println("-".repeat(60));
        nombre = "Aiert";
        a = g.getCercanos(nombre, n);
        for (Persona p : a) System.out.printf("%-10s",p.getNombre());
        System.out.println();
        System.out.println("-".repeat(60));
        nombre = "Aimar";
        a = g.getCercanos(nombre, n);
        for (Persona p : a) System.out.printf("%-10s",p.getNombre());
        System.out.println();
        System.out.println("-".repeat(60));
    }

}
