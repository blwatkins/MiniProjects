// HorizontalSlider Class

import processing.core.PApplet;
import processing.core.PVector;

public class HorizontalSlider {
    private PApplet p;
    private boolean active;
    private PVector position;
    private float width;
    private float height;
    private float minValue;
    private float maxValue;
    private SliderValue sliderValue;

    public HorizontalSlider(PApplet p) {
        init(p);
        position = new PVector();
        width = 100;
        height = 10;
        minValue = 0;
        maxValue = 0;
        sliderValue = new SliderValue(p);
    }

    public HorizontalSlider(PApplet p, PVector position, float width, float height, float minValue, float maxValue) {
        init(p);
        this.position = position.copy();
        this.width = width;
        this.height = height;
        this.height = PApplet.constrain(this.height, 1, width / 5);
        this.minValue = minValue;
        this.maxValue = maxValue;
        PVector sVPosition = new PVector(position.x, position.y + this.height / 2);
        sliderValue = new SliderValue(p, sVPosition, this.height * 1.5f);
    }

    private void init(PApplet p) {
        this.p = p;
        active = false;
    }

    public float getCurrentValue() {
        float valueX = sliderValue.getPosition().x;
        float value = PApplet.map(valueX, position.x, position.x + width, minValue, maxValue);
        return value;
    }

    public void display() {
        selectStyle();
        displayBar();
        displayEndpoints();
        sliderValue.display();
        displayIntValue();

        if (active) {
            moveSliderValue();
        }
    }

    private void selectStyle() {
        p.noStroke();
        p.fill(100);
    }

    private void displayBar() {
        p.rect(position.x, position.y, width, height);
    }

    private void displayEndpoints() {
        p.ellipse(position.x, position.y + height/2, height ,height);
        p.ellipse(position.x + width, position.y + height/2, height ,height);
    }

    public void mousePressed(float mouseX, float mouseY) {

        if (sliderValue.rollover(mouseX, mouseY)) {
            active = !active;
        }

    }

    private void moveSliderValue() {
        sliderValue.updatePosition(p.mouseX, position.x, position.x + width);
    }

    public void displayFloatValue() {
        float value = getCurrentValue();
        p.textAlign(p.LEFT, p.CENTER);
        p.textSize((int)height * 2);
        p.text(value, position.x + width + (height * 1.5f / 2), position.y);
    }

    public void displayIntValue() {
        int value = (int)getCurrentValue();
        displayValue(Integer.toString(value));
    }

    private void displayValue(String value) {
        p.textAlign(p.LEFT, p.CENTER);
        p.textSize((int)height * 2);
        p.text(value, position.x + width + (height * 1.5f / 2), position.y);
    }

}
