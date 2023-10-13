#include <stdio.h>
#include <stdlib.h>
#include "Kid.h"
#include "loader.h"


// Macros
#define BOX_CAPACITY 100
#define BAG_CAPACITY BOX_CAPACITY
#define ZERO_TOYS(list, capacity) free(list); list = malloc(capacity * sizeof(enum Toy*)); for (unsigned int i = 0; i < capacity; ++i) { list[i] = 0; }
#define CHECK_FAVORITE_TOY(kid, toy) (isFavoriteToy(kid, toy)) { takeToyToBag(kid.bag, toy); }


// Tipos
typedef char bool;


// Dados
struct Kid k1 = { "Samuel", SAPO, 0 };
struct Kid k2 = { "Franklin", ARANHA, 0 };
struct Kid k3 = { "Hellen", FANTASMINHA, 0 };
struct Kid k4 = { "JC", BRUXINHA, 0 };
struct Kid k5 = { "Daniel", DENTADURA, 0 };


// Protótipos
void initialize();
void distributeToys(enum Toy* toys);
bool isFavoriteToy(const struct Kid kid, const enum Toy toy);
void takeToyToBag(enum Toy* bag, const enum Toy toy);
void printBag(const enum Toy* bag);
void printKidsBag(const struct Kid kid);

void test(enum Toy* box);


//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

int main(int argc, char** argv)
{
	enum Toy* box = 0;
	const char* inputPath = argv[1];

	if (!inputPath)
	{
		puts("ERRO: Não foi possível encontrar o arquivo da caixa de brinquedos");
		return 1;
	}

	ZERO_TOYS(box, BOX_CAPACITY);
	loadBox(box, BOX_CAPACITY, inputPath);
	test(box);
	free(box);

	return 0;
}


// Subrotinas
void initialize()
{
	ZERO_TOYS(k1.bag, BAG_CAPACITY)
	ZERO_TOYS(k2.bag, BAG_CAPACITY)
	ZERO_TOYS(k3.bag, BAG_CAPACITY)
	ZERO_TOYS(k4.bag, BAG_CAPACITY)
	ZERO_TOYS(k5.bag, BAG_CAPACITY)
}


void distributeToys(enum Toy* toys)
{
	enum Toy toy;

	while (*toys)
	{
		toy = *toys;

		if CHECK_FAVORITE_TOY(k1, toy)
		else if CHECK_FAVORITE_TOY(k2, toy)
		else if CHECK_FAVORITE_TOY(k3, toy)
		else if CHECK_FAVORITE_TOY(k4, toy)
		else if CHECK_FAVORITE_TOY(k5, toy)

		*toys++ = 0;
	}
}


bool isFavoriteToy(const struct Kid kid, const enum Toy toy)
{
	return kid.favoriteToy == toy;
}


void takeToyToBag(enum Toy* bag, const enum Toy toy)
{
	while (*bag)
		++bag;
	*bag = toy;
}


void printBag(const enum Toy* bag)
{
	printf("[ ");
	while (*bag)
	{
		switch (*bag)
		{
		case ARANHA:
			printf(TOY_ARANHA);
			break;
		case SAPO:
			printf(TOY_SAPO);
			break;
		case DENTADURA:
			printf(TOY_DENTADURA);
			break;
		case FANTASMINHA:
			printf(TOY_FANTASIMNHA);
			break;
		case BRUXINHA:
			printf(TOY_BRUXINHA);
			break;
		}
		printf(", ");
		++bag;
	}
	puts("]");
}


void printKidsBag(const struct Kid kid)
{
	printf("%s: ", kid.name);
	printBag(kid.bag);
}


void test(enum Toy* box)
{
	initialize();
	distributeToys(box);
	printKidsBag(k1);
	printKidsBag(k2);
	printKidsBag(k3);
	printKidsBag(k4);
	printKidsBag(k5);
}
