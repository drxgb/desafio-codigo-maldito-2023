#include "Toy.h"
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void loadBoxes(
	enum Toy** boxes,
	size_t size,
	const char* path,
	const char* filename,
	const char* extension);
void getFullPath(char** fullName, size_t index, const char* path, const char* filename, const char* extension);
enum Toy getToyByName(const char* name);


void loadBoxes(enum Toy** boxes, size_t size, const char* path, const char* filename, const char* extension)
{
	FILE* file;
	char* fullName;
	char item[15];

	for (size_t i = 0; i < size; ++i)
	{
		getFullPath(&fullName, i + 1, path, filename, extension);
		fopen_s(&file, fullName, "r");

		if (file)
		{
			size_t j = 0;
			do
			{
				*item = '\0';
				fgets(item, 15, file);
				if (*item)
				{
					if (item[strlen(item) - 1] == '\n')
						item[strlen(item) - 1] = '\0';
					boxes[i][j] = getToyByName(item);
					++j;
				}
			} while (*item);
		}

		fclose(file);
		free(fullName);
	}
}


void getFullPath(char** fullName, size_t index, const char* path, const char* filename, const char* extension)
{
	char num[6];

	*fullName = (char*)malloc(sizeof(char) * FILENAME_MAX);
	for (size_t i = 0; i < FILENAME_MAX; ++i)
		*(*fullName + 1) = '\0';

	_itoa_s((int)index, num, 6, 10);
	strcpy_s(*fullName, FILENAME_MAX, path);
	strcat_s(*fullName, FILENAME_MAX, "\\");
	strcat_s(*fullName, FILENAME_MAX, filename);
	strcat_s(*fullName, FILENAME_MAX, num);
	strcat_s(*fullName, FILENAME_MAX, extension);
}


enum Toy getToyByName(const char* name)
{
	if (!strcmp(name, "ARANHA"))
		return ARANHA;
	if (!strcmp(name, "SAPO"))
		return SAPO;
	if (!strcmp(name, "DENTADURA"))
		return DENTADURA;
	if (!strcmp(name, "FANTASMINHA"))
		return FANTASMINHA;
	if (!strcmp(name, "BRUXINHA"))
		return BRUXINHA;

	return (enum Toy)0;
}
