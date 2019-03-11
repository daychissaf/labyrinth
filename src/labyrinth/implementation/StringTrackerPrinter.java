package labyrinth.implementation;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import labyrinth.interfaces.Tracker;
import labyrinth.interfaces.TrackerPrinter;

public class StringTrackerPrinter implements TrackerPrinter {
    @Override
    public String printMonitoredPaths(Tracker tracker) {
        return String.join(";", monitoredPaths(tracker));
    }
    private List<String> monitoredPaths(Tracker tracker) {
        return tracker.monitoredPaths().stream().map(Objects::toString).collect(Collectors.toList());
    }
}
