#include <iostream>
#include <string>

using namespace std;

class BaseEmailHeaderType {
private:
    string sender;
    string recipient;
    string subject;
    string body;

public:
    // Constructor
    BaseEmail(const string& sender, const string& recipient, const string& subject, const string& body) {
        this->sender = sender;
        this->recipient = recipient;
        this->subject = subject;
        this->body = body;
    }

    // Method to display email details
    void display() {
        cout << "Sender: " << sender << endl;
        cout << "Recipient: " << recipient << endl;
        cout << "Subject: " << subject << endl;
        cout << "Body: " << body << endl;
    }
};

#endif