#include <bits/stdc++.h>

using namespace std;
int main()
{
    int n, a;

    cin >> n;
    vector<int> nums;
    for (int k = 0; k < n; k++)
    {
        cin >> a;
        nums.push_back(a);
    }
    for (size_t i = 0; i < nums.size(); ++i)
    {

        for (size_t j = i + 1; j < nums.size(); ++j)
        {
            if (nums[i] == nums[j])
            {
                cout << "true";
                abort();
            }
        }
    }
    cout << "false";
}