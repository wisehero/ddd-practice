package dddpractice.ddd.myshop.integration;

import dddpractice.ddd.myshop.eventstore.api.EventEntry;

public interface EventSender {
	void send(EventEntry event);
}
