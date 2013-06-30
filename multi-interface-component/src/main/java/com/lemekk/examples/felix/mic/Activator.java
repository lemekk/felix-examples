package com.lemekk.examples.felix.mic;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {

	@Override
	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("Bundle start");
	}

	@Override
	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Bundle stop");
	}

}
