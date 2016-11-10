import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import jadex.bridge.IComponentStep;
import jadex.bridge.IExternalAccess;
import jadex.bridge.IInternalAccess;
import jadex.bridge.component.IMonitoringComponentFeature;
import jadex.bridge.service.types.monitoring.IMonitoringEvent;
import jadex.bridge.service.types.monitoring.IMonitoringService.PublishEventLevel;
import jadex.commons.future.IFuture;
import jadex.commons.future.IResultListener;
import jadex.commons.future.IntermediateDefaultResultListener;
import jadex.commons.gui.SGUI;
import jadex.commons.gui.future.SwingIntermediateResultListener;
import jadex.commons.transformation.annotations.Classname;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.ImageIcon;

public class WorldGUI extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//-------- attributes --------

	/** The board to visualize. */
	protected WorldInterface map;

	//-------- constructors --------

	/**
	 *  Create a new board gui.
	 */
	public WorldGUI(final IExternalAccess agent, final WorldInterface map)
	{
		this.map = map;
//		final BoardPanel bp = new BoardPanel(board);
//		this.board.addPropertyChangeListener(new PropertyChangeListener()
//		{
//			public void propertyChange(PropertyChangeEvent evt)
//			{
//				bp.update(evt);
//			}
//		});
//
//		this.getContentPane().add("Center", bp);
//		if(controls)
//		{
//			final BoardControlPanel bcp = new BoardControlPanel(board, bp);
//			this.getContentPane().add("South", bcp);
//		}
		this.setTitle("Puzzle Board");
		this.setSize(800, 800);
		this.setLocation(SGUI.calculateMiddlePosition(this));
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("../resources/img/wfloor2.jpg"));
		getContentPane().add(label, BorderLayout.CENTER);
		this.setVisible(true);

		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				agent.killComponent();
			}
		});
		// Dispose frame on exception.
		IResultListener<Void>	dislis	= new IResultListener<Void>()
		{
			public void exceptionOccurred(Exception exception)
			{
				dispose();
			}
			public void resultAvailable(Void result)
			{
			}
		};
		
		agent.scheduleStep(new IComponentStep<Void>()
		{
			@Classname("dispose")
			public IFuture<Void> execute(IInternalAccess ia)
			{
//				IBDIAgentFeature bdif = ia.getComponentFeature(IBDIAgentFeature.class);
//				bia.addComponentListener(new TerminationAdapter()
//				{
//					public void componentTerminated()
//					{
//						SwingUtilities.invokeLater(new Runnable()
//						{
//							public void run()
//							{
//								BoardGui.this.dispose();
//							}
//						});
//					}
//				});
				
				ia.getComponentFeature(IMonitoringComponentFeature.class).subscribeToEvents(IMonitoringEvent.TERMINATION_FILTER, false, PublishEventLevel.COARSE)
					.addResultListener(new SwingIntermediateResultListener<IMonitoringEvent>(new IntermediateDefaultResultListener<IMonitoringEvent>()
				{
					public void intermediateResultAvailable(IMonitoringEvent result)
					{
						WorldGUI.this.dispose();
					}
				}));
				return IFuture.DONE;
			}
		}).addResultListener(dislis);
	}
}
