package br.rio.puc.jat.hello;

import jade.core.Agent;

public class HelloAgent extends Agent {

	private static final long serialVersionUID = 1L;

	@Override
	public void setup() {
		System.out.println("Hello Agent!");
	}

}
