#include <iostream>
#include <fstream>
#include <string>
#include <chrono>

using namespace std;

//factorialMath executes the math for the factorial of the parameter integer x
void factorialMath(int x){
    auto start = std::chrono::steady_clock::now(); // measures start time of function
    int result = 1;
    for (int i = x; i > 0; i--){
        result = result * i;
    }
    auto end = std::chrono::steady_clock::now(); // measures end time of function
    std::chrono::duration<double> duration = end - start;
    cout << x << "! = " << result << endl;
    cout << "Time for processing: " << duration.count() << " seconds." << endl;
}

//combonationMath executes the math of the combination of the number of items r and the set size n
void combinationMath(int n, int r){
    auto start = std::chrono::steady_clock::now(); // measures start time
    int rResult = 1;
    int nResult = 1;
    int subResult = 1;
    int result;
    for (int i = r; i > 0; i--){
        rResult = rResult * i;
    }
    for (int i = n; i > 0; i--){
        nResult = nResult * i;
    }
    for (int i = n - r; i > 0; i--){
        subResult = subResult * i;
    }
    result = (nResult / (rResult * subResult));
    auto end = std::chrono::steady_clock::now(); // measures end time
    std::chrono::duration<double> duration = end - start;
    cout << "C^"<< n << "_" << r << " = "<< result << endl;
    cout << "Time for processing: " << duration.count() << " seconds." << endl;
}

//bothMath executes the same math that factorialMath and comboMath do for n and r, and compares the times to see which took longer to process
void bothMath(int n, int r){
    auto factstart = std::chrono::steady_clock::now(); // measures start time of factorial
    int result = 1;
    for (int i = n; i > 0; i--){
        result = result * i;
    }
    auto factend = std::chrono::steady_clock::now(); // measures end time of factorial
    std::chrono::duration<double> factduration = factend - factstart;
    cout << n << "! = " << result << ", took: " << factduration.count() << " seconds." << endl;

    auto combostart = std::chrono::steady_clock::now(); // measures start time of combination
    int rResult = 1;
    int nResult = 1;
    int subResult = 1;
    int newresult;
    for (int i = r; i > 0; i--){
        rResult = rResult * i;
    }
    for (int i = n; i > 0; i--){
        nResult = nResult * i;
    }
    for (int i = n - r; i > 0; i--){
        subResult = subResult * i;
    }
    newresult = (nResult / (rResult * subResult));
    auto comboend = std::chrono::steady_clock::now(); // measures end time of combination
    std::chrono::duration<double> comboduration = comboend - combostart;
    cout << "C^"<< n << "_" << r << " = "<< newresult << ", took: " << comboduration.count() << " seconds." << endl;
    //The following if statement is used to see which function took longer to process
    if (factduration.count() > comboduration.count()){
        cout << n << "! took longer to process" << endl;
    }
    else if (factduration.count() < comboduration.count()){
        cout << "C^"<< n << "_" << r << " took longer to process" << endl;
    }
    else{
        cout << "Both took the same amount of time to process" << endl;
    }
}

//factorial is used to make sure the correct parameters are met to execute a factorial (i.e checks to ensure no negative numbers)
void factorial(){
    int x;
    bool valid = false;
    while (!valid){
        cout << "Input the number you would like to find the factorial of. (Number must be greater than or equal to 0)" << endl;
        cin >> x;
        if (x >= 0){
            factorialMath(x);
            valid = true;
            break;
        }
        else{
            cout << "Invalid choice: please input a number thats greater than or equal to 0" << endl;
        }
    }

}
//combination is used to make sure the correct parameters are met to execute a combination (i.e checks to ensure no numbers less than or equal to 0)
void combination(){
    int n;
    int r;
    bool valid = false;
    while (!valid){
        cout << "Input the selection set size number 'n'. (n must be greater than 0)" << endl;
        cin >> n;
        if (n > 0){
            cout << "Input the number of items 'r'. (r must be less than n)" << endl;
            cin >> r;
            if (r < 0){
                cout << "Invalid choice: please input a number for r thats less than n AND greater than 0" << endl;
            }
            else if (r < n){
                combinationMath(n, r);
                valid = true;
                break;
            }
            else{
                cout << "Invalid choice: please input a number for r thats less than n" << endl;
            }
        }
        else{
            cout << "Invalid choice: please input a number for n thats greater than 0" << endl;
        }
    }
}
//both is used to make sure the correct parameters are met to execute a combination (i.e checks to ensure no numbers less than or equal to 0)
void both(){
    int n;
    int r;
    bool valid = false;
    while (!valid){
        cout << "Input the number to do factorial and to be 'n' for combination. (This must be greater than 0)" << endl;
        cin >> n;
        if (n > 0){
            cout << "Input the number of items 'r'. (r must be less than n)" << endl;
            cin >> r;
            if (r < 0){
                cout << "Invalid choice: please input a number for r thats less than n AND greater than 0" << endl;
            }
            else if (r < n){
                bothMath(n, r);
                valid = true;
                break;
            }
            else if (r < 0){
                cout << "Invalid choice: please input a number for r thats less than n AND greater than 0" << endl;
            }
            else{
                cout << "Invalid choice: please input a number for r thats less than n" << endl;
            }
        }
        else{
            cout << "Invalid choice: please input a number for n thats greater than 0" << endl;
        }
    }
}

//run is the opening function which greets the user, introduces them to the program, and makes them select a valid calculation to execute
void run(){
    int choice;
    bool valid = false;
    cout << "Welcome to the FactorialFun program!\nInput 1 to calculate factorial\nInput 2 to calculate a Combination\nInput 3 to calculate both and compare the two execution times" << endl;
    while (!valid){
        cin >> choice;
        //switch statement used to check if input was valid and if so, select the correct function
        switch (choice){
            case 1:
                factorial();
                valid = true;
                break;
            case 2:
                combination();
                valid = true;
                break;
            case 3:
                both();
                valid = true;
                break;
            default:
                cout << "Invalid choice: please input valid choice from options given." << endl;
                break;
    }
    }
}

int main(){
    run();
    return 1;
}