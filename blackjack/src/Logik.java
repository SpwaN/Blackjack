import java.util.Random;

public class Logik {
	public int pscore = 0;
	public int cscore = 0;
	public int win = 21;
	public int safe = 16;

	public Random random = new Random();

	public void update() {
		pscore = Integer.parseInt(View.playerScore.getText());
		cscore = Integer.parseInt(View.computerScore.getText());
	}

	public void setScore() {
		View.playerScore.setText(Integer.toString(pscore));
		View.computerScore.setText(Integer.toString(cscore));
	}

	public void newPRandom() {
		pscore += random.nextInt(12) + 1;
	}

	public void newCRandom() {
		cscore += random.nextInt(12) + 1;
	}
}
