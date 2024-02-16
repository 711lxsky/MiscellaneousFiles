#include <iostream>
#include <string>

using namespace std;

int main()
{

    string str1 = "this is a test sentence.";
    const char * ch_ptr = str1.c_str();
    int i = 0, strLen1 = str1.length();
    while (ch_ptr[i])
    {
        cout << ch_ptr[i++] << " - ";
    }
    

    return 0;
}