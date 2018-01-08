int getMaxInt(int[] array) {
  int max = array[0];
  for (int i = 1; i < array.length; i++) {
    max = max(max, array[i]);
  }
  return max;
}

int getMinInt(int[] array) {
  int min = array[0];
  for (int i = 1; i < array.length; i++) {
    min = min(min, array[i]);
  }
  return min;
}

float getMaxFloat(float[] array) {
  float max = array[0];
  for (int i = 1; i < array.length; i++) {
    max = max(max, array[i]);
  }
  return max;
}

float getMinFloat(float[] array) {
  float min = array[0];
  for (int i = 1; i < array.length; i++) {
    min = min(min, array[i]);
  }
  return min;
}