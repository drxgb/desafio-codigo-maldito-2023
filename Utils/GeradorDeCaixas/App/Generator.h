// Generator.h : Interface respons�vel por gerar dados para um fluxo dado
#pragma once
#include <ostream>


class Generator
{
public:
	virtual void generate(std::ostream& output) = 0;
};
