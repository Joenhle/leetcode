#include <algorithm>
#include <queue>
#include <vector>
using namespace std;

class KthLargest {
public:
  priority_queue<int, vector<int>, less<int>> big_heap;
  priority_queue<int, vector<int>, greater<int>> small_heap;
  int k;

  KthLargest(int k, vector<int> &nums) {
    this->k = k;
    for (auto i : nums) {
      small_heap.push(-1 * i);
    }
    for (int i = 0; i < k; ++i) {
      if (!small_heap.empty()) {
        big_heap.push(small_heap.top());
        small_heap.pop();
      }
    }
  }

  int add(int val) {
	  val *= -1;
	  if (big_heap.size() < k) {
	  	small_heap.push(val);
		while(big_heap.size() < k) {
			big_heap.push(small_heap.top());
			small_heap.pop();
		}
		return big_heap.top() * -1;
	  }
	  if (val >= big_heap.top()) {
	  	small_heap.push(val);
	  } else {
	  	big_heap.push(val);
		small_heap.push(big_heap.top());
		big_heap.pop();
	  }
	  return big_heap.top() * -1;
  }
};

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest* obj = new KthLargest(k, nums);
 * int param_1 = obj->add(val);
 */
