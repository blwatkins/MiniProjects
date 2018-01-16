// This Day in History
// A series of slides describing events that occured on this day in history
// Images are obtained by scraping the Wikapedia webpage of the first topic listed in the data
// Generated from JSON Data
// Sources
// Today in History JSON Data -> http://history.muffinlabs.com/

ArrayList <Event> events = new ArrayList<Event>();
int eventIndex;

void settings() {
  //size(displayWidth, displayHeight);
  size(800, 800);
}

void setup() {
  colorMode(HSB, 360);
  createEvents();
  sortEvents();
  mapEventTextColors();
}

void draw() {
  background(0);
  displayCurrentEvent();
  displayIndexText();
}

void keyPressed() {

  if (key == 'a') {
    eventIndex--;
  } else if (key == 'd') {
    eventIndex++;
  }

  if (eventIndex < 0) {
    eventIndex = events.size() - 1;
  } else if (eventIndex >= events.size()) {
    eventIndex = 0;
  }
}

void sortEvents() {
  events.sort(EventComparator.Year);
}

void mapEventTextColors() {
  int minYear = events.get(0).getYear();
  int maxYear = events.get(events.size() - 1).getYear();

  for (Event e : events) {
    color c = mapColor(e.getYear(), minYear, maxYear);
    e.setTextColor(c);
  }
}

void displayCurrentEvent() {
  events.get(eventIndex).display();
}

void displayIndexText() {
  textAlign(CENTER, BOTTOM);
  fill(events.get(eventIndex).getTextColor());
  text((eventIndex + 1) + " / " + events.size(), width / 2, height - 15);
}