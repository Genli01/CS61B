/**
 * Created by Gen on 4/23/17.
 */
public class OffByN implements CharacterComparator {
    private int offset;
    public OffByN(int n) {
        offset = n;
    }

    @Override
    public boolean equalChars(char x, char y) {
        return x == y - offset;
    }
}
