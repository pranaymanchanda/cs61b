public class OffByOne implements CharacterComparator {
    @Override
    public boolean equalChars(char a, char b){
        int copy_a = a;
        int copy_b = b;
        return (Math.abs(copy_a - copy_b) == 1);
    }
}
