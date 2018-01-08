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
  JSONObject allData = loadJSONObject("http://history.muffinlabs.com/date");
  JSONObject data = allData.getJSONObject("data");
  JSONArray events = data.getJSONArray("Events");
  JSONArray births = data.getJSONArray("Births");
  JSONArray deaths = data.getJSONArray("Deaths");
}

void draw() {
}