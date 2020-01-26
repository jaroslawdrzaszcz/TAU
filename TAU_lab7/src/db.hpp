#ifndef __MY_AWESOME_DATABASE_HPP___
#define __MY_AWESOME_DATABASE_HPP___

#include <memory>
#include <map>
#include <list>

#include <iostream>

template<class entity_t>
class database_c{
protected:
std::shared_ptr<std::map<int, entity_t>> _container;
public:
    database_c(std::shared_ptr<std::map<int, entity_t>> container_ = std::make_shared<std::map<int, entity_t>>()) {
        _container = container_;
    }
    std::map<int, entity_t> *get_container() const {
        return _container.get();
    }

    std::list<entity_t> get_all(){
        std::list<entity_t> ret;
        for (auto [k,v]:*_container) ret.push_back(v);
        return ret;
    }

    entity_t get_by_id(int id){
        entity_t ret;
        for (auto [k,v]:*_container){
            if(k==id) ret = v;
            else
            {
                throw "There is no such element in database";
            }
        };
        return ret;
    }

    std::list<entity_t> add(entity_t e){
        std::list<entity_t> ret;
        ret.push_back(e);
        return ret;
    }

    std::list<entity_t> remove_by_id(int id){
        std::list<entity_t> db;
        for (auto [k,v]:*_container){
            if(k!=id) db.push_back(v);
        };
        return db;
    }
};

#endif