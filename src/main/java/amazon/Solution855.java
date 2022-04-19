package amazon;

public class Solution855 {

/**
 * Your ExamRoom object will be instantiated and called as such:
 * ExamRoom obj = new ExamRoom(n);
 * int param_1 = obj.seat();
 * obj.leave(p);
 */
    int[] seats;
    int currentSeats = 0;
    int n;

    public Solution855(int n) {
        this.seats = new int[n];
        this.n = n;
    }

    public int seat() {
        if (this.currentSeats == 0) {
            this.seats[0] = 0;
            this.currentSeats++;
            return 0;
        } else {
            int val = (n - 1) / (2 ^ (this.currentSeats - 1));
            this.seats[this.currentSeats] = val;
            this.currentSeats++;
            return val;
        }
    }

    public void leave(int p) {
        seats[p] = 0;
    }

    public static void main(String[] args) {
        Solution855 examRoom = new Solution855(10);
        int a = examRoom.seat();
        int b = examRoom.seat();
        int c = examRoom.seat();
        int d = examRoom.seat();
        examRoom.leave(4);
        examRoom.seat();
    }
}
