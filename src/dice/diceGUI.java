package dice;

import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class diceGUI extends JFrame {

	private JPanel contentPane;

	boolean startFlag;
	static boolean play;


	/**
	 * Create the frame.
	 */
	public diceGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 297, 346);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		contentPane.setLayout(null);
		
		setContentPane(contentPane);
		startFlag = true;
		play=false;

		JLabel diceImg = new JLabel(new ImageIcon(this.getClass().getClassLoader().getResource("img/1.png")));


		diceImg.setBounds(18, 10, 247, 217);
		contentPane.add(diceImg);

		
		JButton button = new JButton("開始/停止");
		button.setFont(new Font("微軟正黑體", Font.PLAIN, 17));
		button.setBounds(63, 237, 157, 47);
		contentPane.add(button);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(startFlag==true) {
					play=true;
					startFlag = false;
					imgThread thread = new imgThread(diceImg);
					thread.start();
				}
				else {
					startFlag = true;
					play = false;
				}

				contentPane.repaint();
			}
		});


	}
}
