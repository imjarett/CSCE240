#include <iostream>
#include <vector>
#include <algorithm>
#include <string>
#include <unordered_map>
#include <cstdlib>
#include <ctime>
#include "RandomNameGenerator.hpp"

// Generate fake names using RandomNameGenerator
std::vector<std::string> generateFakeNames(int count) {
    std::vector<std::string> names;
    RandomNameGenerator nameGen;

    for (int i = 0; i < count; ++i) {
        names.push_back(nameGen.generateName());
    }

    return names;
}

// Sort names as strings
void sortNamesAsString(std::vector<std::string>& names) {
    std::sort(names.begin(), names.end());
}

// Sort names based on numeric identifier
void sortNamesWithNumericIdentifier(std::vector<std::string>& names) {
    std::unordered_map<int, std::string> nameMap;

    // Generate numeric identifiers for names
    for (const auto& name : names) {
        int identifier = std::hash<std::string>{}(name);
        nameMap[identifier] = name;
    }

    // Sort based on numeric identifiers
    names.clear();
    for (const auto& pair : nameMap) {
        names.push_back(pair.second);
    }
}

int main() {
    const int CLASS_SIZE = 15;
    const int REPLICATION_FACTOR = 100;

    // Generate fake names
    std::vector<std::string> names = generateFakeNames(CLASS_SIZE);

    // Replicate names
    std::vector<std::string> replicatedNames;
    for (const auto& name : names) {
        for (int i = 0; i < REPLICATION_FACTOR; ++i) {
            replicatedNames.push_back(name);
        }
    }

    // Sort names as strings
    sortNamesAsString(replicatedNames);
    std::cout << "Sorted names as strings:" << std::endl;
    for (const auto& name : replicatedNames) {
        std::cout << name << std::endl;
    }

    // Sort names with numeric identifier
    sortNamesWithNumericIdentifier(replicatedNames);
    std::cout << "\nSorted names with numeric identifier:" << std::endl;
    for (const auto& name : replicatedNames) {
        std::cout << name << std::endl;
    }

    return 0;
}