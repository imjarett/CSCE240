#ifndef CIRCLE_H
#define CIRCLE_H

#include "Shape.h"

class Circle : public Shape {
private:
    double radius;
public:
    Circle(double r);
    ~Circle();
    void calculateArea() override;
    void calculatePerimeter() override;
};

#endif