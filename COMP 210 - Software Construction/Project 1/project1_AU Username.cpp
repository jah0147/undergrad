/*
 * Filename: project1_AU.cpp
 * Jacob Howard
 * UserID: jah0147
 * Solution: The code will take user inputs of loan amounts,
 * interest rate per year, and monthly payments to calculate various things in a while loop.
 *
 * I received some assistance from TAs and Peers.
 */

#include <iostream>
#include <iomanip>

using namespace std;
int main(){

    //Correctly adjusts decimals to two places for currency values
    cout.setf(ios::fixed);
    cout.setf(ios::showpoint);
    cout.precision(2);

    //User input variables
    float loanAmount,interestRate,monthPay;
    cout<<"Loan Amount : ";
    cin>>loanAmount;

    //Checks if user input a positive loan amount
    while (loanAmount<0) {

        if (loanAmount < 0) {
            cout << "Please enter a Positive Loan Amount : ";
            cin >> loanAmount;
        }
    }

    //continues user inputs
    cout<<"Interest Rate (% per year) : ";
    cin>>interestRate;

    //Checks if Interest rate is negative and if user still wants to input negative interest
    if (interestRate < 0) {
        cout << "Are you sure your interest rate is negative?" << endl;
        cout << "Please type your interest rate correctly to confirm: ";
        cin >> interestRate;
    }

    cout<<"Monthly Payments : ";
    cin>>monthPay;

    //Checks to make sure Monthly Pay is positive
    while (monthPay < 0) {
        if (monthPay < 0) {
            cout << "Enter a positive Monthly Pay: ";
            cin >> monthPay;
        }
    }

    //Amortization Table Header
    cout<<"**********************************************************"<<endl;
    cout<<"                   Amortization Table"<<endl;
    cout<<"**********************************************************"<<endl;
    cout<<std::left<<std::setw(9)<<"Month"<<std::left<<std::setw(10)<<"Balance"<<std::left<<std::setw(10)<<"Payment"<<std::left<<std::setw(9)<<"Rate"<<std::left<<std::setw(11)<<"Interest"<<"Principal"<<endl;
    cout<<std::left<<std::setw(9)<<"0"<<"$"<<std::left<<std::setw(11)<<loanAmount<<std::left<<std::setw(9)<<"N/A"<<std::left<<std::setw(10)<<"N/A"<<std::left<<std::setw(12)<<"N/A"<<std::left<<std::setw(9)<<"N/A"<<endl;

    //Values
    int month=0;
    float interest;
    float totalInterest=0;
    float payment = monthPay;
    float rate = interestRate/12;
    float principal = 0;

    //Loop to calculate various things
    while(loanAmount>0){
        month++;
        interest = loanAmount*interestRate/1200;

        //calculates value for payment
        if (monthPay > loanAmount + interest) {
            payment = loanAmount + interest;
        }

        loanAmount -=(monthPay - interest);

        //checks if payment is negative
        if (payment<0) {
            payment = 0;
        }

        //checks if loan amount is negative
        if(loanAmount<0){
            loanAmount = 0;
        }

        principal = payment - interest;

        //checks if principal is negative
        if (principal<0){
            principal=0;
        }

        totalInterest+=interest;

        //Printed statement in loop
        cout<<std::left<<std::setw(9)<<month<<"$"<<std::left<<std::setw(11)<<loanAmount<<"$"<<std::left<<std::setw(8)
        <<payment<<std::left<<std::setw(8)<<rate<<"$"<<std::left<<std::setw(11)<<interest<<"$"<<principal<<endl;
    }

    //printed statement after loop
    cout<<"**********************************************************"<<endl;
    cout<<" "<<endl;
    cout<<"It takes "<<month<<" months to pay off the loan."<<endl;
    cout<<"Total interest paid is: $"<<totalInterest<<endl;



    return 0;
}