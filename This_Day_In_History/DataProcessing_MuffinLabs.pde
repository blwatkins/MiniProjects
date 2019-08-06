// This Day in History
// Data Processing Functions for http://history.muffinlabs.com/date

void createEvents() {
  JSONObject allData = loadJSONObject("http://history.muffinlabs.com/date");
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
      String url = getEventURL(current);
      Event event = new Event(this, year, text, url, type);
      events.add(event);
    } catch (Exception e) {
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

String getEventURL(JSONObject event) {
  String url = "";

  try {
    JSONArray links = event.getJSONArray("links");
    url = links.getJSONObject(0).getString("link");
  } catch (Exception e) {
    println(e);
  }

  return url;
}