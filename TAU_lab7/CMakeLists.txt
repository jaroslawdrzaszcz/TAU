cmake_minimum_required(VERSION 3.5)

project(jd-db-catch2-cmake LANGUAGES CXX VERSION 0.0.1)
set(CMAKE_CXX_FLAGS "-std=c++17 -Wall -Wextra")
include_directories("${PROJECT_SOURCE_DIR}")
file(GLOB_RECURSE lib_SOURCES "src/*.cpp" "src/*/*.cpp")
file(GLOB_RECURSE test_SOURCES "test/*.cpp")

find_package(Catch2 REQUIRED)

add_executable(jd-db-catch2-cmake-test ${test_SOURCES})

include(CTest)
include(Catch)
catch_discover_tests(jd-db-catch2-cmake-test)
