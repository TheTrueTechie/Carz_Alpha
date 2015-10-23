import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class startScreen implements ActionListener {
	private JFrame mainFrame;
	private JPanel mainPanel;

	private JFrame gameFrame;
	private JFrame gamePanel;

	public JButton startButton;
	private JButton helpButton;
	private JButton creditsButton;
	private JButton endButton;

	int carX;
	int carY;
	int five = 5;

	public carObject mainCar = new carObject(500, 500, 50, 17);

	public static void main(String[] args) {
		new startScreen();
	}

	startScreen() {
		mainFrame = new JFrame();
		mainPanel = new JPanel();

		startButton = new JButton();
		helpButton = new JButton();
		creditsButton = new JButton();
		endButton = new JButton();

		startCode();

	}

	public void startCode() {
		setBackground();

		mainFrame.add(mainPanel);

		startButton.addActionListener(this);
		helpButton.addActionListener(this);
		creditsButton.addActionListener(this);
		endButton.addActionListener(this);

		mainPanel.add(startButton);
		mainPanel.add(helpButton);
		mainPanel.add(creditsButton);
		mainPanel.add(endButton);

		startButton.setText("Start");
		helpButton.setText("Help");
		creditsButton.setText("Credits");
		endButton.setText("Exit");

		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		mainFrame.setVisible(true);

	}

	public void gameScreen() {
		gameFrame = new JFrame();
		gamePanel = new JFrame();

		setBackground2();

		gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		gameFrame.setVisible(true);
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

	private void setBackground2() {
		System.out.println(gameFrame);
		try {
			gameFrame.setContentPane(new JPanel() {
				BufferedImage backgroundImage = ImageIO.read(this.getClass()
						.getResourceAsStream("carzCity.png"));

				BufferedImage carImage = ImageIO.read(this.getClass()
						.getResourceAsStream("carDefault.png"));

				public void paintComponent(Graphics g) {
					super.paintComponent(g);
					g.drawImage(backgroundImage, 0, 0, gameFrame.getWidth(),
							gameFrame.getHeight(), this);
					g.drawImage(
							carImage, mainCar.x, mainCar.y,
							mainCar.sizeW, mainCar.sizeH, this);
					
					//mainCar.xMove();
				}
			}

			);

		} catch (Exception e) {
			System.out.println("Error at setBackground");
			e.printStackTrace();

		}
	}

	public void actionPerformed(ActionEvent arg0) {

		if (startButton == arg0.getSource()) {
			gameScreen();
			System.out.println("Test");
		}

		if (creditsButton == arg0.getSource()) {
			JOptionPane.showMessageDialog(null, "Coded by �TheTrueTechies");
		}

		if (helpButton == arg0.getSource()) {
			JOptionPane
					.showMessageDialog(
							null,
							"Use WASD to control car. W to move forward, S to move backwards, A to move left, D to move right");
		}

		if (endButton == arg0.getSource()) {
			System.exit(0);
		}
	}
}
