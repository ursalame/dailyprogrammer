import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Pacman {
    private Node current;

    public Pacman(String map) {
        MapParser mp = new MapParser();
        current = mp.parse(map);
    }

    public int getMaximumPacgums(int time) {
        return getMaximumPoints(current, time);
    }

    private Integer getMaximumPoints(Node node, int time) {
        return getMaximumPoints(node, time, true);
    }

    private Integer getMaximumPoints(Node node, int time, boolean allowWrap) {
        if (node == null || time < 0 || node.isUsed()) {
            return 0;
        }

        node.toggleUsed();

        List<Integer> list = new ArrayList<>();

        list.add(getMaximumPoints(node.getUp(), time - 1));
        list.add(getMaximumPoints(node.getLeft(), time - 1));
        list.add(getMaximumPoints(node.getRight(), time - 1));
        list.add(getMaximumPoints(node.getDown(), time - 1));
        if (allowWrap) {
            list.add(getMaximumPoints(node.getWrap(), time, false));
        }

        node.toggleUsed();

        int currentValue = (node != this.current) ? node.getValue() : 0;

        return Collections.max(list) + currentValue;
    }
}
