// Input.h : Interface responsável por tratar entradas enviadas pelo programa
#pragma once


class Input
{
public:
	// Funções virtuais puras
	virtual bool validated(char** input) = 0;
};
