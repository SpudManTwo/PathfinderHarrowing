import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;


public class CardDisplayTest {
	public static void main(String[] args) {
		JFrame window = new JFrame();
		JButton cardDisplay = new JButton();
		HarrowDeck testDeck = new HarrowDeck();
		HarrowCard testCard = testDeck.deck.get(53);
		ImageIcon testIcon = new ImageIcon(testCard.cardFace);
		cardDisplay.setIcon(testIcon);
		cardDisplay.setSize(testCard.cardFace.getWidth(), testCard.cardFace.getHeight());
		window.add(cardDisplay);
		window.setSize(500,500);
		window.setLayout(null);
		window.setVisible(true);
	}
}
