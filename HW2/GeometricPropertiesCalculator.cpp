#include <iostream>
#include <fstream>
#include <string>
#include <cmath>
#include <math.h>

using namespace std;

// Function to calculate area of rectangle
double calculateRectangleArea(double length, double breadth) {
    return length * breadth;
}

// Function to calculate perimeter of rectangle
double calculateRectanglePerimeter(double length, double breadth) {
    return 2 * (length + breadth);
}

// Function to calculate area of circle
double calculateCircleArea(double radius) {
    return 3.14 * radius * radius;
}

// Function to calculate perimeter of circle
double calculateCirclePerimeter(double radius) {
    return 2 * 3.14 * radius;
}
// Function to calculate area of triangle
double calculateTriangleArea(double side1, double side2, double side3) {
    double s = (side1 + side2 + side3) / 2;
    return sqrt(s * (s - side1) * (s - side2) * (s - side3));
}

// Function to calculate perimeter of triangle
double calculateTrianglePerimeter(double side1, double side2, double side3) {
    return side1 + side2 + side3;
}

int main(int argc, char* argv[]) {
    if (argc != 2) {
        cerr << "Usage: " << argv[0] << " <property_code>" << endl;
        return 1;
    }

    int propertyCode = stoi(argv[1]);

    ifstream inputFile("input.txt");
    ofstream outputFile("output.txt");

    if (!inputFile.is_open() || !outputFile.is_open()) {
        cerr << "Error opening files." << endl;
        return 1;
    }

    string shape;
    while (inputFile >> shape) {
        double value1, value2, value3;
        inputFile >> value1 >> value2 >> value3;

        outputFile << shape;

        switch (propertyCode) {
            case 1: // Calculate AREA
                if (shape == "RECTANGLE") {
                    outputFile << " AREA " << calculateRectangleArea(value1, value2);
                } else if (shape == "CIRCLE") {
                    outputFile << " AREA " << calculateCircleArea(value1);
                } else if (shape == "TRIANGLE") {
                    if (value1 + value2 > value3 && value2 + value3 > value1 && value3 + value1 > value2) {
                        outputFile << " AREA " << calculateTriangleArea(value1, value2, value3);
                    } else {
                        outputFile << " AREA Not enough information to calculate";
                    }
                }
                break;

            case 2: // Calculate PERIMETER
                if (shape == "RECTANGLE") {
                    outputFile << " PERIMETER " << calculateRectanglePerimeter(value1, value2);
                } else if (shape == "CIRCLE") {
                    outputFile << " PERIMETER " << calculateCirclePerimeter(value1);
                } else if (shape == "TRIANGLE") {
                    outputFile << " PERIMETER " << calculateTrianglePerimeter(value1, value2, value3);
                }
                break;

            default:
                cerr << "Invalid property code. Use 1 for AREA or 2 for PERIMETER." << endl;
                return 1;
        }

        outputFile << endl;
    }

    inputFile.close();
    outputFile.close();

    cout << "Calculation completed. Results written to output.txt." << endl;

    return 0;
}