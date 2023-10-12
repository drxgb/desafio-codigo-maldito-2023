#include <stdio.h>
#include <stdlib.h>
#include "Kid.h"
#include "loader.h"


// Macros
#define BOX_COUNT 50
#define BOX_CAPACITY 100
#define BAG_CAPACITY 100
#define TRUE 1
#define FALSE 0
#define ZERO_BAG(bag) free(bag); bag = malloc(BAG_CAPACITY * sizeof(bag)); for (unsigned int i = 0; i < BAG_CAPACITY; ++i) { bag[i] = 0; }
#define CHECK_FAVORITE_TOY(kid, toy) if (isFavoriteToy(kid, toy)) { takeToyToBag(kid.bag, toy); }


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
void assertKidsBag(const struct Kid kid);


//=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

int main(int argc, char** argv)
{
	enum Toy** boxes;
	enum Toy* box;
	const char* inputPath = argv[1];

	boxes = (enum Toy**)malloc(sizeof(enum Toy) * BOX_CAPACITY * BOX_COUNT);
	for (size_t i = 0; i < BOX_COUNT; ++i)
	{
		boxes[i] = malloc(sizeof(enum Toy) * BOX_CAPACITY);
		for (size_t j = 0; j < BOX_CAPACITY; ++j)
			boxes[i][j] = 0;
	}

	loadBoxes(boxes, BOX_COUNT, inputPath, "caixa", ".txt");

	for (unsigned int i = 0; i < BOX_COUNT; ++i)
	{
		box = boxes[i];
		if (box)
		{
			printf("Test #%d:\n=========\n", i + 1);
			test(box);
			puts("========================\n");
		}
	}
	free(boxes);
	return 0;
}


// Subrotinas
void initialize()
{
	ZERO_BAG(k1.bag)
	ZERO_BAG(k2.bag)
	ZERO_BAG(k3.bag)
	ZERO_BAG(k4.bag)
	ZERO_BAG(k5.bag)
}


void distributeToys(enum Toy* toys)
{
	enum Toy toy;

	while (*toys)
	{
		toy = *toys;

		CHECK_FAVORITE_TOY(k1, toy)
		else CHECK_FAVORITE_TOY(k2, toy)
		else CHECK_FAVORITE_TOY(k3, toy)
		else CHECK_FAVORITE_TOY(k4, toy)
		else CHECK_FAVORITE_TOY(k5, toy)

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
			printf("ARANHA");
			break;
		case SAPO:
			printf("SAPO");
			break;
		case DENTADURA:
			printf("DENTADURA");
			break;
		case FANTASMINHA:
			printf("FANTASMINHA");
			break;
		case BRUXINHA:
			printf("BRUXINHA");
			break;
		}
		printf(" ");
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
	printBag(box);
	distributeToys(box);
	assertKidsBag(k1);
	assertKidsBag(k2);
	assertKidsBag(k3);
	assertKidsBag(k4);
	assertKidsBag(k5);
}


void assertKidsBag(const struct Kid kid)
{
	unsigned int result;
	enum Toy* bag = kid.bag;

	result = 1U;
	while (*bag)
	{
		if (!isFavoriteToy(kid, *bag))
		{
			result = 0U;
			break;
		}
		++bag;
	}

	printKidsBag(kid);

	if (result)
		puts("\tPassed!");
	else
		puts("\tFailed!");
}
