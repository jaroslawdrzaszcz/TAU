#ifndef __CAR_DB_STRUCT_HPP__
#define __CAR_DB_STRUCT_HPP__

#include <catch2/catch.hpp>
using namespace std;
struct car_db;

struct car_db {
  int id;
  string registration;
  string brand;
};

inline ostream & operator<<(ostream &o, const car_db &d) {
    o<<"[" << d.id << ", " << d.registration << ", " << d.brand << "]";
    return o;
}

#endif