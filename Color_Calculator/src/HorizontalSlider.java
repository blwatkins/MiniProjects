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
    private float currentValue;
    private SliderValue sliderValue;

    public HorizontalSlider(PApplet p) {
        init(p);
        position = new PVector();
        width = 100;
        height = 10;
        minValue = 0;
        maxValue = 0;
        currentValue = minValue;
        sliderValue = new SliderValue(p);
    }

    public HorizontalSlider(PApplet p, PVector position, float width, float height, float minValue, float maxValue) {
        init(p);
        this.position = position.copy();
        this.width = width;
        this.height = height;
        PApplet.constrain(height, 1, width / 2);
        this.minValue = minValue;
        this.maxValue = maxValue;
        currentValue = minValue;
        PVector sVPosition = new PVector(position.x, position.y + height / 2);
        sliderValue = new SliderValue(p, sVPosition, height * 1.5f);
    }

    private void init(PApplet p) {
        this.p = p;
        active = false;
    }

    public void display() {
        selectStyle();
        displayBar();
        displayEndpoints();
        sliderValue.display();

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

    }

}
