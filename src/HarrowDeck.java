import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;

public class HarrowDeck {
	ArrayList<HarrowCard> deck;
	public static BufferedImage cardBack = null;
	public HarrowDeck() {

		if(cardBack == null) {
			try {
				cardBack = ImageIO.read(new File("resources\\back.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		deck = new ArrayList<HarrowCard>();
		String[] names = {"The Avalanche","The Bear", "The Beating", "The Betrayal", "The Big Sky", "The Brass Dwarf", "The Carnival", "The Crows","The Cyclone","The Dance","The Courtesan","The Demon's Lantern","The Cricket", "The Desert","The Eclipse","The Hidden Truth","The Empty Throne","The Idiot","The Fiend","The Inquisitor","The Foreign Trader","The Joke","The Forge","The Juggler","The Keep"," The Midwife","The Liar","The Mountain Man","The Locksmith","The Mute Hag","The Lost","The Owl","The Marraige","The Paladin","The Peacock","The Sickness","The Publican","The Snakebite","The Queen Mother","The Survivor","The Rabbit Prince","The Tangled Briar","The Rakshasa","The Teamster","The Theater","The Uprising","The Trumpet","The Vision","The Twin","The Wanderer","The Tyrant","The Waxworks","The Unicorn","The Winged Serpent"};
		String[] traditional = {"Unrelenting disaster","Brute force reigns","Attack from all sides.","Selfishness leads to ruin","Freedom from bondage.","Invulnerability to peril.","Illusions and false dreams","Taking of loved ones or items","Tumultuous, evil plots","Staying in harmony.","Political intrigue.","An impossible situation","Speed and quick passage.","Traversing a bleak passage.","Self-doubt","Seeing past the obvious.","Loss brings good fortune","Grave foolishness and greed.","Many losses in a calamity.","Immutable reality.","An informative pact","Danger overcome by artifice","Strength through diversity","Fate is on your side","Unshakable to threat","New life or new information","Love at its most treacherous","An external physical power.","Keys to a new destiny.","Blood pacts and dark secrets.","Loss of identity.","Wisdom of the natural order","Union of persons or ideas.","Standing fast under adversity.","Sudden personal shift.","Disease of body or soul","Fellowship and camaraderie.","Poisonous powers or ideas.","Knowledge through fealty","Rebirth through ordeal","Capriciousness of combat.","Ancient triumphs return.","Dominance and mind control.","Driving external pressure","Prophecy is true","Overwhelming groundswell.","Declaration of power.","Arcane knowledge.","Duality of purpose.","Finding worth in cast-offs.","Paternal influence brings pain.","Helplessness and entropy.","What you seek is yours.","Knowing when to strike."};
		String[] misaligned = {"Disaster can be averted.","N/A","Hidden Strength.","Noble self-sacrifice","New shackles replace the old.","N/A","N/A","Thievery can be stopped.","Renewal after a trial.","Lockstep is perilous.","N/A","A guide lights a way out.","The journey goes poorly.","A passage with little hope.","Unheralded abilities.","A dangerous secret.","Loss brings bad tidings.","Clever feigning of idiocy.","Salvation from a calamity.","N/A","N/A","The joke is on you.","N/A","Fate is not on your side.","Temptation is stronger.","Dangerous new arrivals.","A new relationship begins.","N/A","N/A","Unwavering loyalty.","Clarity of mind.","N/A","N/A","Standing fast is foolhardy.","N/A","Great health is an epidemic.","Refuge cannot be found.","Mental leap or discovery.","N/A","Tragic news or profound loss.","N/A","Old evils endanger present.","Enslavement is shaken off.","N/A","Prophecy is unreliable.","N/A","Power for power's sake.","N/A","N/A","Inability to see value","A dark influence is overuled","Abundance of energy.","Friends are untrustworthy.","Failing to seize the moment."};		
		String[] alignments = {"LE","N","NE","NE","CG","LN","CN","NE","CE","LG","CN","CE","NG","CG","LE","LG","LG","NE","LE","LN","N","CG","LN","CG","NG","NG","CE","CN","LN","NE","CE","N","LN","LG","N","NE","CG","CE","LN","NG","CN","LE","LE","N","NG","CN","LG","CN","N","NG","LE","CE","CG","LG"};
		String[] abilities = {"DEX","STR","STR","CHA","STR","CON","WIS","DEX","STR","DEX","CHA","DEX","DEX","CON","WIS","INT","CHA","INT","STR","INT","INT","INT","STR","DEX","STR","WIS","CHA","CON","DEX","WIS","WIS","WIS","CHA","STR","DEX","CON","WIS","INT","WIS","CON","DEX","CON","INT","CON","CHA","STR","CON","INT","CHA","INT","CHA","CON","CHA","WIS"};
		String[] suits = {"key","hammer","hammer","crown","hammer","shield","star","key","hammer","key","crown","key","key","shield","star","book","crown","book","hammer","book","book","book","hammer","key","hammer","star","crown","shield","key","star","star","star","crown","hammer","key","shield","star","book","star","shield","key","shield","book","shield","crown","hammer","shield","book","crown","book","crown","shield","crown","star"};
		
		BufferedImage cardBase = null;
		try {			
			cardBase = ImageIO.read(new File("resources\\base.png"));			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		for (int i=0;i<54;i++) {
			Alignment a;
			switch(alignments[i]) {
				case "CE":
					a = Alignment.Chaotic_Evil;
					break;
				case "CN":
					a = Alignment.Chaotic_Neutral;
					break;
				case "CG":
					a = Alignment.Chaotic_Good;
					break;
				case "NE":
					a = Alignment.Neutral_Evil;
					break;
				case "N":
					a = Alignment.Neutral_Neutral;
					break;
				case "NG":
					a = Alignment.Neutral_Good;
					break;
				case "LE":
					a = Alignment.Lawful_Evil;
					break;
				case "LN":
					a = Alignment.Lawful_Neutral;
				case "LG":
					a = Alignment.Lawful_Good;
					break;
				default:
					a = null;
					break;
				}
			Suit s;
			switch (suits[i]) {
				case "key":
					s = Suit.Keys;
					break;
				case "hammer":
					s = Suit.Hammers;
					break;
				case "crown":
					s = Suit.Crowns;
					break;
				case "star":
					s = Suit.Stars;
					break;
				case "shield":
					s = Suit.Shields;
					break;
				case "book":
					s = Suit.Books;
					break;
				default:
					s = null;
					break;
			}
			Ability ab;
			switch (abilities[i]) {
				case "STR":
					ab = Ability.Strength;
					break;
				case "DEX":
					ab = Ability.Dexterity;
					break;
				case "WIS":
					ab = Ability.Wisdom;
					break;
				case "INT":
					ab = Ability.Inteliigence;
					break;
				case "CHA":
					ab = Ability.Charisma;
					break;
				case "CON":
					ab = Ability.Constitution;
					break;
				default:
					ab = null;
					break;
			}
			BufferedImage cardFace = new BufferedImage(cardBase.getWidth(),cardBase.getHeight(),BufferedImage.TYPE_INT_ARGB);
			Graphics g = cardFace.getGraphics();
			g.drawImage(cardBase,0,0,null);
			
			BufferedImage cardGraphic = null;
			try {
				cardGraphic = ImageIO.read(new File("resources\\"+i+".png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			BufferedImage suitGraphic = null;
			try {
				suitGraphic = ImageIO.read(new File("resources\\"+s.name().toLowerCase()+".png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int suitY = 230;
			if(s.equals(Suit.Crowns))
				suitY += 4;
			if(s.equals(Suit.Shields))
				suitY += 3;
			if(s.equals(Suit.Books))
				suitY += 3;
			
			
			g.drawImage(suitGraphic, 70, suitY, null);
			g.drawImage(cardGraphic, 18, 40, null);
			g.setColor(Color.black);
			g.setFont(g.getFont().deriveFont((float) 9.0));
			g.drawString(names[i],32,31);
			g.setColor(Color.WHITE);
			//g.setFont(g.getFont().deriveFont((float) 10.0));
			//g.drawString(s.name(),64,242);
			//ImageIcon icon = new ImageIcon(cardFace)
			//JButton.setIcon(cardFace)
			
			deck.add(new HarrowCard(names[i],a,s,ab,traditional[i],misaligned[i],cardFace));
		}		
	}
	
	
	public ArrayList<HarrowCard> getChoosing(Suit suitForChoosing) {
		Random r = new Random();
		ArrayList<HarrowCard> choosing = new ArrayList<HarrowCard>();
		for(HarrowCard card:deck)
			if(card.suit == suitForChoosing)
				choosing.add(r.nextInt(choosing.size()+1), card);		
		return choosing;		
	}
	
	public ArrayList<HarrowCard> getSpread() {
		ArrayList<HarrowCard> spread = new ArrayList<HarrowCard>();
		Random r = new Random();
		for(int i = 0;i<9;i++) {			
			HarrowCard c = deck.get(r.nextInt(deck.size()));
			while(spread.contains(c))
				c = deck.get(r.nextInt(deck.size()));
			spread.add(c);
		}
		
		return spread;
	}
	
	public static String countHarrowPoints(ArrayList<HarrowCard> chosenCards, ArrayList<HarrowCard> spread) {
		String output = "";
		int points = 1;
		Suit chosenSuit = chosenCards.get(0).suit;
		for(HarrowCard card:spread) {
			if(card.suit == chosenSuit) {
				points++;
				if(chosenCards.contains(card))
					output+="\nThe person who drew "+card.name+" gets a bonus point.";
			}				
		}
		return "Everyone in party gets "+points+" points."+output;
	}		
}
