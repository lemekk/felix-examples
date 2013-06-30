package com.lemekk.examples.felix.mic.service;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Properties;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.Service;
import org.osgi.framework.Constants;

import com.lemekk.examples.felix.mic.api.Greeter;

/**
 * Client of the {@link Greeter} service. It calls the service every 20 seconds.
 * 
 * @author lemekk
 * 
 */
//@formatter:off
@Component
@Service
@Properties({
	@Property(name = Constants.SERVICE_DESCRIPTION, value = "Client of the Greeter Service"),
	@Property(name = Constants.SERVICE_VENDOR, value = "lemekk.com"),
	@Property(name = "scheduler.expression", value = "0,20,40 * * * * ?", 
		label = "Hello schedule", description = "Defines schedule for calling Greeter service")
})
//@formatter:on
public class ClientService implements Runnable {

	@Reference
	private Greeter greeter;

	@Override
	public void run() {
		greeter.sayHello();
	}

}
