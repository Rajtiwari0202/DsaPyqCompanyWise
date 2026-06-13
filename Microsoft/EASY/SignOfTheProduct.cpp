#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    int arraySign(vector<int>& nums) {
        int count = 0;

        for (int num : nums) {
            if (num == 0) return 0;
            if (num < 0) count++;
        }

        return count % 2 == 1 ? -1 : 1;
    }
};

int main() {
    vector<int> arr = {5, -2, -1, 9, -1};

    Solution sol;
    cout << sol.arraySign(arr);

    return 0;
}