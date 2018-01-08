import java.util.Comparator;

public class EventComparator {
  public static Comparator<Event> YearVal = new Comparator<Event>() {
    public int compare(Event e1, Event e2) {
      return Integer.compare(e1.getYearVal(), e2.getYearVal());
    }
  };
}