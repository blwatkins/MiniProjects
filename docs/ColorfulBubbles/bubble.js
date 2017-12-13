// Colorful Bubbles
// Bubble class

function Bubble(x, y, c) {
	this.r = 25;
	this.pos = createVector(x, y);
	this.c = c;

	this.display = function() {
		c.setAlpha(255);
		stroke(this.c);
		c.setAlpha(100);
		fill(this.c);
		ellipse(this.pos.x, this.pos.y, this.r * 2, this.r * 2);
	};

}