#include <iostream>
#include <vector>
#include <cstdlib>
#include <ctime>
#include <algorithm>
#include <chrono>

using namespace std;

// Function to generate n random numbers and store in an array and vector
void generateRandomNumbers(int n, int* arr, vector<int>& vec) {
    // Generate random numbers
    for (int i = 0; i < n; i++) {
        int randomNumber = rand();
        arr[i] = randomNumber;
        vec.push_back(randomNumber);
    }
}

// Function to sort an array using C++ Standard library's sort
void sortArray(int n, int* arr) {
    sort(arr, arr + n);
}

// Function to sort a vector using Bubble Sort
void sortVector(vector<int>& vec) {
    for (size_t i = 0; i < vec.size() - 1; i++) {
        for (size_t j = 0; j < vec.size() - i - 1; j++) {
            if (vec[j] > vec[j + 1]) {
                swap(vec[j], vec[j + 1]);
            }
        }
    }
}
// VALIDATION CODE FUNCTION
bool checkEquality(int n, const int* arr, const vector<int>& vec) {
    for (int i = 0; i < n; i++) {
        if (arr[i] != vec[i]) {
            return false;
        }
    }
    return true;
}

int main() {
    srand(time(nullptr)); // Seed random number generator
    // Test cases
    vector<int> testCases = {100, 1000, 10000, 100000};
    for (int n : testCases) {
        int* arr = new int[n];
        vector<int> vec;
        // Generate random numbers and store in array and vector
        generateRandomNumbers(n, arr, vec);
        // Measure time for sorting array
        auto startArray = chrono::high_resolution_clock::now();
        sortArray(n, arr);
        auto endArray = chrono::high_resolution_clock::now();
        chrono::duration<double> diffArray = endArray - startArray;
        // Measure time for sorting vector
        auto startVector = chrono::high_resolution_clock::now();
        sortVector(vec);
        auto endVector = chrono::high_resolution_clock::now();
        chrono::duration<double> diffVector = endVector - startVector;
        // Check equality
        bool isEqual = checkEquality(n, arr, vec);
        // Print results
        cout << "For n = " << n << ":\n";
        cout << "Time taken for Array: " << diffArray.count() << " seconds\n";
        cout << "Time taken for Vector: " << diffVector.count() << " seconds\n";
        cout << "Array and Vector are " << (isEqual ? "equal" : "not equal") << "\n\n";
        delete[] arr;
    }
    return 0;
}