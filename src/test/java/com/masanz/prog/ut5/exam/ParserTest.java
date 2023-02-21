package com.masanz.prog.ut5.exam;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ParserTest {

    @Test
    @Order(11)
    void testGetGrupoNombre() {
        String xml = """
                <grupo>
                    <nombre>DAW1</nombre>
                    <personas>
                    </personas>
                </grupo>""";
        String nombre = Parser.getGrupoNombre(xml);
        assertEquals("DAW1",nombre);
    }

    @Test
    @Order(21)
    void testGetPersonas1() {
        String xml = """
                <grupo>
                    <nombre>DAW1</nombre>
                    <personas>
                    </personas>
                </grupo>""";
        Persona[] a = Parser.getPersonas(xml);
        assertEquals(0,a.length);
    }

    @Test
    @Order(22)
    void testGetPersonas2() {
        String xml = """
                <grupo>
                    <nombre>DAW1</nombre>
                    <personas>
                        <persona>
                            <nombre>Aiert</nombre>
                            <puntos>55</puntos>
                        </persona>
                    </personas>
                </grupo>""";
        Persona[] a = Parser.getPersonas(xml);
        assertEquals(1,a.length);
        assertEquals("Aiert",a[0].getNombre());
        assertEquals(55,a[0].getPuntos());
    }

    @Test
    @Order(23)
    void testGetPersonas3() {
        String xml = """
                <grupo>
                    <nombre>DAW1</nombre>
                    <personas>
                        <persona>
                            <nombre>Aiert</nombre>
                            <puntos>55</puntos>
                        </persona>
                        <persona>
                            <nombre>Aimar</nombre>
                            <puntos>65</puntos>
                        </persona>
                        <persona>
                            <nombre>Aiora</nombre>
                            <puntos>85</puntos>
                        </persona>
                        <persona>
                            <nombre>Aitor</nombre>
                            <puntos>35</puntos>
                        </persona>
                    </personas>
                </grupo>""";
        Persona[] a = Parser.getPersonas(xml);
        assertEquals(4,a.length);
        assertEquals("Aitor",a[3].getNombre());
        assertEquals(35,a[3].getPuntos());
    }



}