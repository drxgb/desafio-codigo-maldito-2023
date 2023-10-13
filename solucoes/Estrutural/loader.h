#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "Toy.h"

void loadBox(enum Toy* box, const size_t capacity, const char* filename);
enum Toy getToyByName(const char* name);


void loadBox(enum Toy* box, const size_t capacity, const char* filename)
{
	FILE* file;
	char* item;

	fopen_s(&file, filename, "r");
	if (file)
	{
		size_t i = 0;

		item = (char*)malloc(sizeof(char) * 15);
		do
		{
			*item = '\0';
			fgets(item, 15, file);
			if (*item)
			{
				if (item[strlen(item) - 1] == '\n')
					item[strlen(item) - 1] = '\0';
				box[i] = getToyByName(item);
				++i;
			}
		} while (*item);

		fclose(file);
		free(item);
	}
}


enum Toy getToyByName(const char* name)
{
	if (!strcmp(name, TOY_ARANHA))
		return ARANHA;
	if (!strcmp(name, TOY_SAPO))
		return SAPO;
	if (!strcmp(name, TOY_DENTADURA))
		return DENTADURA;
	if (!strcmp(name, TOY_FANTASIMNHA))
		return FANTASMINHA;
	if (!strcmp(name, TOY_BRUXINHA))
		return BRUXINHA;

	return (enum Toy)0;
}
