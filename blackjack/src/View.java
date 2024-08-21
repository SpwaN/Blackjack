
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class View extends JFrame {

	private Controller controller;
	public JButton hitButton, standButton, startButton;
	public static JLabel playerScore, computerScore;
	public JLabel statusLabel, computerHand, playerHand;
	public Random random;
	boolean cstand, pstand;
	private JPanel content;

	public View() {
		controller = new Controller(this);
		setupLayout(this);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 200);
		setResizable(false);
		setVisible(true);
	}

	private void setupLayout(JFrame frame) {
		content = new JPanel();
		content.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(content);
		content.setLayout(null);

		hitButton = new JButton("Hit");
		hitButton.setBounds(50, 100, 80, 50);
		content.add(hitButton);

		standButton = new JButton("Stand");
		standButton.setBounds(150, 100, 80, 50);
		content.add(standButton);

		startButton = new JButton("Start");
		startButton.setBounds(100, 100, 80, 50);
		content.add(startButton);

		statusLabel = new JLabel("Press to start");
		statusLabel.setBounds(100, 10, 100, 20);
		content.add(statusLabel);

		playerHand = new JLabel("Player score: ");
		playerHand.setBounds(10, 40, 100, 20);
		content.add(playerHand);

		playerScore = new JLabel("0");
		playerScore.setBounds(90, 40, 100, 20);
		content.add(playerScore);

		computerHand = new JLabel("Computer score: ");
		computerHand.setBounds(150, 40, 100, 20);
		content.add(computerHand);

		computerScore = new JLabel("0");
		computerScore.setBounds(250, 40, 100, 20);
		content.add(computerScore);

		hitButton.addActionListener(controller);
		standButton.addActionListener(controller);
		startButton.addActionListener(controller);

		hitButton.setEnabled(false);
		hitButton.setVisible(false);
		standButton.setEnabled(false);
		standButton.setVisible(false);

	}
}
