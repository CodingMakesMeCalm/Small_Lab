#pragma once

#include "LinkedList.h"

template <typename T>
class Sorter
{
public:

	using predicate_function = bool(*)(const T& lhs, const T& rhs);

	//do not modify the signature of this function
	explicit Sorter(LinkedList<T>& list, const predicate_function predicate = [](const T& a, const T& b) { return a < b; })
	{
		//
		////put your selection sorting code here
		auto* currenti = list.begin();
		for (int i = 0; i < list.size() - 1; i++) {
			auto* currentj = currenti->next;
			auto* mindata = currenti;
			for (int j = i + 1; j < list.size(); j++) {
				if (predicate(currentj->data, mindata->data)) {
					mindata = currentj;
				}
				currentj = currentj->next;
			}

			T temp = mindata->data;
			mindata->data = currenti->data;
			currenti->data = temp;

			currenti = currenti->next;
		}

		




	}
};

