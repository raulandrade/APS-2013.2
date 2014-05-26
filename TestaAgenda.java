import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

public class TestaAgenda {
	
		
		@Test
		public void AgendaTest() {
			Agenda agenda = new Agenda();
			
			try{
				agenda.adicionarContato("Raul", "111");
			}catch (ContatoExistenteException exc){
				fail("O contato Raul não foi adicinado.");
			}
			
			try{
				assertEquals(agenda.pesquisarContato("Raul").getNome(), "Raul");
			} catch  (ContatoInexistenteException exc){
				fail("O contato Raul não foi encontrado.");
			}
						
			try{
				agenda.removerContato("Raul");
			} catch (ContatoInexistenteException excecao1){
				fail("O contato Raul não foi encontrado para ser removido.");
			
			}
			
			try{
				assertEquals(agenda.pesquisarContato("Raul").getNome(), "Raul");
				fail("Removeu um contato que não existe.");
			} catch  (ContatoInexistenteException excecao){		
			}
			
			try{
				agenda.adicionarContato("Raul", "1111");
				agenda.adicionarContato("Ayla", "2222");
			} catch (ContatoExistenteException excecao){
				fail("Erro ao adicionar os contatos Ayla e Raul");
			}
			
			Iterator <Contato> contOrdenados = agenda.getContatosOrdenados();
			assertTrue(contOrdenados.hasNext());
			
			Contato cont1 = contOrdenados.next();
			assertEquals("Raul", cont1.getNome());
			
			assertTrue(contOrdenados.hasNext());
			Contato cont2 = contOrdenados.next();
			assertEquals("Ayla", cont2.getNome());
		}
}

