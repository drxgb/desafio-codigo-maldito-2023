// BoxGenerator.cpp : Implementação da classe BoxGenerator
#include "BoxGenerator.h"
#include <algorithm>


BoxGenerator::BoxGenerator(
	vector<const char*>::const_iterator begin,
	vector<const char*>::const_iterator end,
	const size_t size
) : _size(size)
{
	_items.resize(end - begin);
	std::copy(begin, end, _items.begin());
}

BoxGenerator::~BoxGenerator()
{
	_items.clear();
}

void BoxGenerator::generate(std::ostream& output)
{
	for (size_t i = 0; i < _size; ++i)
	{
		vector<const char*>::const_iterator it = _items.begin() + (rand() % _items.size());
		output << *it << '\n';
	}
	output << std::endl;
}
