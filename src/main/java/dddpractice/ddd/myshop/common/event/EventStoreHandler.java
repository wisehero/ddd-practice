package dddpractice.ddd.myshop.common.event;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import dddpractice.ddd.myshop.eventstore.api.EventStore;

@Component
public class EventStoreHandler {
	private EventStore eventStore;

	public EventStoreHandler(EventStore eventStore) {
		this.eventStore = eventStore;
	}

	@EventListener(Event.class)
	public void handle(Event event) {
		eventStore.save(event);
	}
}
