//============================================================================
// Name        : C++.cpp
// Author      : Haruna Kibirige
// Version     :
// Copyright   : Based off of the Cracking the Coding Interview
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>

using namespace std;

#define NAME_SIZE 50 //Define a macro

/*
 * Program introducing classes and inheritance in C++
 * Constructors and Destructors
 * Virtual functions
 * Default Values
 * Pointers
 */
class Person{
	//by default members are private
	int id;
	char name[NAME_SIZE];

public:
	virtual ~Person(){
		cout<<"Deleting a person"<<endl;
	}
	virtual void aboutMe(){
		cout<<"I am a person"<<endl;
	}
	virtual bool addCourse(string s) = 0;
};

class Student:public Person {
public:
	~Student(){
		cout<<"Deleting a Student"<<endl;
	}
	void aboutMe(){
		cout<<"I am a student"<<endl;
	}
	bool addCourse(string s){
		cout<<"Added Course "<<s<<" to student"<<endl;
		return true;
	}
};

int Multiply(int a,int b=1){
	return a*b;
}

void testPointers(){
	int *p = new int;
	*p = 7;
	int *q = p;
	*p = 8;
	cout<<"P is now "<<*q<<endl;
}

void testRefs(){
	int a = 5;
	int & b = a;
	b = 7;
	cout<<"A is now "<<a<<endl;
}

int main() {
	Person * p = new Student();
	p->aboutMe();
	p->addCourse("History");
	int a=4,b=5;
	cout<<a<<" * "<<b<<" = "<<Multiply(a,b)<<endl;
	cout<<a<<" * "<<1<<" = "<<Multiply(a)<<endl;
	testPointers();
	testRefs();
	delete p;//make sure to delete allocated memory
	return 0;
}

