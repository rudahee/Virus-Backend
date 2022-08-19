package com.virus.services;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class StartupService implements ApplicationListener<ApplicationReadyEvent> {

	/**
	 * This event is executed as late as conceivably possible to indicate that the
	 * application is ready to service requests.
	 */

	@Autowired
	private InitializeGameConstants constants;

	
	@Override
	public void onApplicationEvent(final ApplicationReadyEvent event) {

		Log log = LogFactory.getLog("Log");

		if (constants.existsAnyCards()) {	
			constants.initializeCards();
						
			log.info("INFO: Cards created.");
		} else {
			log.info("INFO: Cards already exists.");
		}
	}
}