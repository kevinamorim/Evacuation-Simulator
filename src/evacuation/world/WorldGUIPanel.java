package evacuation.world;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIDefaults;

import jadex.bridge.ComponentEvent;
import jadex.commons.beans.PropertyChangeEvent;
import jadex.commons.gui.SGUI;

public class WorldGUIPanel extends JPanel {
	//-------- constants --------

	/** The image icons. */
	public static final UIDefaults icons = new UIDefaults(new Object[]
	{
		"chaotic_agent", SGUI.makeIcon(WorldGUIPanel.class, "../../../../resources/img/default.png"),
		"neutral_agent", SGUI.makeIcon(WorldGUIPanel.class, "/resources/img/default.png"),
		"passive_agent", SGUI.makeIcon(WorldGUIPanel.class, "/resources/img/default.png"),
		"wall", SGUI.makeIcon(WorldGUIPanel.class, "/resources/img/default.png"),
		"floor", SGUI.makeIcon(WorldGUIPanel.class, "/resources/img/default.png"),
		"fire", SGUI.makeIcon(WorldGUIPanel.class, "/resources/img/default.png"),
		"emergency_exit_sign", SGUI.makeIcon(WorldGUIPanel.class, "/resources/img/default.png")
	});

	//-------- attributes --------
	protected World board; // The world map
	protected boolean rescale; // If re-scaling necessary
	protected Image chaotic_agent_img, neutral_agent_img, passive_agent_img, wall_img, floor_img, fire_img, emergency_exit_sign_img;
	protected JLabel chaotic_agent, neutral_agent, passive_agent, wall, floor, fire, emergency_exit_sign;
	protected ArrayList listeners;

	//-------- constructors --------
	public WorldGUIPanel(World world)
	{
		this.listeners = new ArrayList();
		this.board = world;
		
		final File f = new File(WorldGUIPanel.class.getProtectionDomain().getCodeSource().getLocation().getPath());
		System.out.print(f.getAbsolutePath());
		
//		ImageIcon test = (ImageIcon)icons.getIcon("chaotic_agent");
//		System.out.println(test.getImage());
				
//		this.chaotic_agent_img	= ((ImageIcon)icons.getIcon("chaotic_agent")).getImage();
//		this.neutral_agent_img	= ((ImageIcon)icons.getIcon("neutral_agent")).getImage();
//		this.passive_agent_img	= ((ImageIcon)icons.getIcon("passive_agent")).getImage();
//		this.wall_img	= ((ImageIcon)icons.getIcon("wall")).getImage();
//		this.floor_img	= ((ImageIcon)icons.getIcon("wall")).getImage();
//		this.fire_img	= ((ImageIcon)icons.getIcon("fire")).getImage();
//		this.emergency_exit_sign_img	= ((ImageIcon)icons.getIcon("emergency_exit_sign")).getImage();
//		
//		this.chaotic_agent = new JLabel(new ImageIcon(chaotic_agent_img), JLabel.CENTER);
//		this.neutral_agent = new JLabel(new ImageIcon(neutral_agent_img), JLabel.CENTER);
//		this.passive_agent = new JLabel(new ImageIcon(passive_agent_img), JLabel.CENTER);
//		this.wall = new JLabel(new ImageIcon(wall_img), JLabel.CENTER);
//		this.floor = new JLabel(new ImageIcon(floor_img), JLabel.CENTER);
//		this.fire = new JLabel(new ImageIcon(fire_img), JLabel.CENTER);
//		this.emergency_exit_sign = new JLabel(new ImageIcon(emergency_exit_sign_img), JLabel.CENTER);
//
//		this.addComponentListener(new ComponentAdapter()
//		{
//			public void	componentResized(ComponentEvent ce)
//			{
//				rescale	= true;
//			}
//		});
//
//		this.addMouseListener(new MouseAdapter()
//		{
//			public void mouseClicked(MouseEvent e)
//			{
//				System.out.println("Mouse clicked: "+e.getX()+" "+e.getY());
////				int size = WorldGUIPanel.this.board.getSize();
////				Rectangle r = BoardPanel.this.getBounds();
////				int x = (int)(e.getX()/(r.getWidth()/(double)size));
////				int y = (int)(e.getY()/(r.getHeight()/(double)size));
////				int m = size/2;
////				if(!(x<m && y>m || x>m && y<m))
////				{
////					ActionEvent ae = new ActionEvent(new Position(x,y), 0, null); // TODO: hack
////					for(int i=0; i<listeners.size(); i++)
////					{
////						((ActionListener)listeners.get(i)).actionPerformed(ae);
////					}
////				}
//			}
//		});
	}

	//-------- methods --------
	// Update GUI whenever required
	public void	update(PropertyChangeEvent evt)
	{
		repaint();
	}

	// Paint method (override)
	protected void	paintComponent(Graphics g)
	{
//		int bsize = world.getSize();
//		Rectangle	bounds	= getBounds();
//		double cellw = bounds.getWidth()/(double)bsize;
//		double cellh = bounds.getHeight()/(double)bsize;
//
//		// Rescale images if necessary.
//		if(rescale)
//		{
//			((ImageIcon)white_piece.getIcon()).setImage(
//				wp_image.getScaledInstance((int)cellw, (int)cellh, Image.SCALE_DEFAULT));
//			((ImageIcon)red_piece.getIcon()).setImage(
//				rp_image.getScaledInstance((int)cellw, (int)cellh, Image.SCALE_DEFAULT));
//			((ImageIcon)empty_field.getIcon()).setImage(
//				ef_image.getScaledInstance((int)cellw, (int)cellh,Image.SCALE_DEFAULT));
//
//			rescale	= false;
//		}
//
//		g.setColor(getBackground());
//		g.fillRect(0,0,bounds.width, bounds.height);
//
//		java.util.List pieces = board.getCurrentPosition();
//		for(int y=0; y<bsize; y++)
//		{
//			for(int x=0; x<bsize; x++)
//			{
//				Piece piece = (Piece)pieces.get(y*bsize+x);
//				if(piece!=null)
//				{
//					if(piece.isWhite())
//						SGUI.renderObject(g, white_piece, cellw, cellh, x, y, 0);
//						//g.setColor(Color.white);
//					else
//						SGUI.renderObject(g, red_piece, cellw, cellh, x, y, 0);
//						//g.setColor(Color.darkGray);
//					//g.fillOval((int)(cellw*x), (int)(cellh*y), (int)cellw, (int)cellh);
//				}
//				else if(board.isFreePosition(new Position(x,y)))
//				{
//					SGUI.renderObject(g, empty_field, cellw, cellh, x, y, 0);
//					//g.setColor(Color.lightGray);
//					//g.fillRect((int)(cellw*x), (int)(cellh*y), (int)cellw, (int)cellh);
//				}
//				else
//				{
//					//System.out.println("empty: "+x+" "+y);
//				}
//			}
//		}
//
//		if(board.getLastMove()!=null)
//		{
//			// Display new move.
//			if(movecnt<=board.getMoves().size())
//			{
//				last	= board.getLastMove();
//				g.setColor(Color.green);
//				drawArrow(g, last, cellw, cellh);
//			}
//			
//			// Take back -> display inverse of old last move.
//			else
//			{
//				g.setColor(Color.red);
//				Move tb = new Move(last.getEnd(), last.getStart());
//				drawArrow(g, tb, cellw, cellh);
//				last	= board.getLastMove();
//			}
//
//			movecnt	= board.getMoves().size();
//		}
	}

	// Draw arrow to visualize move
	protected void drawArrow(Graphics g)
	{
//		int xs = move.getStart().getX();
//		int ys = move.getStart().getY();
//		int xe = move.getEnd().getX();
//		int ye = move.getEnd().getY();
//		int xms = (int)(xs*cellw+cellw/2);
//		int yms = (int)(ys*cellh+cellh/2);
//		int xme = (int)(xe*cellw+cellw/2);
//		int yme = (int)(ye*cellh+cellh/2);
//		//g.drawLine(xms, yms, xme, yme);
//		int asize = Math.max((int)(Math.min(cellw, cellh)/8), 1);
//		int thick = Math.max(asize/4, 1);
//		if(xs<xe)
//		{
//			// Arrow right.
//			g.fillRect(xms, yms-thick/2, xme-xms-asize, thick);
//			g.fillPolygon(new int[]{xme-asize, xme-asize, xme}, new int[]{yme-asize, yme+asize, yme}, 3);
//		}
//		else if(xs>xe)
//		{
//			// Arrow left.
//			g.fillRect(xme+asize, yms-thick/2, xms-xme-asize, thick);
//			g.fillPolygon(new int[]{xme+asize, xme+asize, xme}, new int[]{yme-asize, yme+asize, yme}, 3);
//		}
//		else if(ys<ye)
//		{
//			// Arrow up.
//			g.fillRect(xms-thick/2, yms, thick, yme-yms-asize);
//			g.fillPolygon(new int[]{xme-asize, xme+asize, xme}, new int[]{yme-asize, yme-asize, yme}, 3);
//		}
//		else
//		{
//			// Arrow down.
//			g.fillRect(xms-thick/2, yme+asize, thick, yms-yme-asize);
//			g.fillPolygon(new int[]{xme-asize, xme+asize, xme}, new int[]{yme+asize, yme+asize, yme}, 3);
//		}
	}

	//-------- action listeners --------

	/**
	 *  Add a new action listener.
	 *  @param listener The listener.
	 */
	public void addActionListener(ActionListener listener)
	{
		this.listeners.add(listener);
	}

	/**
	 *  Remove an action listener.
	 *  @param listener The listener.
	 */
	public void removeActionListener(ActionListener listener)
	{
		this.listeners.remove(listener);
	}

	public static void main(String[] args)
	{
		World world = new World(5);
		WorldGUIPanel worldPanel = new WorldGUIPanel(world);
		worldPanel.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				System.out.println("Action event: " + e);
			}
		});
		JFrame frame = new JFrame();
		frame.getContentPane().add("Center", worldPanel);
		frame.setSize(400,400);
		frame.setLocation(SGUI.calculateMiddlePosition(frame));
		frame.setVisible(true);
	}
}
