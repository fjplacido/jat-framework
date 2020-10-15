package br.rio.puc.jat.hello;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jade.BootProfileImpl;
import jade.core.Agent;
import jade.core.ProfileImpl;
import jade.wrapper.AgentContainer;
import jade.wrapper.AgentController;
import jade.wrapper.PlatformController;

/**
 * @author Francisco Cunha
 * 
 */
public class Starter {

	private static final Map<String, Agent> agents;

	static {
		agents = new HashMap<String, Agent>();
		agents.put("HelloAgent", new HelloAgent());
	};

	public static void main(String[] args) {
		new Starter();
	}

	private ProfileImpl bootProfile;

	private jade.core.Runtime runtime;

	public Starter() {

		List<String> params = new ArrayList<String>();
		params.add("-gui");
		params.add("-detect-main:false");

		System.out.println("Plataform parameters: " + params);

		this.bootProfile = new BootProfileImpl(params.toArray(new String[0]));

		this.runtime = jade.core.Runtime.instance();
		PlatformController controller = runtime.createMainContainer(bootProfile);

		for (String agentName : agents.keySet()) {
			try {
				AgentController ac = ((AgentContainer) controller).acceptNewAgent(agentName, agents.get(agentName));
				ac.start();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

}
