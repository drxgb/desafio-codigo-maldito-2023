// BoxGeneratorInput.cpp : Implementa��o da classe BoxGeneratorInput
#include "BoxGeneratorInput.h"


bool BoxGeneratorInput::validated(char** input)
{
	return input[1] && input[2];
}
