package com.lemekk.examples.felix.mic.service;

import org.apache.felix.scr.annotations.Activate;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Properties;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Service;
import org.osgi.service.component.ComponentContext;

import com.lemekk.examples.felix.mic.api.Greeter;

/**
 * Service that prints "hello" every 10 seconds but also prints it on demand.
 * 
 * @author lemekk
 * 
 */
// @formatter:off
@Component(immediate=true, metatype=true, name="Greeter service")
@Service(Greeter.class)
@Properties({
	@Property(name="terefere")
})
// @formatter:on
public class GreeterService implements Greeter {

	@Activate
	protected void activate(final ComponentContext context) {
		System.out.println("GreeterService up! (" + context.getProperties().get("terefere") + ")");
	}

	@Override
	public void sayHello() {
		sayHello("Greeter interface");
	}

	private void sayHello(String source) {
		System.out.println("Hello (source: " + source + ")");
	}

}
