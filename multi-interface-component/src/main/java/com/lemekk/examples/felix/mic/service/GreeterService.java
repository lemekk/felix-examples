package com.lemekk.examples.felix.mic.service;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Properties;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Service;
import org.osgi.framework.Constants;

import com.lemekk.examples.felix.mic.api.Greeter;

/**
 * Service that prints "hello" every 10 seconds but also prints it on demand.
 * 
 * @author lemekk
 * 
 */
// @formatter:off
@Component
@Service(value={Runnable.class, Greeter.class})
@Properties({
	@Property(name = Constants.SERVICE_DESCRIPTION, value = "Greeter Service"),
	@Property(name = Constants.SERVICE_VENDOR, value = "lemekk.com"),
	@Property(name = "scheduler.expression", value = "0,10,20,30,40,50 * * * * ?", 
		label = "Hello schedule", description = "Defines schedule for printing hello")
})
// @formatter:on
public class GreeterService implements Runnable, Greeter {

	@Override
	public void sayHello() {
		sayHello("Greeter interface");
	}

	@Override
	public void run() {
		sayHello("Schedule");
	}

	private void sayHello(String source) {
		System.out.println("Hello (source: " + source + ")");
	}

}
