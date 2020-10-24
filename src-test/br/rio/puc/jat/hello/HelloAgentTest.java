package br.rio.puc.jat.hello;

import org.junit.jupiter.api.Test;

import br.rio.puc.jat.aspects.monitor.AgentMonitorService;
import br.rio.puc.jat.core.JadeTestCase;

public class HelloAgentTest extends JadeTestCase {

	@Test
	public void testBelief() {

		registerAndStartAgent("hello", "HelloAgent");

		AgentMonitorService.waitUntilTestHasFinished("hello");

		String actual = (String) getBeliefValue("hello", "message");
		String expected = "Hello Agent!";

		assertEquals(expected, actual);

	}

}
