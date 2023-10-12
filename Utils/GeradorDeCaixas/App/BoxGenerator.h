// BoxGenerator.h : Respons�vel por gerar conte�do nas caixas
#pragma once
#include "Generator.h"
#include <vector>

using std::vector;


class BoxGenerator
	: public Generator
{
public:
	BoxGenerator(
		vector<const char*>::const_iterator begin,
		vector<const char*>::const_iterator end,
		const size_t size
	);
	~BoxGenerator();

public:
	// Fun��es implementadas
	void generate(std::ostream& output);


private:
	// Dados membro
	vector<const char*> _items;
	size_t _size;
};
