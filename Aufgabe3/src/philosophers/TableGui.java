package philosophers;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

import philosophers.Philosopher.State;

public class TableGui {
	protected philosophers.Table t;
	
	public TableGui(philosophers.Table t) {
		this.t = t;
		
		final int n = 5;
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame f = new JFrame();
				JPanel p = new JPanel(new BorderLayout()) {
					Rectangle[] rects = new Rectangle[n];
					
					{
						addMouseListener(new MouseAdapter() 
						{
			                public void mouseClicked(MouseEvent e) 
			                {
//			                	System.out.println("mouse clicked: "+e.getX()+" "+e.getY());
			                	
			                	int x = e.getX();
			                	int y = e.getY();
			                	for(int i=0; i<rects.length; i++)
			                	{
			                		Rectangle rect = rects[i];
			                		if(rect!=null)
			                		{
			                			if(rect.x<=x && x<=rect.x+rect.getWidth()
			                				&& rect.y<=y && y<=rect.y+rect.getHeight())
			                			{
			                				t.getPhilosopher(i).notifyPhilosopher(0);
			                				break;
			                			}
			                		}
			                	}
			                }
				        });
					}
					
					public void paint(Graphics g) {
						super.paint(g);
						
						int w = getWidth();
						int h = getHeight();
						
						g.setColor(Color.WHITE);
						g.fillOval(0, 0, w, h);
						
						
						double step = 2*Math.PI/n;
						for(int i=0; i<n; i++) {
							// draw philosophers
							double xf = Math.sin(step*i);
							double yf = 1-Math.cos(step*i);
							int x = (int)(xf*(w/2-w/8))+w/2-w/8;
							int y = (int)(yf*(h/2-h/8));
							State state = t.getPhilosopher(i).getState();
//							g.setColor(State.THINKING.equals(state)? Color.LIGHT_GRAY: State.EATING.equals(state)? Color.BLUE: new Color(100,100,255));
//							System.out.println("Waiting: "+i+" "+t.getPhilosopher(i).isWaiting());
//							g.setColor(t.getPhilosopher(i).isWaiting()? Color.LIGHT_GRAY: new Color(230, 230, 230));
							g.setColor(new Color(230, 230, 230));
							g.fillOval(x, y, w/4, h/4);
							g.setColor(Color.BLACK);
//							g.setFont(new Font("default", Font.BOLD, 14));
							int fh = g.getFontMetrics().getHeight();
							if(t.getPhilosopher(i)!=null)
							{
								g.drawString(""+i+"[eaten="+t.getPhilosopher(i).getEatCnt()+"]", x, y+fh);
								g.drawString(state.toString(), x, y+fh*2);
							}
							
							rects[i] = new Rectangle(x, y, w/4, h/4);
							
							// draw sticks
							double xsf = Math.sin(-step*i);
							double ysf = Math.cos(-step*i);
							int x2 = (int)(xsf*w/4)+w/2;
							int y2 = (int)(ysf*h/4)+h/2;
							int x3 = (int)(xsf*w/2.5)+w/2;
							int y3 = (int)(ysf*h/2.5)+h/2;
							
							int no = (i+2)%n;
							Philosopher p = t.getStickOwner(no);
							
							g.setColor(p!=null? Color.RED: Color.GREEN);	
							((Graphics2D)g).setStroke(new BasicStroke(5));
							g.drawLine(x2, y2, x3, y3);
//							g.drawString(""+no, x2, y2);
							
							g.setColor(Color.BLACK);
//							g.setFont(new Font("default", Font.BOLD, 16));
							if(p!=null)
								g.drawString(""+p.getNo(), x2, y2);
						}
					}
				};
				p.setDoubleBuffered(true);
				
				final JButton modeb = new JButton(t.isWaitForClicks()? "Run Mode": "Click Mode");
				modeb.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						t.setWaitForClicks(!t.isWaitForClicks());
						if(t.isWaitForClicks())
						{
							modeb.setText("Run Mode");
						}
						else
						{
							t.notifyAllPhilosophers();
							modeb.setText("Click Mode");
						}
					}
				});
				
				JPanel sp = new JPanel(new FlowLayout(FlowLayout.RIGHT));
				sp.add(modeb);
				f.getContentPane().add(p, BorderLayout.CENTER);
				f.getContentPane().add(sp, BorderLayout.SOUTH);
				f.setSize(300, 350);
				f.setVisible(true);
				
				Timer t = new Timer(100, new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						p.repaint();
					}
				});
				t.start();
			}
		});
	}
}
