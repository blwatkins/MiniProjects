// Point Class

function Point(x, y) {
    this.position = createVector(x, y);
    this.col = color(0, 0, 255);

    this.getAlpha = function() {
        return int(alpha(this.col));
    }

    this.getX = function() {
        return this.position.x;
    }

    this.getY = function() {
        return this.position.y;
    }

    this.distance = function(point) {
        let x1 = this.position.x;
        let y1 = this.position.y;
        let x2 = point.position.x;
        let y2 = point.position.y;
        return dist(x1, y1, x2, y2);
    }

    this.display = function() {
        stroke(this.col);
        fill(this.col);
        ellipse(this.position.x, this.position.y, 3, 3);
        this.fade();
    };

    this.fade = function() {
        let alphaValue = alpha(this.col);
        alphaValue--;
        alphaValue = constrain(alphaValue, 0, 255);
        this.col.setAlpha(alphaValue);
    };

    this.isFaded = function() {
        let alphaValue = alpha(this.col);
        return alphaValue <= 0;
    };
}