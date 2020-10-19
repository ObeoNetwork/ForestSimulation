/*******************************************************************************
 * Copyright (c) 2020 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * Contributors:
 *     Arthur Daussy - initial API and implementation
 *******************************************************************************/
package fr.obeo.forestsimulation.rcp.runners;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.eclipse.collections.api.tuple.Pair;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.e4.ui.workbench.UIEvents;

@Singleton
public class GrowOrchestrator {
	
	@Inject
	IEventBroker eventBroker;

	private ScheduledExecutorService scheduler;

	public void start(List<Pair<? extends Runnable, Integer>> perdiodicTasks) {
		scheduler = Executors.newScheduledThreadPool(perdiodicTasks.size());
		for (Pair<? extends Runnable, Integer> p : perdiodicTasks) {
			scheduler.scheduleAtFixedRate(p.getOne(), 0, p.getTwo().intValue(), TimeUnit.MILLISECONDS);
		}
		eventBroker.send(UIEvents.REQUEST_ENABLEMENT_UPDATE_TOPIC, UIEvents.ALL_ELEMENT_ID);
	}

	public void stop() {
		if (scheduler != null) {
			scheduler.shutdown();
			scheduler = null;
		}
		eventBroker.send(UIEvents.REQUEST_ENABLEMENT_UPDATE_TOPIC, UIEvents.ALL_ELEMENT_ID);
	}

	public boolean isStarted() {
		return scheduler != null;
	}
}
