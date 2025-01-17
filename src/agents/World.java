package agents;

import java.io.Serializable;
import services.IWorld;

@SuppressWarnings("serial")
public class World implements IWorld, Serializable {
	protected int size;

	public World()
	{
		this(5);
	}

	public World(int size)
	{
		this.size = size;
	}
}
