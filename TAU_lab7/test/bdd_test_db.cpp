#include <catch2/catch.hpp>

#include <src/db.hpp>
#include <test/test_struct.hpp>
#include <map>
#include <memory>
#include <list>

using namespace std;

SCENARIO("getting data from database","[database_c][bdd][get_all]") {
    auto container = make_shared<map<int, car_db>>();
    database_c<car_db> db(container);
    GIVEN("we have some data in database") {
        (*container)[0] = {0,"GD1234", "Fiat"};
        (*container)[1] = {1,"GD1235", "Polonez"};
        (*container)[2] = {2,"GD1236", "Wardburg"};

        INFO((*container)[0]);
        WHEN("we get them from the database") {
            list<car_db> ret_list = db.get_all();

            THEN("the list should contain 3 elements") {
                CHECK(ret_list.size() == 3);
            }

            THEN("the list should contain element with the GD1235 registration") {
                car_db found;
                for (auto e:ret_list) {
                    if (e.registration == "GD1235") found = e;
                }
                REQUIRE(found.registration =="GD1235");
            }
        }
    }
}

SCENARIO("Removing data from database","[database_c][bdd][get_all]") {
    auto container = make_shared<map<int, car_db>>();
    database_c<car_db> db(container);
    GIVEN("we have some data in database") {
        (*container)[0] = {0,"GD1234", "Fiat"};
        (*container)[1] = {1,"GD1235", "Polonez"};
        (*container)[2] = {2,"GD1236", "Wardburg"};

        INFO((*container)[0]);
        WHEN("we get remove the second element from the database") {
            list<car_db> ret_list = db.remove_by_id(1);

            THEN("the list should contain 2 elements") {
                CHECK(ret_list.size() == 2);
            }

            THEN("the list should't contain element with Polonez brand") {
                car_db found;
                for (auto e:ret_list) {
                    if (e.brand == "Polonez") found = e;
                }
                REQUIRE_FALSE(found.brand =="Polonez");
            }
        }
    }
}