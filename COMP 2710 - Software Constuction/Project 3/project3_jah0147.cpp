/*
 * Author: Jacob Howard
 * User Id: jah0147
 * File Name: project3_jah0147.cpp
 * Compile with g++
 * I received help with this project
 */

#include <fstream>
#include <iostream>
#include <cstdlib>
#include <string>
#include <cassert>

using namespace std;

// initializing the Arrays
const int MAX_SIZE = 100;

// Initializing methods
int readfile(int inputArray[], ifstream& instream);
int sort(int inputArray1[], int inputArray1_size, int inputArray2[], int inputArray2_size, int outputArray[]);
void writefile(int outputArray[], int outputArray_size, ofstream& outStream);



int readfile(int inputArray[], ifstream& inStream)
// Reads in file and places it in an Array
{
    int index = 0;

    inStream >> inputArray[index];
    while (! inStream.eof()) {
        index++;
        inStream >> inputArray[index];
    }

    return index;
}

int sort(int inputArray1[], int inputArray1_size, int inputArray2[], int inputArray2_size, int outputArray[])
// Sorts the combined elements from inputArray1 and 2 placed in ascending order in the outputArray
{
    int outputArray_size = inputArray1_size + inputArray2_size;

    // Establishes index variables for inputArray 1, 2, and 3
    int index1;
    int index2;
    int index3;

    // Sets index pointer to 0 before sorting
    index1 = 0;
    index2 = 0;
    index3 = 0;

    while(index1 < inputArray1_size && index2 < inputArray2_size)
        // Adds elements from inputArray1 and inputArray2 to the outputArray
    {
        if(inputArray1[index1] < inputArray2[index2])
        {
            outputArray[index3] = inputArray1[index1];
            index1++;
            index3++;
        }
        else
        {
            outputArray[index3] = inputArray2[index2];
            index2++;
            index3++;
        }
    }

    if(index1 == inputArray1_size)
        // Continues to add values from inputArray2 to the outputArray even if the sizes differ (inputArray1 > inputArray2)
    {
        while(index2 < inputArray2_size)
        {
            outputArray[index3] = inputArray2[index2];
            index2++;
            index3++;
        }
    }
    else
    {
        while(index1 < inputArray1_size)
            // Continues to add values from inputArray2 to the outputArray even if the sizes differ (inputArray2 > inputArray1)
        {
            outputArray[index3] = inputArray1[index1];
            index1++;
            index3++;
        }
    }

    assert(index3 == outputArray_size);
    return outputArray_size;
}




void writefile(int outputArray[], int outputArray_size, ofstream& outstream)
// Writes the array elements to an output file
{
    for(int x = 0; x < outputArray_size; x++)
    {
        outstream << outputArray[x] << endl;
    }
}

int main()
{
    // represents the incoming file
    ifstream inStreamFirst;
    ofstream outStream;

    int tempArray1[MAX_SIZE];  // initializes a temporary Array (for input1.txt) of size 100
    int tempArray1_size;  // size of tempArray1
    std::string inputFile1;

    int tempArray2[MAX_SIZE]; // initializes a temporary Array (for input2.txt) of size 100
    int tempArray2_size; // size of tempArray2
    std::string inputFile2;

    int outputArray[MAX_SIZE]; // The array the program returns
    int outputSize; // size of output array
    std::string outputFile;

    cout << "*** Welcome to Jacob Howard's sorting program ***\n";
    cout << "Enter the first input file name: "; // Prompts for first file
    cin >> inputFile1; // Places contents of input1.txt in inputFile1


    inStreamFirst.open((char*)inputFile1.c_str());

    tempArray1_size = readfile(tempArray1, inStreamFirst);   // Reads in first file
    inStreamFirst.close();
    inStreamFirst.clear();

    // Loop that prints the elements in file 1
    cout << "The list of " << tempArray1_size << " numbers in file " << inputFile1 << " is:\n";
    for (int i = 0; i < tempArray1_size; i++)
    {
        cout << tempArray1[i];
        cout << "\n";
    }

    cout << "\nEnter the second input file name: "; // Asks for second file
    cin >> inputFile2; // Places contents of input2.txt in inputFile2

    inStreamFirst.open((char*)inputFile2.c_str());

    tempArray2_size = readfile(tempArray2, inStreamFirst); // Reads in second file
    inStreamFirst.close();
    inStreamFirst.clear();

    // Loop that prints the elements in file 2
    cout << "The list of " << tempArray2_size << " numbers in file " << inputFile2 << " is:\n";
    for (int i = 0; i < tempArray2_size; i++)
    {
        cout << tempArray2[i];
        cout << "\n";
    }

    outputSize = sort(tempArray1, tempArray1_size, tempArray2, tempArray2_size, outputArray); // Sorts the elements in Arrays

    // Loop that prints the sorted elements in the output array
    cout << "The sorted list of " << outputSize << " numbers is: ";
    for (int i = 0; i < outputSize; i++)
    {
        cout << outputArray[i] << " ";
    }

    cout << "\nEnter the output file name: "; // Prompts for output file
    cin >> outputFile;
    outStream.open((char*)outputFile.c_str());


    writefile(outputArray, outputSize, outStream); // Writes output File
    cout << "*** Please check the new file - " << outputFile << " ***\n";
    cout << "*** Goodbye ***\n";

    return 0;
}