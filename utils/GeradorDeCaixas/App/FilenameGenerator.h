// FilenameGenerator.h : Responsável por gerar nomes de arquivos
#pragma once
#include "Generator.h"


class FilenameGenerator
	: public Generator
{
public:
	FilenameGenerator(const char* path, const size_t index);
	~FilenameGenerator();


public:
	// Funções implementadas
	void generate(std::ostream& output);


private:
	// Dados membro
	const char* _path;
	size_t _index;
};

