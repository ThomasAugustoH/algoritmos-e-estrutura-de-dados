package L09MapaDispersao;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class MapaDispersaoTest {

    @Before
    public void setUp() throws Exception {
    }

    /*
        Validar que o método insere um dado novo no mapa de dispersão e consegue localizá-lo
     */
    @Test
    public void testInserirELocalizar(){
        MapaDispersao<Aluno> mapa = new MapaDispersao<>(53);

        Aluno obj1 = new Aluno(12000, "Jean", LocalDate.of(2000, 01, 01));

        mapa.inserir(obj1.getMatricula(), obj1);

        assertEquals(mapa.buscar(12000), obj1);
    }

    /*
        Validar que o método insere mais de um objeto no mapa de dispersão, localizando os diversos objetos
     */
    @Test
    public void testVariosObjetos(){
        MapaDispersao<Aluno> mapa = new MapaDispersao<>(53);

        Aluno obj1 = new Aluno(12000, "Jean", LocalDate.of(2000, 01, 01));
        Aluno obj2 = new Aluno(14000, "Pedro", LocalDate.of(1999, 01, 20));
        Aluno obj3 = new Aluno(12500, "Marta", LocalDate.of(2001, 02, 18));
        Aluno obj4 = new Aluno(13000, "Lucas", LocalDate.of(1998, 11, 25));

        mapa.inserir(obj1.getMatricula(), obj1);
        mapa.inserir(obj2.getMatricula(), obj2);
        mapa.inserir(obj3.getMatricula(), obj3);
        mapa.inserir(obj4.getMatricula(), obj4);

        assertEquals(mapa.buscar(12000), obj1);
        assertEquals(mapa.buscar(14000), obj2);
        assertEquals(mapa.buscar(12500), obj3);
        assertEquals(mapa.buscar(13000), obj4);

    }

    /*
        Validar inserção e busca de objetos quando há colisão
     */
    @Test
    public void testColisao(){
        MapaDispersao<Aluno> mapa = new MapaDispersao<>(53);

        Aluno obj1 = new Aluno(12000, "Jean", LocalDate.of(2000, 01, 01));
        Aluno obj2 = new Aluno(14000, "Pedro", LocalDate.of(1999, 01, 20));
        Aluno obj3 = new Aluno(14226, "Marta", LocalDate.of(2001, 02, 18));
        Aluno obj4 = new Aluno(17180, "Lucas", LocalDate.of(1998, 11, 25));

        mapa.inserir(obj1.getMatricula(), obj1);
        mapa.inserir(obj2.getMatricula(), obj2);
        mapa.inserir(obj3.getMatricula(), obj3);
        mapa.inserir(obj4.getMatricula(), obj4);

        assertEquals(mapa.buscar(12000), obj1);
        assertEquals(mapa.buscar(14000), obj2);
        assertEquals(mapa.buscar(14226), obj3);
        assertEquals(mapa.buscar(17180), obj4);
    }

    @Test
    public void testRemover(){
        MapaDispersao<Aluno> mapa = new MapaDispersao<>(53);

        Aluno obj1 = new Aluno(12000, "Jean", LocalDate.of(2000, 01, 01));
        Aluno obj2 = new Aluno(14000, "Pedro", LocalDate.of(1999, 01, 20));
        Aluno obj3 = new Aluno(14226, "Marta", LocalDate.of(2001, 02, 18));
        Aluno obj4 = new Aluno(17180, "Lucas", LocalDate.of(1998, 11, 25));

        mapa.inserir(obj1.getMatricula(), obj1);
        mapa.inserir(obj2.getMatricula(), obj2);
        mapa.inserir(obj3.getMatricula(), obj3);
        mapa.inserir(obj4.getMatricula(), obj4);

        assertEquals(mapa.buscar(12000), obj1);
        assertEquals(mapa.buscar(14000), obj2);
        assertEquals(mapa.buscar(14226), obj3);
        assertEquals(mapa.buscar(17180), obj4);

        mapa.remover(obj1.getMatricula());

        assertNull(mapa.buscar(12000));
    }
}