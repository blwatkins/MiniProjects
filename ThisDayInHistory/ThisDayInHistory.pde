// This Day in History
// Generated from JSON Data
// Sources
// Today in History JSON Data -> http://history.muffinlabs.com/

ArrayList <Event> events = new ArrayList<Event>();

void settings() {
  //size(displayWidth, displayHeight);
  size(800, 800);
}

void setup() {
  createEvents();
}

void draw() {
  background(0);
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
  //createEvents(births);
  //createEvents(deaths);
}

void createEvents(JSONArray eventsArray, Event.Type type) {
  for (int i = 0; i < eventsArray.size(); i++) {
    try {
      JSONObject current = eventsArray.getJSONObject(i);
      String yearString = current.getString("year");
      String text = current.getString("text");
      int year = convertYearString(yearString);
      
      Event e = new Event(this, year, text, type);
      println(e);
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