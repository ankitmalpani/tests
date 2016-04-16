package random.questions;

import java.util.Arrays;
import java.util.Random;

public class ShuffleADeckOfCards {
	
	
	public void shuffle(Card [] deck){
		if(deck == null || anyDups(deck) || deck.length < 52){
			//throw Exception;
		}
		else{
			randomize(deck);
			int x = 1;
			while(x < 4){
				for(int i = x; i < deck.length ; i=i+4 ){
					//distribute
				}
			}
			
		}
	}
	
	public void randomize(Card [] deck){
		Random random = new Random();
		int maxCardCount = 52;
		for(int i = 1 ; i <= 52 ; i++){
			int randomCard = random.nextInt(maxCardCount+1);
			swap(deck,i,randomCard);
			maxCardCount--;
		}
	}
	
	public boolean anyDups(Card [] deck){
		//add to hashSet
		return false;
		
	}
	
	public void swap(Card [] input, int a, int b){
		Card temp = input[a];
		input[a] = input[b];
		input[b] = temp;
	}
	
	
	public class Card implements Comparable{
		public int cardValue; //assume less than 14
		public Suite suite;
		public int uniqueId;
		
		public Card(int cardValue, Suite suite){
			this.cardValue = cardValue;
			this.suite = suite;
			if(suite.getValue() == 0 ){ //hearts
				this.uniqueId = cardValue;
			}
			else{
				this.uniqueId = cardValue + 13*suite.getValue();
			}
				
		}

		@Override
		public int compareTo(Object otherCard) {
			if(otherCard == null) return 1;//always greater than no card??
			Card oCard = (Card)otherCard;
			if(this.uniqueId > oCard.uniqueId) return 1;
			else if(this.uniqueId < oCard.uniqueId) return -1;
			return 0;
		}
		
	}
	
	public static enum Suite{ 
		Hearts(0), 
		Spades(1), 
		Diamonds(2), 
		Clubs(3) ;
		
		private int value;
		private Suite(int value){
			this.value = value;
		}
		
		public int getValue() {
		      return value;
		   }
		
	};

}
