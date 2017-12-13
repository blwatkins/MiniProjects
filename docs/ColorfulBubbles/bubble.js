// Colorful Bubbles
// Bubble class

function Bubble(x, y, c) {
	this.r = random(10, min(width, height) / 10);

	this.pos = createVector(x, y);
	var deltaX = random(-width / 10, width / 10);
	var deltaY = random(-height / 10, height / 10);
	this.pos.add(createVector(deltaX, deltaY));

	this.c = c;

	this.display = function() {
		c.setAlpha(255);
		stroke(this.c);
		c.setAlpha(100);
		fill(this.c);
		ellipse(this.pos.x, this.pos.y, this.r * 2, this.r * 2);
	};

	this.move = function() {
		var deltaX = random(-width / 100, width / 100);
		var deltaY = random(-height / 100, height / 100);
		var delta = createVector(deltaX, deltaY);
		this.pos.add(delta);
	};

	this.mouseOver = function() {

		if (abs(this.pos.x - mouseX) < width / 10) {
			return true;
		} else {
			return false;
		}

	};

}
