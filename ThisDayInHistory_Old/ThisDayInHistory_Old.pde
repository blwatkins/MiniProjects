// Brittni Watkins
// This Day in History Program generated from JSON Data

import java.util.Arrays;

JSONObject dateData;
JSONArray events;
JSONArray births;
JSONArray deaths;
int eventsCount;
int[] allYears;
int maxYear;
int minYear;

Event[] allEvents;
int currIndex;

int startTime;
int endTime;
int deltaTime;

void setup() {
  size(500, 500);
  colorMode(HSB, 255);
  
  events = new JSONArray();
  births = new JSONArray();
  deaths = new JSONArray();
  loadJSONData();
  
  eventsCount = getEventsCount();
  
  allYears = getYears();
  maxYear = getMaxInt(allYears);
  minYear = getMinInt(allYears);

  allEvents = createEvents();
  Arrays.sort(allEvents, EventComparator.YearVal);
  currIndex = 0;
  
  startTime = 0;
  deltaTime = 10000;
  endTime = startTime + deltaTime;
}

void draw() {
  allEvents[currIndex].display();
  timing();
}

void timing() {
  if (millis() > endTime) {
    startTime = millis();
    deltaTime = 10000;
    endTime = startTime + deltaTime;
    increaseCurrIndex();
  }
}

void keyPressed() {
  if (keyCode == RIGHT) {
    increaseCurrIndex();
  } else if (keyCode == LEFT) {
    decreaseCurrIndex();
  }
}

void increaseCurrIndex() {
  currIndex++;
  
  if (currIndex >= eventsCount) {
    currIndex = 0;
  }
}

void decreaseCurrIndex() {
  currIndex--;
  
  if (currIndex < 0) {
    currIndex = eventsCount - 1;
  }
}

void loadJSONData() {
  dateData = loadJSONObject("http://history.muffinlabs.com/date");
  JSONObject data = dateData.getJSONObject("data");
  events = data.getJSONArray("Events");
  births = data.getJSONArray("Births");
  deaths = data.getJSONArray("Deaths");
}

Event createEvent(JSONArray eventsArr, int index, String type) {
  JSONObject eObj = new JSONObject();
  eObj = eventsArr.getJSONObject(index);
  String year = eObj.getString("year");
  String text = "";
  try {
    text = eObj.getString("text");
  } catch (Exception e) {
    println(e);
    text = "";
  }
  
   

  Event e = new Event(this, text);
  e.setYear(year, calculateYearVal(year), maxYear, minYear);
  e.setType(type);

  return e;
}

Event[] createEvents() {
  Event[] es = new Event[eventsCount];
  int count = 0;
  
  for (int i = 0; i < events.size(); i++) {
    es[count] = createEvent(events, i, "event"); 
    count++;
  }

  for (int i = 0; i < births.size(); i++) {
    es[count] = createEvent(births, i, "birth"); 
    count++;
  }

  for (int i = 0; i < deaths.size(); i++) {
    es[count] = createEvent(deaths, i, "death"); 
    count++;
  }

  return es;
}

int getEventsCount() {
  int count = 0;
  count += events.size();
  count += births.size();
  count += deaths.size();
  return count;
}

int[] getYears() {
  int[] years = new int[eventsCount];
  int count = 0;
  JSONObject event;

  for (int i = 0; i < events.size(); i++) {
    event = events.getJSONObject(i);
    String year = event.getString("year");
    int val = calculateYearVal(year);
    years[count] = val;
    count++;
  }

  for (int i = 0; i < births.size(); i++) {
    event = births.getJSONObject(i);
    String year = event.getString("year");
    int val = calculateYearVal(year);
    years[count] = val;
    count++;
  }

  for (int i = 0; i < deaths.size(); i++) {
    event = deaths.getJSONObject(i);
    String year = event.getString("year");
    int val = calculateYearVal(year);
    years[count] = val;
    count++;
  }

  return years;
}

int calculateYearVal(String year) {
  String[] pieces = split(year, ' ');
  int val = 0;

  if (pieces.length > 1) {
    try {
      val = Integer.parseInt(pieces[0]) * -1;
    } catch (Exception e) {
      println(year);
      println(e);
      val = 0;
    }
  } else {
    try {
      val = Integer.parseInt(pieces[0]);
    } catch (Exception e) {
      println(year);
      println(e);
      val = 0;
    }
  }

  return val;
}