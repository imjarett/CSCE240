#include "Circle.h"
#include <cmath>

Circle::Circle(double r) : radius(r) {}

Circle::~Circle() {}

void Circle::calculateArea() {
    area = M_PI * radius * radius;
}

void Circle::calculatePerimeter() {
    perimeter = 2 * M_PI * radius;
}