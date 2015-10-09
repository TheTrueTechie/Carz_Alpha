import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class startScreen implements ActionListener {
	private JFrame mainFrame;
	private JPanel mainPanel;

	private JButton startButton;
	private JButton helpButton;
	private JButton endButton;

	public static void main(String[] args) {
		new startScreen();
	}

	startScreen() {
		mainFrame = new JFrame();
		mainPanel = new JPanel();

		startButton = new JButton();
		helpButton = new JButton();
		endButton = new JButton();

		startCode();

	}

	private void startCode() {
		setBackground();

		mainFrame.add(mainPanel);

		startButton.addActionListener(this);
		helpButton.addActionListener(this);
		endButton.addActionListener(this);
		
		mainPanel.add(startButton);
		mainPanel.add(helpButton);
		mainPanel.add(endButton);

		startButton.setText("Start");
		helpButton.setText("Help");
		endButton.setText("Exit");
		
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		mainFrame.setVisible(true);

	}

	private void setBackground() {
		try {
			mainFrame.setContentPane(new JPanel() {
				BufferedImage backgroundImage = ImageIO.read(this.getClass()
						.getResourceAsStream("carzCity.png"));

				public void paintComponent(Graphics g) {
					super.paintComponent(g);
					g.drawImage(backgroundImage, 0, 0, mainFrame.getWidth(),
							mainFrame.getHeight(), this);
				}
			}

			);
		} catch (Exception e) {
			System.out.println("Error at setBackground");
			e.printStackTrace();

		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		if (startButton == arg0.getSource()) {

		}

		if (helpButton == arg0.getSource()) {

		}

		if (endButton == arg0.getSource()) {
			System.exit(0);
		}
	}
}
