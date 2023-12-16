public class OffByN implements CharacterComparator{
    int n;
    public OffByN(int N){
        n = N;
    }
    @Override
    public boolean equalChars(char a, char b){
        int A = a;
        int B = b;
        return (Math.abs(A - B) == 5);
    }
}
