import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener {

	private Logik logik;
	private View program;

	public Controller(View vIn) {
		program = vIn;
		logik = new Logik();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == program.startButton) {
			View.playerScore.setText("0");
			View.computerScore.setText("0");
			program.statusLabel.setText("Play");
			program.hitButton.setEnabled(true);
			program.standButton.setEnabled(true);
			program.startButton.setEnabled(false);
			program.cstand = false;
			program.pstand = false;
			program.startButton.setVisible(false);
			program.hitButton.setVisible(true);
			program.standButton.setVisible(true);
		}

		boolean gameover = false;

		logik.update();
		if (e.getSource() == program.hitButton) {
			logik.newPRandom();
			if (logik.pscore > logik.win) {
				program.statusLabel.setText("You Lose");
				gameover = true;
			} else if (logik.pscore == logik.win) {
				program.statusLabel.setText("You Win");
				gameover = true;
			}

			if (!program.cstand && !gameover) {
				logik.newCRandom();
				if (logik.cscore > logik.win) {
					program.statusLabel.setText("Computer Lose");
				} else if (logik.cscore == logik.win)
					program.statusLabel.setText("Computer Win");
				else if (logik.cscore > logik.safe)
					program.cstand = true;
			}

		} else if (e.getSource() == program.standButton) {
			while (!gameover && !(logik.cscore > logik.pscore)) {
				logik.newCRandom();
				if (logik.cscore > logik.win) {
					program.statusLabel.setText("Computer Lose");
					gameover = true;
				} else if (logik.cscore == logik.win) {
					program.statusLabel.setText("Computer Win");
					gameover = true;
				} else if (logik.cscore > logik.pscore) {
					program.statusLabel.setText("Computer Win");
					gameover = true;
				}
			}

			/*
			 * Denna logik är väll fel :)? if (logik.cscore > logik.pscore)
			 * program.statusLabel.setText("Computer Win");
			 */
		}

		if (program.statusLabel.getText() != "Play") {
			program.hitButton.setEnabled(false);
			program.hitButton.setVisible(false);
			program.standButton.setEnabled(false);
			program.standButton.setVisible(false);
			program.startButton.setVisible(true);
			program.startButton.setEnabled(true);
		}
		logik.setScore();
	}
}
