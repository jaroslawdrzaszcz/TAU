#include <catch2/catch.hpp>

#include <src/db.hpp>
#include <test/test_struct.hpp>
#include <map>
#include <memory>
#include <list>

using namespace std;

TEST_CASE("Basic database object operations", "[database_c][constructors]") {

  SECTION("The database object can be created") {

    REQUIRE_NOTHROW([]() { database_c<car_db> db; });
  }
  SECTION("Simple dependency injection works") {
    auto container = make_shared<map<int, car_db>>();
    database_c<car_db> db(container);
    REQUIRE_FALSE(db.get_container() == nullptr);
    REQUIRE(db.get_container() == container.get());
  }
}

TEST_CASE("Getting data from the database", "[database_c][get_all]") {
    auto container = make_shared<map<int, car_db>>();
    database_c<car_db> db(container);
    SECTION("simple get all is present") {
        REQUIRE_NOTHROW( db.get_all() );
    }
    SECTION("simple get all is present") {
        list<car_db> ret_list = db.get_all();
        REQUIRE(ret_list.size() == 0);
    }
    SECTION("simple get all is present") {
        (*container)[0] = {0,"GD1234", "Fiat"};
        list<car_db> ret_list = db.get_all();
        REQUIRE(db.get_container() == container.get());
        REQUIRE(db.get_container()->size() ==1);
        REQUIRE(ret_list.size() == 1);
    }
}

TEST_CASE("Getting data by id from the database", "[database_c][get_by_d]") {
    auto container = make_shared<map<int, car_db>>();
    database_c<car_db> db(container);
    int id;
    SECTION("simple get by id is present") {
        REQUIRE_NOTHROW( db.get_by_id(id) );
    }
    SECTION("simple get by id") {
        (*container)[0] = {0,"GD1234", "Fiat"};
        car_db ret = db.get_by_id(0);
        REQUIRE(db.get_container() == container.get());
        REQUIRE(db.get_container()->size() ==1);
        REQUIRE(ret.id == 0);
    }
    SECTION("get by id with no such element in database") {
        (*container)[0] = {0,"GD1234", "Fiat"};
        REQUIRE(db.get_container() == container.get());
        REQUIRE(db.get_container()->size() ==1);
        REQUIRE_THROWS( db.get_by_id(1) );
    }
}

TEST_CASE("Adding new element to the database", "[database_c][add]") {
    auto container = make_shared<map<int, car_db>>();
    database_c<car_db> db(container);
    car_db e;
    SECTION("simple add new element is present") {
        REQUIRE_NOTHROW( db.add(e) );
    }
    SECTION("simple get by id is present") {
        e = {0,"GD1234", "Fiat"};
        list<car_db> ret_list = db.add(e);
        REQUIRE(db.get_container() == container.get());
        REQUIRE(ret_list.size() == 1);
    }
}

TEST_CASE("Removing data by id from the database", "[database_c][remove_by_id]") {
    auto container = make_shared<map<int, car_db>>();
    database_c<car_db> db(container);
    // int id;
    SECTION("simple get by id is present") {
        (*container)[0] = {0,"GD1234", "Fiat"};
        REQUIRE_NOTHROW( db.remove_by_id(0) );
    }
    SECTION("simple get by id is present") {
        (*container)[0] = {0,"GD1234", "Fiat"};
        REQUIRE(db.get_container() == container.get());
        REQUIRE(db.get_container()->size() ==1);
        list<car_db> ret_list = db.remove_by_id(0);
        REQUIRE(ret_list.size() == 0);
    }
}
