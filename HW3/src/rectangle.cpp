#include "Rectangle.h"

Rectangle::Rectangle(double l, double b) : length(l), breadth(b) {}

Rectangle::~Rectangle() {}

void Rectangle::calculateArea() {
    area = length * breadth;
}

void Rectangle::calculatePerimeter() {
    perimeter = 2 * (length + breadth);
}