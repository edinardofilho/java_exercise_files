package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import entities.Product;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		List<String> list = new ArrayList<>();

		try (BufferedReader br = new BufferedReader(
				new FileReader("/home/edinardofilho/eclipse-workspace/File/Order.csv"))) {
			String line = br.readLine();
			while (line != null) {
				list.add(line);
				line = br.readLine();
			}
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		new File("/home/edinardofilho/eclipse-workspace/File" + "/out").mkdir();
		
		try (BufferedWriter bw = new BufferedWriter(
				new FileWriter("/home/edinardofilho/eclipse-workspace/File/out/Summary.csv", true))) {
			{
				for (String s : list) {
					String[] aux = s.split(",");
					Product product = new Product(aux[0], Double.parseDouble(aux[1]), Integer.parseInt(aux[2]));
					bw.write(product.toString());
					bw.newLine();
				}
			}
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
}
