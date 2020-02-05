package it.prova.file;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TestFileRead {

	public static void main(String[] args) {
		String nomeFile = "prova.txt"; //deve essere collocato nella cartella del progetto "provasetefile"
		
		String linea = null; //per leggere una riga alla volta
		
		
		
		try {
			FileReader fileReader = new FileReader(nomeFile);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			
			linea = bufferedReader.readLine();
			while(linea != null) {
				System.out.println(linea);
				linea = bufferedReader.readLine();
			}
			
			bufferedReader.close();//chiudere sempre i file
				
			
		} catch (FileNotFoundException e) {
			System.out.println("file non trovato!");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("errore nella lettura del file");
			e.printStackTrace();
		}
	}

}
