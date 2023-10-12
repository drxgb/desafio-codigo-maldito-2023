// FileGenerator.cpp : Implementação da classe FilenameGenerator
#include "FilenameGenerator.h"

FilenameGenerator::FilenameGenerator(const char* path, const size_t index)
	: _path(path), _index(index)
{}

FilenameGenerator::~FilenameGenerator()
{
	delete _path;
	_path = nullptr;
}

void FilenameGenerator::generate(std::ostream& output)
{
	output << _path << '\\' << "caixa" << _index << ".txt";
}
