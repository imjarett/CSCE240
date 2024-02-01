#include <iostream>
#include <string>
#include <fstream>
#include <sstream>

using namespace std;

int main()
{

    ifstream inputFile("./HW1/input.txt");
    string line;
    if (!inputFile.is_open()) {
        cout << "Error opening input file." << endl;
        return 1;
    }
    string operation;
    int num1;
    int num2;
    
    getline(inputFile, line);
    cout << "\t Reading first line's operation:" << line << endl;
    operation = line;
    getline(inputFile, line);
    cout << "\t Reading second line's integer:" << line << endl;
    num1 = stoi(line);
    getline(inputFile, line);
    cout << "\t Reading third line's integer:" << line << endl;
    num2 = stoi(line);
    inputFile.close();

    int result;

    if (operation == "add") {
        result = num1 + num2;
    } else if (operation == "subtract") {
        result = num1 - num2;
    } else if (operation == "multiply") {
        result = num1 * num2;
    } else if (operation == "divide") {
        if (num2 != 0) {
            result = num1 / num2;
        } else {
            cout << "Error: Division by zero." << endl;
            return 1;
        }
    } else {
        cout << "Error: Invalid operation." << endl;
        return 1;
    }
    ofstream outputFile("./HW1/output.txt");
    outputFile << "This is the result below" << endl;
    outputFile << result << endl;
    outputFile.close();
    cout << "Calculation completed. Result written to output.txt.";

    return 0;
}