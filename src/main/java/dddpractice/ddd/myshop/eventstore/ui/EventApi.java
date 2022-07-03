package dddpractice.ddd.myshop.eventstore.ui;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dddpractice.ddd.myshop.eventstore.api.EventEntry;
import dddpractice.ddd.myshop.eventstore.api.EventStore;

@RestController
public class EventApi {
	private EventStore eventStore;

	public EventApi(EventStore eventStore) {
		this.eventStore = eventStore;
	}

	@RequestMapping(value = "/api/events", method = RequestMethod.GET)
	public List<EventEntry> list(
		@RequestParam("offset") Long offset,
		@RequestParam("limit") Integer limit) {
		return eventStore.get(offset, limit);
	}
}
