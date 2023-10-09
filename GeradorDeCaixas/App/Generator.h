// Generator.h : Interface responsável por gerar dados para um fluxo dado
#pragma once
#include <ostream>


class Generator
{
public:
	virtual void generate(std::ostream& output) = 0;
};
