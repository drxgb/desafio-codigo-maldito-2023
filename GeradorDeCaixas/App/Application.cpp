// Application.cpp : Implementação da classe Application
#include "Application.h"
#include "BoxGenerator.h"
#include "FilenameGenerator.h"
#include <algorithm>
#include <fstream>
#include <sstream>
#include <stdexcept>

using std::endl;
using std::ofstream;
using std::stringstream;

constexpr const size_t LIST_SIZE = 20U;
constexpr const size_t MIN_SIZE = 3U;


Application::Application(ostream& output, size_t count)
	: _output(output)
{
	if (!count)
		count = rand() % 10 + 1;

	_count = count;
}

Application::~Application()
{
	_items.clear();
}

void Application::start(const char* input)
{
	Generator* filenameGenerator;
	Generator* boxGenerator;

	assertItemListIsNotEmpty();
	_output << "Caminho de saída: " << input << '\n' << endl;

	for (size_t i = 0; i < _count; ++i)
	{
		stringstream ss;
		string filename;
		size_t size;
		ofstream file;

		size = rand() % (LIST_SIZE - MIN_SIZE) + MIN_SIZE;
		filenameGenerator = new FilenameGenerator(input, i + 1);
		boxGenerator = new BoxGenerator(_items.begin(), _items.end(), size);
		
		filenameGenerator->generate(ss);
		filename = ss.str();
		file.open(filename, std::ios_base::out);
		
		if (!file)
		{
			ss.clear();
			ss << "Não foi possível abrir o arquivo " << filename << "!";
			throw std::exception(ss.str().c_str());
		}

		_output << "Gerando: " << filename << "... ";
		boxGenerator->generate(file);
		_output << "OK" << endl;

		delete filenameGenerator;
		delete boxGenerator;
		filenameGenerator = nullptr;
		boxGenerator = nullptr;
	}
}

void Application::setItems(vector<const char*>::const_iterator begin, vector<const char*>::const_iterator end)
{
	_items.resize(end - begin);
	std::copy(begin, end, _items.begin());
}

void Application::assertItemListIsNotEmpty()
{
	if (_items.empty())
		throw std::exception("A lista de itens está vazia!");
}
