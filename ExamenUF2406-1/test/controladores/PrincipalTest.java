package controladores;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import modelo.Envio;
import modelo.Repostaje;

class PrincipalTest {

	@Test
	void insertarRepostajeTest() {
		List<Repostaje> lista = new ArrayList<>();
		Principal pp = new Principal();
		
		assertIterableEquals(lista, pp.listaRepostajes);
		
		Repostaje r = new Repostaje("","","",
		         new Envio("Gasolina", 1.794),
		         30, true,false,false);
		
		pp.insertarRepostaje(r);
		lista.add(r);
		assertIterableEquals(lista, pp.listaRepostajes);
		
	}

}
