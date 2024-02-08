#include <iostream>
#include <fstream>
#include <string>
#include "Rectangle.h"
#include "Circle.h"
#include "Triangle.h"

using namespace std;

void writeOutput(ofstream& outFile, Shape* shape, string property) {
    if (property == "1") {
        outFile << "AREA: " << shape->getArea() << endl;
    } else if (property == "2") {
        outFile << "PERIMETER: " << shape->getPerimeter() << endl;
    }
}

int main(int argc, char* argv[]) {
    if (argc != 2) {
        cout << "Usage: " << argv[0] << " <property>" << endl;
        return 1;
    }

    string property = argv[1];
    ifstream inFile("./HW3/data/input.txt");
    ofstream outFile("./HW3/data/output.txt");

    if (!inFile.is_open()) {
        cout << "Error opening input file." << endl;
        return 1;
    }

    if (!outFile.is_open()) {
        cout << "Error opening output file." << endl;
        return 1;
    }

    string shapeType;
    while (inFile >> shapeType) {
        if (shapeType == "RECTANGLE") {
            double length, breadth;
            inFile >> length >> breadth;
            Rectangle rectangle(length, breadth);
            rectangle.calculateArea();
            rectangle.calculatePerimeter();
            writeOutput(outFile, &rectangle, property);
        } else if (shapeType == "CIRCLE") {
            double radius;
            inFile >> radius;
            Circle circle(radius);
            circle.calculateArea();
            circle.calculatePerimeter();
            writeOutput(outFile, &circle, property);
        } else if (shapeType == "TRIANGLE") {
            double side1, side2, side3;
            inFile >> side1 >> side2 >> side3;
            Triangle triangle(side1, side2, side3);
            triangle.calculateArea();
            triangle.calculatePerimeter();
            writeOutput(outFile, &triangle, property);
        } else {
            cout << "Invalid shape specified." << endl;
            return 1;
        }
    }

    inFile.close();
    outFile.close();

    return 0;
}