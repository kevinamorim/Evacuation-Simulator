import java.io.Serializable;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.HashMap;
//import java.util.List;
//import evacuation.MapInterface;

//import jadex.commons.SimplePropertyChangeSupport;
//import jadex.commons.beans.PropertyChangeListener;

public class World implements WorldInterface, Serializable {
	/** The size. */
	protected int size;

// -------- constructors --------

	/**
	 *  Create a new board.
	 */
	public World()
	{
		this(5);
	}

	/**
	 *  Create a new board.
	 */
	public World(int size)
	{
		this.size = size;
	}
}
