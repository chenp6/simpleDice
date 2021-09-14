package dice;

import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class imgThread extends Thread{
	JLabel img;
	imgThread(JLabel img){
		this.img = img;
	}
	public void  run() {
		while(diceGUI.play) {
			Random r = new Random();
			int num = r.nextInt(6) + 1;
			img.setIcon(new ImageIcon(this.getClass().getClassLoader().getResource("img/"+num+".png")));
			try {
				sleep(5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			img.repaint();
		}
	}
}
