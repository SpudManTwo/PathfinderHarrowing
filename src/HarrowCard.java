import java.awt.image.BufferedImage;


public class HarrowCard {
	
	
	
	public String name;
	public Alignment alignment;
	public Suit suit;
	public Ability ability;
	public String traditionalMeaning;
	public String misalignedMeaning;
	public BufferedImage cardFace;
	
	public HarrowCard(String name, Alignment alignment, Suit suit, Ability ability, String traditional, String misaligned, BufferedImage cardFace) {
		this.name = name;
		this.alignment = alignment;
		this.suit = suit;
		this.ability = ability;
		this.traditionalMeaning = traditional;
		this.misalignedMeaning = misaligned;
		this.cardFace = cardFace;
	}
	
	public boolean equals(Object obj) {
		if (! (obj instanceof HarrowCard))
			return false;
		HarrowCard other = (HarrowCard)obj;
		return other.name.equals(this.name) && other.alignment.equals(this.alignment) && other.suit.equals(this.suit) && other.ability.equals(this.ability) && other.traditionalMeaning.equals(this.traditionalMeaning) && other.misalignedMeaning.equals(this.misalignedMeaning);
	}
	
	public boolean canBeMisaligned() {
		return !this.misalignedMeaning.equals("N/A");
	}
}
