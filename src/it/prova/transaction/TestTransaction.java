package it.prova.transaction;

import java.sql.Connection;
import java.sql.SQLException;

public class TestTransaction {

	public static void main(String[] args) throws SQLException {
		//ACID:
		
		//A: Atomicity, ogni transazione e' tutto o niente, ha successo solo se tutte le operazioni di
		//cui e' composta hanno successo inoltre deve sempre lasciare il sistema in uno stato consistente
		//non importa quante transazioni vengano eseguite allo stesso tempo da piu' richiedenti
		
		
		//C: Consistency
		//i vincoli sono imposti per ogni transazione commissionata
		
		//I: Isolation
		// richiede un metodo di controllo della concorrenza usando metodi di locking (come i thread?)
		
		//D: Durability
		//una transazione che ha successo modifica permanentemente lo stato di un sistema
		//e prima di concluderla, il cambio di stato deve essere registrato in un
		//log delle transazioni. se il sistema crasha, allora tutte le transazioni non completate
		//possono essere rieseguite
		
		//le transazioni consentono l'integrita' dei dati anche in sistemi
		//molto concorrenti
		
		//una transazione e' una collezione di operazioni di lettura/scrittura
		//il cui successo dipende dal successo di tutte le singole operazioni
		
		//In particolare, nei database relazionali, ogni query SQL deve essere eseguita
		//come transazione
		
		//le connessioni JDBC iniziano con la modalita' auto-commit settata a true
		//dove ogni query sql e' una transazione implicita ovvero fa un commit ad ogni operazione 
		//tale comportamento non e' accettabile nel caso si svolgano piu' statement.
		
		//esempio struttura:
		Connection con = null;
		
		try
		{
		  con.setAutoCommit(false); //quando l'autocommit e' settato a false bisogna, dopo l'esecuzione di ogni query
		  							//completare il tutto con una chiamata a commit() o a rollback() nel caso di errori
		
		   //1 or more queries or updates  
		   con.commit(); //q
		}
		catch(Exception e)
		{
		   con.rollback();
		}
		finally
		{
		   con.close();
		}
	
	}

}
