import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Harrowing {
	public static void main(String[] args) {
		JFrame window = new JFrame();
		window.setSize(1000,1000);
		window.setLayout(null);
		HarrowDeck deck = new HarrowDeck();
		System.out.println("Please enter the suit for the harrowing or the chapter number from the Crimson Throne AP.");
		Scanner inputScanner = new Scanner(System.in);
		String input = inputScanner.nextLine();
		inputScanner.close();
		Suit choosingSuit = null;
		if(input.length() == 1 && Character.isDigit(input.charAt(0))) {
			//Chapter Number input
			int chapterNum = Integer.parseInt(input);
			switch(chapterNum) {
				case 1:
					choosingSuit = Suit.Keys;
					break;
				case 2:
					choosingSuit = Suit.Shields;
					break;
				case 3:
					choosingSuit = Suit.Books;
					break;
				case 4:
					choosingSuit = Suit.Hammers;
					break;
				case 5:
					choosingSuit = Suit.Stars;
					break;
				case 6:
					choosingSuit = Suit.Crowns;
					break;					
			}
		}
		else {
			//Suit name input
			switch(input.toLowerCase()) {
			case "keys":
				choosingSuit = Suit.Keys;
				break;
			case "shields":
				choosingSuit = Suit.Shields;
				break;
			case "books":
				choosingSuit = Suit.Books;
				break;
			case "hammers":
				choosingSuit = Suit.Hammers;
				break;
			case "stars":
				choosingSuit = Suit.Stars;
				break;
			case "crowns":
				choosingSuit = Suit.Crowns;
				break;					
			}
		}
		ArrayList<HarrowCard> choosing = deck.getChoosing(choosingSuit);
		ArrayList<HarrowCard> chosen = new ArrayList<HarrowCard>();
		
		JPanel choosingPanel = new JPanel();
		choosingPanel.setSize(1000,1000);
		choosingPanel.setLayout(null);
				
		JLabel choosingLabel = new JLabel("THE CHOOSING");
		choosingLabel.setFont(choosingLabel.getFont().deriveFont((float)36.0));
		choosingLabel.setSize(1000,36);
		choosingLabel.setHorizontalAlignment(JLabel.CENTER);
		choosingPanel.add(choosingLabel);
		
		JButton[] choosingButtons = new JButton[9];
		for(int i = 0;i<choosingButtons.length;i++) {
			choosingButtons[i] = new JButton();
			choosingButtons[i].setIcon(new ImageIcon(HarrowDeck.cardBack));
			choosingButtons[i].addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent arg0) {
					JButton source = (JButton)arg0.getSource();
					for(int i=0;i<choosingButtons.length;i++) {
						if(choosingButtons[i] == source) {
							chosen.add(choosing.get(i));
							source.setEnabled(false);
							choosingButtons[i].setDisabledIcon(new ImageIcon(choosing.get(i).cardFace));
						}
					}
				}				
			});
			choosingPanel.add(choosingButtons[i]);
		}
		choosingButtons[0].setBounds(  0, 362, 156, 262);
		choosingButtons[1].setBounds(206, 312, 156, 262);
		choosingButtons[2].setBounds(206, 624, 156, 262);
		choosingButtons[3].setBounds(412,  50, 156, 262);
		choosingButtons[4].setBounds(412, 362, 156, 262);
		choosingButtons[5].setBounds(412, 674, 156, 262);
		choosingButtons[6].setBounds(618, 312, 156, 262);
		choosingButtons[7].setBounds(618, 624, 156, 262);
		choosingButtons[8].setBounds(824, 362, 156, 262);
		
		
		JPanel spreadPanel = new JPanel();
		spreadPanel.setSize(1000,1000);
		spreadPanel.setLayout(null);
		
		JLabel pastLabel = new JLabel("THE PAST");
		pastLabel.setFont(pastLabel.getFont().deriveFont((float)36.0));
		pastLabel.setSize(1000,36);
		pastLabel.setHorizontalAlignment(JLabel.CENTER);
		spreadPanel.add(pastLabel);
		
		JLabel presentLabel = new JLabel("THE PRESENT");
		presentLabel.setFont(presentLabel.getFont().deriveFont((float)36.0));
		presentLabel.setSize(1000,36);
		presentLabel.setHorizontalAlignment(JLabel.CENTER);
		spreadPanel.add(presentLabel);
		presentLabel.setVisible(false);
		
		JLabel futureLabel = new JLabel("THE FUTURE");
		futureLabel.setFont(futureLabel.getFont().deriveFont((float)36.0));
		futureLabel.setSize(1000,36);
		futureLabel.setHorizontalAlignment(JLabel.CENTER);
		spreadPanel.add(futureLabel);
		futureLabel.setVisible(false);
		
		JTextArea results = new JTextArea("THE PAST:");
		results.setEditable(false);
		results.setBounds(668,50,282,950);
		results.setLineWrap(true);
		results.setWrapStyleWord(true);
		spreadPanel.add(results);
		
		ArrayList<HarrowCard> spread = deck.getSpread();
		JButton[] spreadButtons = new JButton[9];
		for(int i = 0;i<spreadButtons.length;i++) {
			spreadButtons[i] = new JButton();
			spreadButtons[i].setIcon(new ImageIcon(HarrowDeck.cardBack));
			spreadButtons[i].addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent arg0) {
					JButton source = (JButton)arg0.getSource();
					for(int i=0;i<spreadButtons.length;i++) {
						if(spreadButtons[i] == source) {
							source.setEnabled(false);
							spreadButtons[i].setDisabledIcon(new ImageIcon(spread.get(i).cardFace));
							
							String meaning = "\n";
							
							if(i==2) {
								pastLabel.setVisible(false);
								meaning+="\nTHE PRESENT\n";
								presentLabel.setVisible(true);
							}
							if(i==5) {
								presentLabel.setVisible(false);
								meaning+="\nTHE FUTURE\n";
								futureLabel.setVisible(true);
							}
							
							Alignment a;
							switch(i) {
								case 8:
									a = Alignment.Chaotic_Evil;
									break;
								case 7:
									a = Alignment.Chaotic_Neutral;
									break;
								case 6:
									a = Alignment.Chaotic_Good;
									break;
								case 5:
									a = Alignment.Neutral_Evil;
									break;
								case 4:
									a = Alignment.Neutral_Neutral;
									break;
								case 3:
									a = Alignment.Neutral_Good;
									break;
								case 2:
									a = Alignment.Lawful_Evil;
									break;
								case 1:
									a = Alignment.Lawful_Neutral;
								case 0:
									a = Alignment.Lawful_Good;
									break;
								default:
									a = null;
									break;
								}
							
							int match = spread.get(i).alignment.matchLevel(a);
							
							if(match<=0&&spread.get(i).canBeMisaligned()) {
								meaning += "\n"+spread.get(i).misalignedMeaning;
							}
							else {
								meaning += "\n"+spread.get(i).traditionalMeaning;
							}
							
							if(match==2) {
								if(i<3)
									meaning+="\nThis was of extreme importance.";
								else if(i<6)
									meaning+="\nThis is of extreme importance.";
								else
									meaning+="This will be of extreme importance.";
							}
							if(match==-2) {
								if(i<3)
									meaning+="\nThis was part of a momentous happening.";
								else if(i<6)
									meaning+="\nThis is part of a momentous happening.";
								else
									meaning+="This will be part of a momentous happening.";
							}
							
							if(i==8) {
								meaning+="\n\nPoint result:\n"+HarrowDeck.countHarrowPoints(chosen, spread);
							}
							
							results.setText(results.getText()+meaning);
														
						}						
					}
				}				
			});
			spreadPanel.add(spreadButtons[i]);
		}
		
		spreadButtons[0].setBounds( 50,  50, 156, 262);
		spreadButtons[1].setBounds( 50, 362, 156, 262);
		spreadButtons[2].setBounds( 50, 674, 156, 262);
		spreadButtons[3].setBounds(256,  50, 156, 262);
		spreadButtons[4].setBounds(256, 362, 156, 262);
		spreadButtons[5].setBounds(256, 674, 156, 262);
		spreadButtons[6].setBounds(462,  50, 156, 262);
		spreadButtons[7].setBounds(462, 362, 156, 262);
		spreadButtons[8].setBounds(462, 674, 156, 262);
		
		JButton showSpreadButton = new JButton("Show Spread");
		showSpreadButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				choosingPanel.setVisible(false);
				spreadPanel.setVisible(true);
				//window.remove(source);								
			}				
		});
		showSpreadButton.setBounds(800,850,150,100);
		choosingPanel.add(showSpreadButton);
		
		
		spreadPanel.setVisible(false);
		
		window.add(choosingPanel);
		window.add(spreadPanel);
		window.setVisible(true);
	}
	
}
