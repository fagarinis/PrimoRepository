package it.prova.file;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class TestFileWrite {

	public static void main(String[] args) {
		try {
			
			//inizializza un FileWriter creando anche il file se non c'e'
			FileWriter fileWriter = new FileWriter("provascrittura.txt");
			
			
			//un buffer per scrivere stringa per stringa
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter); 
			for(int i = 0; i < 52; i++) {
				bufferedWriter.write("linea "+ i);
				bufferedWriter.write("\r\n"); //accapo per scrittura file
			}
			
			//ci si assicura che il buffer venga svuotato prima di chiuderlo (il buffer non scrive immediatamente su file)
			bufferedWriter.flush(); 
			bufferedWriter.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
