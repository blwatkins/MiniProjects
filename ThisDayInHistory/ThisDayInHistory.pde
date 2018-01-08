// This Day in History
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

void createEvents() {
  // 10/15 - BC
  // 1/1 - AD (events)
  // 10/14 - Weird Text thing - deaths
  // 10/17 AD 
  JSONObject allData = loadJSONObject("http://history.muffinlabs.com/date/1/1");
  JSONObject data = allData.getJSONObject("data");
  JSONArray events = data.getJSONArray("Events");
  JSONArray births = data.getJSONArray("Births");
  JSONArray deaths = data.getJSONArray("Deaths");

  createEvents(events, Event.Type.EVENT);
  createEvents(births, Event.Type.BIRTH);
  createEvents(deaths, Event.Type.DEATH);
}

void createEvents(JSONArray eventsArray, Event.Type type) {
  for (int i = 0; i < eventsArray.size(); i++) {
    try {
      JSONObject current = eventsArray.getJSONObject(i);
      String yearString = current.getString("year");
      String text = current.getString("text");
      int year = convertYearString(yearString);
      Event event = new Event(this, year, text, type);
      events.add(event);
    } 
    catch (Exception e) {
      println(e);
    }
  }
}

int convertYearString(String yearString) throws Exception {
  String[] year = split(yearString, ' ');
  int value = 0;

  if (year.length == 1) {
    value = Integer.parseInt(year[0]);
  } else if (year.length == 2) {

    if (year[0].equals("AD")) {
      value = Integer.parseInt(year[1]);
    } else if (year[1].equals("BC")) {
      value = Integer.parseInt(year[0]);
      value *= -1;
    }
  } else {
    throw new NumberFormatException("For input string: " + yearString);
  }

  return value;
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
  text(eventIndex + " / " + events.size(), width / 2, height - 15);
}