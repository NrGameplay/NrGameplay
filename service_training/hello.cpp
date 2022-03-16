#include<iostream>
#include <ctime>
#include <unistd.h>

using namespace std;

int main()
{
	while(1)
	{
		time_t now = time(0);

		// convert now to string form
		char* date_time = ctime(&now);

		cout << "Hello world --> The current date and time is: " << date_time << endl;
		sleep(2);

	}
}
