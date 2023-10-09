#include <iostream>
#include <locale>
#include <vector>
#include <stdexcept>
#include "App/Application.h"
#include "App/BoxGeneratorInput.h"


int main(int argc, char** argv)
{
	Input* input;
	char* path;
	int count;

	setlocale(LC_ALL, "portuguese");
	input = new BoxGeneratorInput;

	if (input->validated(argv))
	{
		path = argv[1];
		count = atoi(argv[2]);
	}
	else
	{
		path = (char*)"caixas";
		count = 0;
	}

	try
	{
		std::vector<const char*> items{ "ARANHA", "SAPO", "DENTADURAS", "FANTASMINHA", "BRUXINHA" };
		Application app(std::cout, count);

		app.setItems(items.begin(), items.end());
		app.start(path);
	}
	catch (std::exception& e)
	{
		std::cerr << e.what() << std::endl;
		return 1;
	}

	return 0;
}
