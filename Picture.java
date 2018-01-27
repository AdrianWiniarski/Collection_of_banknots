import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

public class Picture extends JPanel implements KeyListener{
	private static final long serialVersionUID = 1L;
	private float x=25 ,y=150;
	private Circle circle=new Circle(x, y);
	private boolean keyPressed=false;
	private float lastX;
	public void paintComponent(Graphics g){
		super.paintComponent(g);
	{
			circle.move(x-lastX,0);
			if(keyPressed){
				circle.fill(g);
			}
			else
			{
				circle.Draw(g);
			}
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		lastX=x;
		x++;
		if(x>600)
		{x=50;}
		keyPressed=true;
		repaint();// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		keyPressed=false;
		repaint();
	}


}
