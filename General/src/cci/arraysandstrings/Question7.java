package cci.arraysandstrings;

import java.util.Scanner;

public class Question7 {
	
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
		int output [] [] = modifyMatrix(input);
		printMatrix(input);
		printMatrix(output);
		
	}
	
	private static int [][] modifyMatrix(int input [] [] ){
		int [] [] output = new int [input.length] [input[0].length];
		for(int i = 0 ; i < input.length ; i ++ ){
			for(int j = 0 ; j < input[i].length ; j++){
				if(input [i][j] == 0){
					
				}
			}
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
