// Input.h : Interface respons�vel por tratar entradas enviadas pelo programa
#pragma once


class Input
{
public:
	// Fun��es virtuais puras
	virtual bool validated(char** input) = 0;
};
