package cci.arraysandstrings;

import java.security.KeyStore.Builder;
import java.util.Scanner;

public class Question6 {
	
	public static void main(String [] args){
		Scanner in = new Scanner(System.in);
		int n = Integer.parseInt(in.nextLine());
		int [] [] input = new int [n] [n];
		for(int i = 0 ; i < n ; i++){
			String row = in.nextLine();
			String [] splitRow = row.split(" ");
			for(int x = 0 ; x < splitRow.length; x++){
				input[i][x] = Integer.parseInt(splitRow[x]);
			}
		}
		int output [] [] = rotateMatrix(input);
		printMatrix(input);
		printMatrix(output);
		
	}
	
	private static int [] [] rotateMatrix(int [] [] input){
		int [] [] output = new int [input.length] [input.length];
		int colVar = 0;
		while(colVar < input.length){
			int opRowVar = 0;
			for(int rowVar = input.length-1 ; rowVar >= 0 ; rowVar--){
				System.out.println(input[rowVar][colVar]);
				output[colVar][opRowVar] = input[rowVar][colVar];
				opRowVar++;
			}
			colVar++;
		}
		return output;
	}
	
	private static void printMatrix(int [] [] output){
		int n = output.length;
		StringBuilder builder = new StringBuilder();
		for(int i = 0 ; i < n ; i++){
			for(int j = 0; j < n ; j++){
				builder.append(output[i][j]);
				builder.append(" ");
			}
			builder.append("\n");
		}
		System.out.println(builder.toString());
	}

}
