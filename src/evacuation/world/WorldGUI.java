package evacuation.world;

import javax.swing.JFrame;

import jadex.bridge.IExternalAccess;
import jadex.commons.beans.PropertyChangeEvent;
import jadex.commons.beans.PropertyChangeListener;

public class WorldGUI extends JFrame {
	//-------- attributes --------

	/** The board to visualize. */
	protected World world;

	//-------- constructors --------

	/**
	 *  Create a new board gui.
	 */
	public WorldGUI(IExternalAccess agent, final World world)
	{
		this(agent, world, false);
	}

	/**
	 *  Create a new board gui.
	 */
	public WorldGUI(final IExternalAccess agent, final World world, boolean controls)
	{
//		this.world = world;
//		final WorldGUIPanel worldPanel = new WorldGUIPanel(world);
//		this.world.addPropertyChangeListener(new PropertyChangeListener()
//		{
//			public void propertyChange(PropertyChangeEvent evt)
//			{
//				worldPanel.update(evt);
//			}
//		});
//
//		this.getContentPane().add("Center", worldPanel);
//		if(controls)
//		{
//			final WorldGUIPanel bcp = new WorldGUIPanel(world, worldPanel);
//			this.getContentPane().add("South", bcp);
//		}
//		this.setTitle("Puzzle Board");
//		this.setSize(400, 400);
//		this.setLocation(SGUI.calculateMiddlePosition(this));
//		this.setVisible(true);
//
//		addWindowListener(new WindowAdapter()
//		{
//			public void windowClosing(WindowEvent e)
//			{
//				agent.killComponent();
//			}
//		});
//		// Dispose frame on exception.
//		IResultListener<Void>	dislis	= new IResultListener<Void>()
//		{
//			public void exceptionOccurred(Exception exception)
//			{
//				dispose();
//			}
//			public void resultAvailable(Void result)
//			{
//			}
//		};
//		
//		agent.scheduleStep(new IComponentStep<Void>()
//		{
//			@Classname("dispose")
//			public IFuture<Void> execute(IInternalAccess ia)
//			{
//				ia.getComponentFeature(IMonitoringComponentFeature.class).subscribeToEvents(IMonitoringEvent.TERMINATION_FILTER, false, PublishEventLevel.COARSE)
//					.addResultListener(new SwingIntermediateResultListener<IMonitoringEvent>(new IntermediateDefaultResultListener<IMonitoringEvent>()
//				{
//					public void intermediateResultAvailable(IMonitoringEvent result)
//					{
//						BoardGui.this.dispose();
//					}
//				}));
//				return IFuture.DONE;
//			}
//		}).addResultListener(dislis);
	}
}
