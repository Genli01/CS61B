/**
 * Created by Gen on 4/23/17.
 */
public class OffByOne implements CharacterComparator {
    @Override
    public boolean equalChars(char x, char y) {
        return x == y - 1;
    }

/*
    public static void main(String[] args) {
        OffByOne obo = new OffByOne();
        System.out.println(obo.equalChars('a', 'b'));
    }*/
}
