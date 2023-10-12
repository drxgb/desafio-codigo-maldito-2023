// BoxGeneratorInput.h : Implementação do tratamento de entrada recebidas pelo programa
#pragma once
#include "Input.h"


class BoxGeneratorInput : public Input
{
public:
	bool validated(char** input);
};

