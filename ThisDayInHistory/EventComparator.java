// This Day in History
// EventComparator class
// Used to sort all events by the year they occurred

import java.util.Comparator;

public class EventComparator {

  public static Comparator<Event> Year = new Comparator<Event>() {

    public int compare(Event e1, Event e2) {
      return Integer.compare(e1.getYear(), e2.getYear());
    }
    
  };
  
}