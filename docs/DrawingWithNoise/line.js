// Line Class

function Line(s, e) {
    this.s = createVector(s.getX(), s.getY());
    this.e = createVector(e.getX(), e.getY());
    this.col = color(255, 0, 0);

    this.display = function() {
        stroke(this.col);
        line(this.s.x, this.s.y, this.e.x, this.e.y);
        this.fade();
    };
    
    this.fade = function() {
        let alphaValue = alpha(this.col);
        alphaValue += deltaAlpha;
        alphaValue = constrain(alphaValue, 0, 255);
        this.col.setAlpha(alphaValue);
    };

    this.isFaded = function() {
        let alphaValue = alpha(this.col);
        return alphaValue <= 0;
    };
}