package com.masanz.prog.ut5.exam;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class GrupoTest {

    @Test
    @Order(11)
    void testConstructor() {
        Grupo g = new Grupo("DAW1");
        assertEquals("DAW1", g.getNombre());
        assertEquals(0, g.getTam());
        assertNotNull(g.getPersonas());
        assertEquals(g.MAX, g.getArrayCompletoPersonas().length);
    }

    @Test
    @Order(21)
    void testToString1() {
        Grupo g = new Grupo("DAW1");
        String res = g.toString();
        assertEquals("Grupo: DAW1", res.trim());
    }

    @Test
    @Order(22)
    void testToString2() {
        String exp = """
                Grupo: DAW1
                1. Aia (12)
                2. Aiala (10)
                3. Aide (33)
                4. Aiert (55)
                5. Aimar (65)""";
        Grupo g = new Grupo("DAW1");
        g.setPersonasTam(new Persona[]{
                new Persona("Aia",12),
                new Persona("Aiala",10),
                new Persona("Aide",33),
                new Persona("Aiert",55),
                new Persona("Aimar",65),
                null, null, null, null, null
                 },5);
        String res = g.toString();
        assertEquals(exp.trim(), res.trim());
    }

    @Test
    @Order(31)
    void testInsercionDirectaOrdenadaPorNombre1() {
        Persona[] a = new Persona[]{
                new Persona("Aide",33),
                new Persona("Aiala",10),
                new Persona("Aia",12),
                new Persona("Aiert",55),
                new Persona("Aitzol",85),
                new Persona("Aitor",50)
        };
        String[] res = {
                "Grupo: DAW1\n1. Aide (33)",
                "Grupo: DAW1\n1. Aiala (10)\n2. Aide (33)",
                "Grupo: DAW1\n1. Aia (12)\n2. Aiala (10)\n3. Aide (33)",
                "Grupo: DAW1\n1. Aia (12)\n2. Aiala (10)\n3. Aide (33)\n4. Aiert (55)",
                "Grupo: DAW1\n1. Aia (12)\n2. Aiala (10)\n3. Aide (33)\n4. Aiert (55)\n5. Aitzol (85)",
                "Grupo: DAW1\n1. Aia (12)\n2. Aiala (10)\n3. Aide (33)\n4. Aiert (55)\n5. Aitor (50)\n6. Aitzol (85)"
        };
        Grupo g = new Grupo("DAW1");
        for (int i = 0; i < a.length; i++) {
            g.insercionDirectaOrdenadaPorNombre(a[i]);
            //System.out.println(g);
            assertEquals(res[i],g.toString().trim());
        }
    }

    @Test
    @Order(32)
    void testInsercionDirectaOrdenadaPorNombre2() {
        Persona[] a = new Persona[]{
            new Persona("Aiert", 55),
            new Persona("Aimar", 65),
            new Persona("Aiora", 85),
            new Persona("Aitor", 35),
            new Persona("Aitzol", 60),
            new Persona("Aingeru", 37),
            new Persona("Ainara", 99),
            new Persona("Aiur", 25),
            new Persona("Aide", 33),
            new Persona("Ainhoa", 91),
            new Persona("Aiala", 10),
            new Persona("Ainhize", 82),
            new Persona("Aia", 12),
            new Persona("Aizo", 97)
        };
        String exp = """
                Grupo: DAW1
                1. Aia (12)
                2. Aiala (10)
                3. Aide (33)
                4. Aiert (55)
                5. Aimar (65)
                6. Ainara (99)
                7. Aingeru (37)
                8. Ainhize (82)
                9. Ainhoa (91)
                10. Aiora (85)
                11. Aitor (35)
                12. Aitzol (60)
                13. Aiur (25)
                14. Aizo (97)""";
        Grupo g = new Grupo("DAW1");
        for (Persona persona : a) {
            g.insercionDirectaOrdenadaPorNombre(persona);
        }
        assertEquals(exp, g.toString().trim());
    }

    @Test
    @Order(41)
    void testGetPosicionDicotomica() {
        Persona[] a = new Persona[]{
                new Persona("Aia", 12),
                new Persona("Aiala", 10),
                new Persona("Aide", 33),
                new Persona("Aiert", 55),
                new Persona("Aimar", 65),
                new Persona("Ainara", 99),
                new Persona("Aingeru", 37),
                new Persona("Ainhize", 82),
                new Persona("Ainhoa", 91),
                new Persona("Aiora", 85),
                new Persona("Aitor", 35),
                new Persona("Aitzol", 60),
                new Persona("Aiur", 25),
                new Persona("Aizo", 97), null,
                null,null,null,null,null,null,null,null,null,null,
        };
        Grupo g = new Grupo("DAW1");
        g.setPersonasTam(a, 14);
        String[] nombres = {"Aia", "Aizo", "Aiala", "Aimar", "Ainara", "Aingeru", "Aiur"};
        int[] posiciones = {0, 13, 1, 4, 5, 6, 12};
        for (int i = 0; i < nombres.length; i++) {
            assertEquals(posiciones[i], g.getPosicionDicotomica(nombres[i]), nombres[i] + " ---> " + posiciones[i]);
        }
        nombres = new String[] {"Aintzira", "Aitziber", "Ainuk", "Airea"};
        for (String nombre : nombres) {
            assertEquals(-1, g.getPosicionDicotomica(nombre), nombre + " no está.");
        }
    }


    @Test
    @Order(51)
    void testGetNombresCols1() {
        Persona[] a = {
                new Persona("Aia", 12),
                new Persona("Aiala", 10),
                new Persona("Aide", 33),
                new Persona("Aiert", 55),
                new Persona("Aimar", 65),
                null,null,null,null,null
        };
        Grupo g = new Grupo("OTRO");
        g.setPersonasTam(a, 5);
        int n = 1;
        String[][] exp = {
                {"Aia"}, {"Aiala"},
                {"Aide"}, {"Aiert"},
                {"Aimar"} };
        String[][] res = g.getNombresCols(n);
        assertEquals(exp.length,res.length);
        assertEquals(exp[0].length,res[0].length);
        for (int i = 0; i < exp.length && i < res.length; i++) {
            assertEquals(Arrays.toString(exp[i]),Arrays.toString(res[i]));
        }
    }


    @Test
    @Order(52)
    void testGetNombresCols2() {
        Persona[] a = {
                new Persona("Aia", 12),
                new Persona("Aiala", 10),
                new Persona("Aide", 33),
                new Persona("Aiert", 55),
                new Persona("Aimar", 65),
                null,null,null,null,null
        };
        Grupo g = new Grupo("OTRO");
        g.setPersonasTam(a, 5);
        int n = 2;
        String[][] exp = {
                {"Aia", "Aiala"},
                {"Aide", "Aiert"},
                {"Aimar", ""} };
        String[][] res = g.getNombresCols(n);
        assertEquals(exp.length,res.length);
        assertEquals(exp[0].length,res[0].length);
        for (int i = 0; i < exp.length && i < res.length; i++) {
            assertEquals(Arrays.toString(exp[i]),Arrays.toString(res[i]));
        }
    }

    @Test
    @Order(53)
    void testGetNombresCols3() {
        Persona[] a = {
                new Persona("Aia", 12),
                new Persona("Aiala", 10),
                new Persona("Aide", 33),
                new Persona("Aiert", 55),
                new Persona("Aimar", 65),
                null,null,null,null,null
        };
        Grupo g = new Grupo("OTRO");
        g.setPersonasTam(a, 5);
        int n = 3;
        String[][] exp = {
                {"Aia", "Aiala", "Aide"},
                {"Aiert", "Aimar", ""} };
        String[][] res = g.getNombresCols(n);
        assertEquals(exp.length,res.length);
        assertEquals(exp[0].length,res[0].length);
        for (int i = 0; i < exp.length && i < res.length; i++) {
            assertEquals(Arrays.toString(exp[i]),Arrays.toString(res[i]));
        }
    }

    @Test
    @Order(55)
    void testGetNombresCols5() {
        Persona[] a = {
                new Persona("Aia", 12),
                new Persona("Aiala", 10),
                new Persona("Aide", 33),
                new Persona("Aiert", 55),
                new Persona("Aimar", 65),
                null,null,null,null,null
        };
        Grupo g = new Grupo("OTRO");
        g.setPersonasTam(a, 5);
        int n = 5;
        String[][] exp = { {"Aia", "Aiala", "Aide", "Aiert", "Aimar"} };
        String[][] res = g.getNombresCols(n);
        assertEquals(exp.length,res.length);
        assertEquals(exp[0].length,res[0].length);
        for (int i = 0; i < exp.length && i < res.length; i++) {
            assertEquals(Arrays.toString(exp[i]),Arrays.toString(res[i]));
        }
    }

    @Test
    @Order(56)
    void testGetNombresCols6() {
        Persona[] a = {
                new Persona("Aia", 12),
                new Persona("Aiala", 10),
                new Persona("Aide", 33),
                new Persona("Aiert", 55),
                new Persona("Aimar", 65),
                null,null,null,null,null
        };
        Grupo g = new Grupo("OTRO");
        g.setPersonasTam(a, 5);
        int n = 6;
        String[][] exp = { {"Aia", "Aiala", "Aide", "Aiert", "Aimar", ""} };
        String[][] res = g.getNombresCols(n);
        assertEquals(exp.length,res.length);
        assertEquals(exp[0].length,res[0].length);
        for (int i = 0; i < exp.length && i < res.length; i++) {
            assertEquals(Arrays.toString(exp[i]),Arrays.toString(res[i]));
        }
    }

    @Test
    @Order(61)
    void testPrintCols1() {
        //BEFORE
        PrintStream standardOut = System.out;
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));

        Persona[] a = {
                new Persona("Aia", 12),
                new Persona("Aiala", 10),
                new Persona("Aide", 33),
                new Persona("Aiert", 55),
                new Persona("Aimar", 65),
                null,null,null,null,null
        };
        Grupo g = new Grupo("OTRO");
        g.setPersonasTam(a, 5);
        int n = 2;
        g.printCols(n);
        int i = 0;
        String[] exp = {
                "Aimar               ",
                "Aide      Aiert     ",
                "Aia       Aiala     "
        };
        String s = outputStreamCaptor.toString();
        assertTrue(s.trim().length()>0);
        Scanner sc = new Scanner(s);
        sc.useDelimiter(Pattern.compile("[\\r\\n;]+"));
        while (sc.hasNext()) {
            assertEquals(exp[i++].trim(),sc.next().trim());
        }
        //AFTER
        System.setOut(standardOut);
    }

    @Test
    @Order(62)
    void testPrintCols2() {
        //BEFORE
        PrintStream standardOut = System.out;
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));

        Persona[] a = {
                new Persona("Aia", 12),
                new Persona("Aiala", 10),
                new Persona("Aide", 33),
                new Persona("Aiert", 55),
                new Persona("Aimar", 65),
                null,null,null,null,null
        };
        Grupo g = new Grupo("OTRO");
        g.setPersonasTam(a, 5);
        int n = 4;
        g.printCols(n);
        int i = 0;
        String[] exp = {
                "Aimar                                   ",
                "Aia       Aiala     Aide      Aiert     "
        };
        String s = outputStreamCaptor.toString();
        assertTrue(s.trim().length()>0);
        Scanner sc = new Scanner(s);
        sc.useDelimiter(Pattern.compile("[\\r\\n;]+"));
        while (sc.hasNext()) {
            assertEquals(exp[i++].trim(),sc.next().trim());
        }
        //AFTER
        System.setOut(standardOut);
    }

    @Test
    @Order(63)
    void testPrintCols3() {
        //BEFORE
        PrintStream standardOut = System.out;
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));

        Persona[] a = {
                new Persona("Aia", 12),
                new Persona("Aiala", 10),
                new Persona("Aide", 33),
                new Persona("Aiert", 55),
                new Persona("Aimar", 65),
                null,null,null,null,null
        };
        Grupo g = new Grupo("OTRO");
        g.setPersonasTam(a, 5);
        int n = 6;
        g.printCols(n);
        int i = 0;
        String[] exp = {
                "Aia       Aiala     Aide      Aiert     Aimar               "
        };
        String s = outputStreamCaptor.toString();
        assertTrue(s.trim().length()>0);
        Scanner sc = new Scanner(s);
        sc.useDelimiter(Pattern.compile("[\\r\\n;]+"));
        while (sc.hasNext()) {
            assertEquals(exp[i++].trim(),sc.next().trim());
        }
        //AFTER
        System.setOut(standardOut);
    }

    String getCercanosLine(String nombre) {
        Persona[] a = new Persona[]{
                new Persona("Aia", 12),
                new Persona("Aiala", 10),
                new Persona("Aide", 33),
                new Persona("Aiert", 55),
                new Persona("Aimar", 65),
                new Persona("Ainara", 99),
                new Persona("Aingeru", 37),
                new Persona("Ainhize", 82),
                new Persona("Ainhoa", 91),
                new Persona("Aiora", 85),
                new Persona("Aitor", 35),
                new Persona("Aitzol", 60),
                new Persona("Aiur", 25),
                new Persona("Aizo", 97), null,
                null,null,null,null,null,null,null,null,null,null,
        };
        Grupo g = new Grupo("DAW1");
        g.setPersonasTam(a, 14);
        int n = 5;
        Persona[] r = g.getCercanos(nombre, n);
        StringBuilder sb = new StringBuilder();
        for (Persona p : r) sb.append(String.format("%-10s",p.getNombre()));
        return sb.toString();
    }

    @Test
    @Order(71)
    void testGetCercanos1() {
        String nombre = "Aia";
        String exp = "Aia       Aiala     Aide      Aiert     Aimar     ";
        String res = getCercanosLine(nombre);
        assertEquals(exp, res);
    }

    @Test
    @Order(72)
    void testGetCercanos2() {
        String nombre = "Aiala";
        String exp = "Aia       Aiala     Aide      Aiert     Aimar     ";
        String res = getCercanosLine(nombre);
        assertEquals(exp, res);
    }

    @Test
    @Order(73)
    void testGetCercanos3() {
        String nombre = "Aitzol";
        String exp = "Aiora     Aitor     Aitzol    Aiur      Aizo      ";
        String res = getCercanosLine(nombre);
        assertEquals(exp, res);
    }

    @Test
    @Order(74)
    void testGetCercanos4() {
        String nombre = "Aizo";
        String exp = "Aiora     Aitor     Aitzol    Aiur      Aizo      ";
        String res = getCercanosLine(nombre);
        assertEquals(exp, res);
    }

    @Test
    @Order(75)
    void testGetCercanos5() {
        String nombre = "Aide";
        String exp = "Aia       Aiala     Aide      Aiert     Aimar     ";
        String res = getCercanosLine(nombre);
        assertEquals(exp, res);
    }

    @Test
    @Order(76)
    void testGetCercanos6() {
        String nombre = "Aiert";
        String exp = "Aiala     Aide      Aiert     Aimar     Ainara    ";
        String res = getCercanosLine(nombre);
        assertEquals(exp, res);
    }

    @Test
    @Order(77)
    void testGetCercanos7() {
        String nombre = "Aimar";
        String exp = "Aide      Aiert     Aimar     Ainara    Aingeru   ";
        String res = getCercanosLine(nombre);
        assertEquals(exp, res);
    }

}