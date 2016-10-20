package agents;

import jadex.bridge.service.annotation.Service;
import jadex.micro.annotation.Agent;
import jadex.micro.annotation.Description;
import jadex.micro.annotation.ProvidedService;
import jadex.micro.annotation.ProvidedServices;
import services.IChatService;

@Agent
@Service
@ProvidedServices(@ProvidedService(type=IChatService.class))
@Description("Agent Person")
public class PersonBDI implements IChatService {

	@Override
	public void sendMessage(int x, int y) {
		// TODO Auto-generated method stub
		
	}

}