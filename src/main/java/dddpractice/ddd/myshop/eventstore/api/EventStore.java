package dddpractice.ddd.myshop.eventstore.api;

import java.util.List;

public interface EventStore {
	void save(Object event);

	List<EventEntry> get(long offset, long limit);
}
