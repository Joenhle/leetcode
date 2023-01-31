class Solution {
public:
    int minFlips(int a, int b, int c) {
        int num = 0;
        for(int i = 0; i < 32; ++i) {
            int temp = 1 << i;
            if (((temp & a) | (temp & b)) == (temp & c)) {
                continue;
            }
            num++;
            if ((temp & c) == 0 && (temp & a) != 0 && (temp & b) != 0) {
                num++;
            }
        }
        return num;
    }
};
