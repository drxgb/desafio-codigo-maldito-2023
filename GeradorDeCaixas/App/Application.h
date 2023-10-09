// Application.h : Fachada da aplica��o principal
#pragma once
#include <ostream>
#include <vector>

using std::string;
using std::ostream;
using std::vector;


class Application
{
public:
	Application(ostream& output, size_t count = 0);
	~Application();


public:
	// Fun��es membro
	void start(const char* input);
	void setItems(vector<const char*>::const_iterator begin, vector<const char*>::const_iterator end);


private:
	// Dados membro
	ostream& _output;
	size_t _count;
	vector<const char*> _items;

	// Fun��es utilit�rias
	void assertItemListIsNotEmpty();
};

