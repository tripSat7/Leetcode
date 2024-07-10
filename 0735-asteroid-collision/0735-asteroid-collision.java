class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int[] stack = new int[asteroids.length];
        int top = -1;

        for (int asteroid : asteroids) {
            if (top == -1)
                stack[++top] = asteroid;
            else {
                if (asteroid < 0) {
                    if (stack[top] < 0) {
                        stack[++top] = asteroid;
                    } else {
                        while (top != -1 && stack[top] >= 0 && Math.abs(asteroid) > stack[top]) {
                            top--;
                        }

                        if (top >= 0) {
                            if (stack[top] == Math.abs(asteroid)) {
                                top--;
                            } else if (stack[top] < 0) {
                                stack[++top] = asteroid;
                            }
                        } else {
                            stack[++top] = asteroid;
                        }
                    }
                } else {
                    stack[++top] = asteroid;
                }
            }
        }

        int[] ans = new int[top + 1];
        while (top >= 0) {
            ans[top] = stack[top];
            top--;
        }

        return ans;
    }
}